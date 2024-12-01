package com.happyrecord.servecenter.interestedrecordserve.repo;

import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Replies;

import java.util.List;

public interface RepliesRepo {
  List<Replies> getReplies(Integer commentId);

  void toPraise(Integer commentId);

  Replies addReplies(Replies replies);
}
