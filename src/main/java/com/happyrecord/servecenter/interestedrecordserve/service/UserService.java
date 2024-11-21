package com.happyrecord.servecenter.interestedrecordserve.service;

import com.happyrecord.servecenter.interestedrecordserve.pojo.dto.UserLoginDTO;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.User;

public interface UserService {
  /**
   * 微信登录
   * @param userLoginDTO
   * @return
   */
  User wxLogin(UserLoginDTO userLoginDTO);
}
