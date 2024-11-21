package com.happyrecord.servecenter.interestedrecordserve.controller;


import com.happyrecord.servecenter.interestedrecordserve.pojo.dto.CommentsAddDTO;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Comments;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Note;
import com.happyrecord.servecenter.interestedrecordserve.pojo.vo.CommentsGetVO;
import com.happyrecord.servecenter.interestedrecordserve.service.CommentsService;
import com.happyrecord.servecenter.interestedrecordserve.utils.BaseContext;
import com.happyrecord.servecenter.interestedrecordserve.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 存储评论信息的表 前端控制器
 * </p>
 *
 * @author pum
 * @since 2024-11-22
 */
@RestController
@RequestMapping("/user/comments")
public class CommentsController {
  @Autowired
  private CommentsService commentsService;

  /**
   * 分页获取评论数据
   *
   * @param noteId
   * @param page
   * @return
   */
  @GetMapping
  private Result<List<CommentsGetVO>> pageComments(@RequestParam Integer noteId, @RequestParam Integer page) {
    return Result.success(commentsService.pageComments(noteId, page));
//    return Result.success();
  }

  /**
   * 新增评论数据
   */
  @PostMapping
  private Result<CommentsGetVO> addComment(@RequestBody CommentsAddDTO commentsAddDTO) {
    System.out.println(commentsAddDTO);
    return Result.success(commentsService.addComment(commentsAddDTO));
  }
}
