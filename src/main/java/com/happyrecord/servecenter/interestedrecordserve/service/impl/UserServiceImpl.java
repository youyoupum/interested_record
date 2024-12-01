package com.happyrecord.servecenter.interestedrecordserve.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.happyrecord.servecenter.interestedrecordserve.mapper.UserMapper;
import com.happyrecord.servecenter.interestedrecordserve.pojo.dto.UserLoginDTO;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.User;
import com.happyrecord.servecenter.interestedrecordserve.property.WeChatProperties;
import com.happyrecord.servecenter.interestedrecordserve.service.UserService;
import com.happyrecord.servecenter.interestedrecordserve.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    //微信服务接口地址
    public static final String WX_LOGIN = "https://api.weixin.qq.com/sns/jscode2session";

    @Autowired
    private WeChatProperties weChatProperties;
    @Autowired
    private UserMapper  userMapper;

    /**
     * 微信登录
     * @param userLoginDTO
     * @return
     */
    public User wxLogin(UserLoginDTO userLoginDTO) {
        String openid = getOpenid(userLoginDTO.getCode());

        //判断openid是否为空，如果为空表示登录失败，抛出业务异常
        if(openid == null){
            return null;
        }

        //判断当前用户是否为新用户
//        User user = userMapper.getByOpenid(openid);
         QueryWrapper<User> queryWrapper = new QueryWrapper<>();
         queryWrapper.like("openid", openid);
          User user =userMapper.selectOne(queryWrapper);
        //如果是新用户，自动完成注册
        if(user == null){
            user = User.builder()
                    .openid(openid)
                    .createTime(LocalDateTime.now())
                    .avatar("/static/img/icon1.jpeg")
                     .name("游客")
                    .build();
            userMapper.insert(user);//后绪步骤实现
        }
        //返回这个用户对象
        return user;
    }


    public User userMessage(Integer id) {


      return userMapper.selectById(id);
    }

    /**
     * 调用微信接口服务，获取微信用户的openid
     * @param code
     * @return
     */
    private String getOpenid(String code){
        //调用微信接口服务，获得当前微信用户的openid
        Map<String, String> map = new HashMap<>();
        map.put("appid",weChatProperties.getAppid());
        map.put("secret",weChatProperties.getSecret());
        map.put("js_code",code);
        map.put("grant_type","authorization_code");
        String json = HttpClientUtil.doGet(WX_LOGIN, map);

        JSONObject jsonObject = JSON.parseObject(json);
        String openid = jsonObject.getString("openid");
        return openid;
    }
}