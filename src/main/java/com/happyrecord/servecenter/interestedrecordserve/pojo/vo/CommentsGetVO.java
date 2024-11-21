package com.happyrecord.servecenter.interestedrecordserve.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentsGetVO {
  /**
   * 父级回复评论相关属性
   */
   private String nickname;
   private String userImg;
   private String commentContent;
   private Integer praise;
   private Integer isAuthor;
 @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
   private LocalDateTime createAt;
   private boolean isOpen;  //是否执行折叠的展开
   private boolean isLiked;
   //子级回复相关属性
   private List<RepliesVo> replies;
   private Integer id;
}
