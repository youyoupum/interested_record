package com.happyrecord.servecenter.interestedrecordserve.repo;

import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Userpraises;

public interface UserpraisesRepo {
  Userpraises selectReplies(Integer commentId, Integer userId, Integer level);


  void toLike(Integer commentId, Integer level);
}
