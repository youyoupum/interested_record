package com.happyrecord.servecenter.interestedrecordserve.repo;

import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Comments;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Note;

import java.util.List;

public interface CommentsRepo {

  List<Comments> pageComments(Integer noteId, Integer page, int size);

  Comments addComment(Comments comments);

  void toPraise(Integer commentId);
}
