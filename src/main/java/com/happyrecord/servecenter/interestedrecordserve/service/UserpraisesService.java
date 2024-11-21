package com.happyrecord.servecenter.interestedrecordserve.service;


/**
 * <p>
 * 存储用户点赞评论信息的表 服务类
 * </p>
 *
 * @author pum
 * @since 2024-11-22
 */
public interface UserpraisesService {


  void toLike(Integer commentId, Integer level);
}
