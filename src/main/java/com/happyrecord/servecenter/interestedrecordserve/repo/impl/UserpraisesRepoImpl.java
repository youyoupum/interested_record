package com.happyrecord.servecenter.interestedrecordserve.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.happyrecord.servecenter.interestedrecordserve.mapper.UserpraisesMapper;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Userpraises;
import com.happyrecord.servecenter.interestedrecordserve.repo.UserpraisesRepo;
import com.happyrecord.servecenter.interestedrecordserve.utils.BaseContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserpraisesRepoImpl implements UserpraisesRepo {
  @Autowired
  private UserpraisesMapper userpraisesMapper;


  public Userpraises selectReplies(Integer commentId, Integer userId, Integer level) {
    QueryWrapper<Userpraises> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("comment_id", commentId).eq("user_id", userId).eq("comment_level", level);
    return userpraisesMapper.selectOne(queryWrapper);
  }

  public void toLike(Integer commentId, Integer level) {
    // 创建 QueryWrapper 实例，用于查询是否存在符合条件的记录
    QueryWrapper<Userpraises> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("comment_id", commentId)
        .eq("comment_level", level)
        .eq("user_id", BaseContext.getCurrentId());

    // 查询是否存在符合条件的记录
    Userpraises existingRecord = userpraisesMapper.selectOne(queryWrapper);

    if (existingRecord != null) {
      // 如果存在符合条件的记录，更新 is_liked 字段的值为 1
      UpdateWrapper<Userpraises> updateWrapper = new UpdateWrapper<>();
      updateWrapper.eq("comment_id", commentId)
          .eq("comment_level", level)
          .eq("user_id", BaseContext.getCurrentId())
          .set("is_liked", 1);
      userpraisesMapper.update(null, updateWrapper);
    } else {
      // 如果不存在符合条件的记录，插入新记录
      Userpraises newRecord = new Userpraises();
      newRecord.setCommentId(commentId);
      newRecord.setCommentLevel(level);
      newRecord.setUserId(BaseContext.getCurrentId());
      newRecord.setLiked(true);
      newRecord.setOpen(false);
      userpraisesMapper.insert(newRecord);
    }
  }
}
