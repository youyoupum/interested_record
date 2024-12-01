package com.happyrecord.servecenter.interestedrecordserve.service.impl;


import com.happyrecord.servecenter.interestedrecordserve.pojo.dto.CommentsAddDTO;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Comments;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Replies;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.User;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Userpraises;
import com.happyrecord.servecenter.interestedrecordserve.pojo.vo.CommentsGetVO;
import com.happyrecord.servecenter.interestedrecordserve.pojo.vo.RepliesVo;
import com.happyrecord.servecenter.interestedrecordserve.repo.CommentsRepo;
import com.happyrecord.servecenter.interestedrecordserve.repo.UserpraisesRepo;
import com.happyrecord.servecenter.interestedrecordserve.service.CommentsService;
import com.happyrecord.servecenter.interestedrecordserve.service.RepliesService;
import com.happyrecord.servecenter.interestedrecordserve.service.UserService;
import com.happyrecord.servecenter.interestedrecordserve.utils.BaseContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 存储评论信息的表 服务实现类
 * </p>
 *
 * @author pum
 * @since 2024-11-22
 */
@Service
public class CommentsServiceImpl implements CommentsService {

  @Autowired
  private CommentsRepo commentsRepo;
  @Autowired
  private RepliesService repliesService;
  @Autowired
  private UserpraisesRepo userpraisesRepo;
  @Autowired
  private UserService userService;


  public List<CommentsGetVO> pageComments(Integer noteId, Integer page) {
      int size = 10;
      List<Comments>  comments = commentsRepo.pageComments(noteId,page,size);

      List<CommentsGetVO> commentsGetVOS = new ArrayList<>();
      for (Comments comment: comments) {
        CommentsGetVO commentsGetVO = new CommentsGetVO();
        BeanUtils.copyProperties(comment, commentsGetVO);
        Userpraises userpraises = userpraisesRepo.selectReplies(comment.getId(),BaseContext.getCurrentId(),1);
        if(userpraises!=null){
          commentsGetVO.setLiked(userpraises.isLiked());
          commentsGetVO.setOpen(userpraises.isOpen());
        }
        List<Replies> repliesList = repliesService.getReplies(comment.getId());
        if (!repliesList.isEmpty()) {
          List<RepliesVo> repliesVo = new ArrayList<>();
          for (Replies reply : repliesList) {
            Userpraises replypraises = userpraisesRepo.selectReplies(reply.getCommentId(),BaseContext.getCurrentId(),2);
            RepliesVo repliesVoItem = new RepliesVo();
            BeanUtils.copyProperties(reply, repliesVoItem);
            if(replypraises!=null){
              System.out.println(replypraises.isLiked());
              repliesVoItem.setLiked(replypraises.isLiked());
            }
            repliesVo.add(repliesVoItem);
          }
          commentsGetVO.setReplies(repliesVo);
        }
        commentsGetVOS.add(commentsGetVO);
      }
      return commentsGetVOS;
  }


  public CommentsGetVO addComment(CommentsAddDTO commentsAddDTO) {
    Comments comments = new Comments();
    BeanUtils.copyProperties(commentsAddDTO,comments);
    User user = userService.userMessage(BaseContext.getCurrentId());
    comments.setNickname(user.getName());
    comments.setUserImg(user.getAvatar());
    comments.setUserId(BaseContext.getCurrentId());
    comments.setCreateAt(LocalDateTime.now());
    comments.setPraise(0);
    commentsRepo.addComment(comments); //执行插入语句
    CommentsGetVO commentsGetVO = new CommentsGetVO();
    BeanUtils.copyProperties(comments, commentsGetVO);
    commentsGetVO.setLiked(false);
    return commentsGetVO;
  }

  public void toPraise(Integer commentId) {
    commentsRepo.toPraise(commentId);
  }
}
