package com.happyrecord.servecenter.interestedrecordserve.pojo.dto;

import lombok.Data;

@Data
public class AddRepliesDTO {
  private String replyContent;
  private Integer commentId;
}
