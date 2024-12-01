package com.happyrecord.servecenter.interestedrecordserve.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.happyrecord.servecenter.interestedrecordserve.mapper.CommentsMapper;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Comments;
import com.happyrecord.servecenter.interestedrecordserve.repo.CommentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentsRepoImpl implements CommentsRepo {
  @Autowired
  private CommentsMapper commentsMapper;


  public List<Comments> pageComments(Integer noteId, Integer page, int size) {
    Page<Comments> commentsPage = new Page<>(page, size);
    QueryWrapper<Comments> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("note_id", noteId);
    //设置排序条件，按点赞数降序排序,先按点赞数，再按时间
    queryWrapper.orderByDesc("praise","create_at");
    commentsMapper.selectPage(commentsPage, queryWrapper);
    return commentsPage.getRecords();
  }


  public Comments addComment(Comments comments) {
    commentsMapper.insert(comments);
    return comments;
  }

  public void toPraise(Integer commentId) {
    UpdateWrapper<Comments> updateWrapper = new UpdateWrapper<>();
    updateWrapper.eq("id", commentId).setIncrBy("praise", 1);
    commentsMapper.update(null, updateWrapper); // 执行更新操作
  }
}
