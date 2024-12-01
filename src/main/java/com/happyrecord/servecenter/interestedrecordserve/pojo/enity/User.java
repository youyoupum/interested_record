package com.happyrecord.servecenter.interestedrecordserve.pojo.enity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(autoResultMap = true)
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  //微信用户唯一标识
  private String openid;

  //姓名
  private String name;

  //手机号
  private String phone;

  //性别 0 女 1 男
  private String sex;

  //身份证号
  private String idNumber;

  //头像
  private String avatar;

  //注册时间
  private LocalDateTime createTime;

  private String personSignature;

  @TableField(value = "regions", typeHandler = JacksonTypeHandler.class)
  private List<String> regions;
}
