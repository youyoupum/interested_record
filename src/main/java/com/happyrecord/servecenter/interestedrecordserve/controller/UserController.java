package com.happyrecord.servecenter.interestedrecordserve.controller;


import com.happyrecord.servecenter.interestedrecordserve.constant.JwtClaimsConstant;
import com.happyrecord.servecenter.interestedrecordserve.pojo.dto.UserLoginDTO;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.User;
import com.happyrecord.servecenter.interestedrecordserve.pojo.vo.UserLoginVO;
import com.happyrecord.servecenter.interestedrecordserve.property.JwtProperties;
import com.happyrecord.servecenter.interestedrecordserve.service.UserService;
import com.happyrecord.servecenter.interestedrecordserve.utils.JwtUtil;
import com.happyrecord.servecenter.interestedrecordserve.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user/user")
public class UserController {
  @Autowired
  private UserService userService;
  @Autowired
  private JwtProperties jwtProperties;


  /**
   * 登录
   * @param userLoginDTO
   * @return
   */
  @PostMapping("/login")
  public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO){
      User user = userService.wxLogin(userLoginDTO);
    //为微信用户生成jwt令牌
    Map<String , Object> claims = new HashMap<>();
    claims.put(JwtClaimsConstant.USER_ID,user.getId());
    System.out.println(jwtProperties.getUserTtl());
    String token = JwtUtil.createJWT(jwtProperties.getUserSecretKey(),jwtProperties.getUserTtl(),claims);

    UserLoginVO userLoginVO = UserLoginVO.builder()
        .id(user.getId())
        .openid(user.getOpenid())
        .token(token)
        .build();
    return Result.success(userLoginVO);
  }
}
