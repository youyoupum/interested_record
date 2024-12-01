package com.happyrecord.servecenter.interestedrecordserve.controller;

import com.happyrecord.servecenter.interestedrecordserve.utils.CreateImage;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/image/note")
public class FontImageController {

  @PostMapping(value = "/create-image", produces = MediaType.IMAGE_PNG_VALUE)
  public byte[] createImage(@RequestParam String content) throws Exception {
    Font font = new Font("微软雅黑", Font.PLAIN, 32);
    CreateImage c = new CreateImage();
    BufferedImage image = c.createTextImage(content, "classpath:/static/line.jpg",font, 500, 400);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(image, "png", baos);
    return baos.toByteArray();
  }

  }