package com.happyrecord.servecenter.interestedrecordserve.service.impl;


import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Replies;
import com.happyrecord.servecenter.interestedrecordserve.repo.RepliesRepo;
import com.happyrecord.servecenter.interestedrecordserve.service.RepliesService;
import io.lettuce.core.ScriptOutputType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 存储回复信息的表 服务实现类
 * </p>
 *
 * @author pum
 * @since 2024-11-22
 */
@Service
public class RepliesServiceImpl implements RepliesService {
  @Autowired
  private RepliesRepo repliesRepo;

  public List<Replies> getReplies(Integer commentId) {
    return repliesRepo.getReplies(commentId);
  }
}
