package com.happyrecord.servecenter.interestedrecordserve.service;


import com.happyrecord.servecenter.interestedrecordserve.pojo.dto.CommentsAddDTO;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Comments;
import com.happyrecord.servecenter.interestedrecordserve.pojo.vo.CommentsGetVO;

import java.util.List;

/**
 * <p>
 * 存储评论信息的表 服务类
 * </p>
 *
 * @author pum
 * @since 2024-11-22
 */
public interface CommentsService{

  List<CommentsGetVO> pageComments(Integer noteId, Integer page);

  CommentsGetVO addComment(CommentsAddDTO commentsAddDTO);
}
