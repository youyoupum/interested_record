package com.happyrecord.servecenter.interestedrecordserve.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.happyrecord.servecenter.interestedrecordserve.mapper.RepliesMapper;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Replies;
import com.happyrecord.servecenter.interestedrecordserve.repo.RepliesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Console;
import java.util.List;

@Repository
public class RepliesRepoImpl implements RepliesRepo {
  @Autowired
  private RepliesMapper repliesMapper;

  public List<Replies> getReplies(Integer commentId) {
    QueryWrapper<Replies> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("comment_id", commentId);
    // 执行查询并打印结果
    List<Replies> repliesList = repliesMapper.selectList(queryWrapper);
    return repliesList;
  }
}
