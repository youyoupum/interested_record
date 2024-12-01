package com.happyrecord.servecenter.interestedrecordserve.service.impl;


import com.happyrecord.servecenter.interestedrecordserve.pojo.dto.AddRepliesDTO;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Replies;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.User;
import com.happyrecord.servecenter.interestedrecordserve.pojo.vo.RepliesVo;
import com.happyrecord.servecenter.interestedrecordserve.repo.RepliesRepo;
import com.happyrecord.servecenter.interestedrecordserve.service.RepliesService;
import com.happyrecord.servecenter.interestedrecordserve.service.UserService;
import com.happyrecord.servecenter.interestedrecordserve.utils.BaseContext;
import io.lettuce.core.ScriptOutputType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
  @Autowired
  private UserService userService;

  public List<Replies> getReplies(Integer commentId) {
    return repliesRepo.getReplies(commentId);
  }


  public void toPraise(Integer commentId) {
    repliesRepo.toPraise(commentId);
  }


  public RepliesVo addRplies(AddRepliesDTO addRepliesDTO) {
     User user = userService.userMessage(BaseContext.getCurrentId());
     Replies replies = new Replies();
     BeanUtils.copyProperties(addRepliesDTO, replies);
     replies.setCreateAt(LocalDateTime.now());
     replies.setUserId(user.getId());
     replies.setNickname(user.getName());
     replies.setPraise(0);
     replies.setUserImg(user.getAvatar());
     Replies replies1 = repliesRepo.addReplies(replies);
     RepliesVo repliesVo = new RepliesVo();
     BeanUtils.copyProperties(replies1, repliesVo);
     repliesVo.setLiked(false);
     return repliesVo;
  }
}
