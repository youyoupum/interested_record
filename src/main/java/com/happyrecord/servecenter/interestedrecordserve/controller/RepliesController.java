package com.happyrecord.servecenter.interestedrecordserve.controller;


import com.happyrecord.servecenter.interestedrecordserve.pojo.dto.AddRepliesDTO;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Replies;
import com.happyrecord.servecenter.interestedrecordserve.pojo.vo.RepliesVo;
import com.happyrecord.servecenter.interestedrecordserve.service.RepliesService;
import com.happyrecord.servecenter.interestedrecordserve.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 存储回复信息的表 前端控制器
 * </p>
 *
 * @author pum
 * @since 2024-11-22
 */
@RestController
@RequestMapping("/user/replies")
public class RepliesController {
  @Autowired
  RepliesService repliesService;
  /**
   * 回复评论
   * @param addRepliesDTO
   * @return
   */
  @PostMapping
  public Result<RepliesVo> addReplies(@RequestBody AddRepliesDTO addRepliesDTO) {
    return Result.success(repliesService.addRplies(addRepliesDTO));
  }
}
