package com.happyrecord.servecenter.interestedrecordserve.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepliesVo {
  private Integer id;
  private String commentId;
  private String nickname;
  private String replyContent;
  private Integer praise;
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
  private LocalDateTime createAt;
  private boolean isLiked;
  private String userImg;
}
