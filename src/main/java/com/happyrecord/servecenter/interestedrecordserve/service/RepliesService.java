package com.happyrecord.servecenter.interestedrecordserve.service;


import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Replies;

import java.util.List;

/**
 * <p>
 * 存储回复信息的表 服务类
 * </p>
 *
 * @author pum
 * @since 2024-11-22
 */
public interface RepliesService  {
  List<Replies> getReplies(Integer commentId);

}
