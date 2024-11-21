package com.happyrecord.servecenter.interestedrecordserve.pojo.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 存储评论信息的表
 * </p>
 *
 * @author pum
 * @since 2024-11-22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Comments implements Serializable {


    /**
     * 评论的唯一标识符
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 发表评论的用户的 ID，外键关联到 Users 表
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 表示发表评论的用户是否为作者，默认为 FALSE
     */
    @TableField("is_author")
    private Boolean isAuthor;

//    /**
//     * 表示评论是否展开，默认为 FALSE
//     */
//    @TableField("is_open")
//    private Boolean isOpen;
//
//    /**
//     * 表示评论是否被点赞，默认为 FALSE
//     */
//    @TableField("is_liked")
//    private Boolean isLiked;

    /**
     * 评论的点赞数，默认为 0
     */
    @TableField("praise")
    private Integer praise;

    /**
     * 评论的内容
     */
    @TableField("comment_content")
    private String commentContent;

    /**
     * 评论的时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    @TableField("create_at")
    private LocalDateTime createAt;

    /**
     * 评价的帖子
     */
    @TableField("note_id")
    private Integer noteId;

    /**
     * 评论的用户头像
     */
    @TableField("user_img")
    private String userImg;

    /**
     * 评论的用户名
     */
    @TableField("nickname")
    private String nickname;

}
