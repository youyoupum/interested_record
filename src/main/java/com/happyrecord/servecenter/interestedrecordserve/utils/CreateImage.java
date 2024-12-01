package com.happyrecord.servecenter.interestedrecordserve.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.BreakIterator;

public class CreateImage {

  public static BufferedImage createTextImage(String content, String backgroundImageUrl, Font font, int width, int height) throws Exception {
    // 计算左右边距，取宽度的5%
    int margin = (int) (width * 0.05);
    // 计算上下边距，取高度的5%
    int topMargin = (int) (height * 0.05);
    int bottomMargin = (int) (height * 0.05);

    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
    Graphics2D g = image.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    g.setClip(0, 0, width, height);

    // 加载背景图片
    BufferedImage backgroundImage = ImageIO.read(new URL(backgroundImageUrl));
    // 计算背景图片的缩放比例以适应目标尺寸
    double scaleX = (double) width / backgroundImage.getWidth();
    double scaleY = (double) height / backgroundImage.getHeight();
    double scale = Math.max(scaleX, scaleY);
    int scaledWidth = (int) (backgroundImage.getWidth() * scale);
    int scaledHeight = (int) (backgroundImage.getHeight() * scale);
    // 创建一个新的BufferedImage来保存缩放后的背景图片
    BufferedImage scaledBackgroundImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_BGR);
    Graphics2D g2d = scaledBackgroundImage.createGraphics();
    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2d.drawImage(backgroundImage, 0, 0, scaledWidth, scaledHeight, null);
    g2d.dispose();

    // 绘制缩放后的背景图片
    g.drawImage(scaledBackgroundImage, (width - scaledWidth) / 2, (height - scaledHeight) / 2, null);

    g.setColor(Color.black);
    g.setFont(font);

    // 使用BreakIterator进行文字换行
    BreakIterator boundary = BreakIterator.getWordInstance();
    boundary.setText(content);
    int start = boundary.first();
    int end = boundary.next();
    int x = margin;
    int y = topMargin;
    FontMetrics fm = g.getFontMetrics();
    int lineHeight = fm.getHeight();
    int maxChars = 50; // 最多显示50个字符
    int currentChars = 0; // 当前已显示的字符数

    while (end!= BreakIterator.DONE && currentChars < maxChars) {
      // 精确计算单词宽度，考虑单词后的空格（除最后一个单词）
      int wordWidth = 0;
      for (int i = start; i < end; i++) {
        currentChars++;
        if (currentChars > maxChars) {
          break;
        }
        wordWidth += fm.charWidth(content.charAt(i));
      }
      if (end < content.length() && currentChars < maxChars) {
        wordWidth += fm.stringWidth(" ");
      }

      // 如果当前单词加上当前位置会超过最大可用宽度（考虑边距），则换行
      int maxWidth = width - 2 * margin;
      if (2 * x + wordWidth > maxWidth) {
        if (wordWidth > maxWidth) {
          // 单词本身比最大可用宽度长，进行强制拆分换行
          int charIndex = start;
          while (charIndex < end) {
            int subWordWidth = 0;
            int subEndIndex = charIndex;
            while (subEndIndex < end && subWordWidth + fm.charWidth(content.charAt(subEndIndex)) <= maxWidth) {
              subWordWidth += fm.charWidth(content.charAt(subEndIndex));
              subEndIndex++;
            }
            String subWord = content.substring(charIndex, subEndIndex);
            g.drawString(subWord, x, y + fm.getAscent());
            x = margin;
            y += lineHeight;
            charIndex = subEndIndex;
          }
        } else {
          x = margin;
          y += lineHeight;
        }
      }

      // 绘制单词
      g.drawString(content.substring(start, end), x, y + fm.getAscent());
      x += wordWidth;

      start = end;
      end = boundary.next();
    }


    g.dispose();

    return image;
  }
 }
