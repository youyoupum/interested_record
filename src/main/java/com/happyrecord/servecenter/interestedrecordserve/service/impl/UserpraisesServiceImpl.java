package com.happyrecord.servecenter.interestedrecordserve.service.impl;


import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Replies;
import com.happyrecord.servecenter.interestedrecordserve.repo.UserRepo;
import com.happyrecord.servecenter.interestedrecordserve.repo.UserpraisesRepo;
import com.happyrecord.servecenter.interestedrecordserve.service.CommentsService;
import com.happyrecord.servecenter.interestedrecordserve.service.RepliesService;
import com.happyrecord.servecenter.interestedrecordserve.service.UserpraisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 存储用户点赞评论信息的表 服务实现类
 * </p>
 *
 * @author pum
 * @since 2024-11-22
 */
@Service
public class UserpraisesServiceImpl  implements UserpraisesService {
  @Autowired
  private UserpraisesRepo userpraisesRepo;
  @Autowired
  private CommentsService commentsService;
  @Autowired
  private RepliesService repliesService;


  public void toLike(Integer commentId, Integer level) {
     userpraisesRepo.toLike(commentId,level);
     if(level==1){
       commentsService.toPraise(commentId);
     }else if(level==2){
       repliesService.toPraise(commentId);
     }
  }
}
