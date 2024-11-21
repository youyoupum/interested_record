package com.happyrecord.servecenter.interestedrecordserve.controller;


import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Userpraises;
import com.happyrecord.servecenter.interestedrecordserve.service.UserpraisesService;
import com.happyrecord.servecenter.interestedrecordserve.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 存储用户点赞评论信息的表 前端控制器
 * </p>
 *
 * @author pum
 * @since 2024-11-22
 */
@RestController
@RequestMapping("/user/praises")
public class UserpraisesController {
  @Autowired
  private UserpraisesService userpraisesService;

  /**
   * 设置用户点赞
   */
  @PostMapping
  public Result toLike(@RequestParam Integer commentId, @RequestParam Integer level){
    userpraisesService.toLike(commentId,level);
    return Result.success();
  }
}
