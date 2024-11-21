package com.happyrecord.servecenter.interestedrecordserve.service.impl;


import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Replies;
import com.happyrecord.servecenter.interestedrecordserve.repo.UserRepo;
import com.happyrecord.servecenter.interestedrecordserve.repo.UserpraisesRepo;
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



  public void toLike(Integer commentId, Integer level) {
     userpraisesRepo.toLike(commentId,level);
  }
}
