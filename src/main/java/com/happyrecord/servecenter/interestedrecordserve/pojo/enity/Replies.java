package com.happyrecord.servecenter.interestedrecordserve.pojo.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 存储回复信息的表
 * </p>
 *
 * @author pum
 * @since 2024-11-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Replies implements Serializable {


    /**
     * 回复的唯一标识符
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 回复所属的评论的 ID，外键关联到 Comments 表
     */
    @TableField("comment_id")
    private Integer commentId;

    /**
     * 回复者的昵称
     */
    @TableField("nickname")
    private String nickname;

//    /**
//     * 回复者的头像 URL
//     */
//    @TableField("img")
//    private String img;

    /**
     * 回复的内容
     */
    @TableField("reply_content")
    private String replyContent;


    /**
     * 回复的点赞数，默认为 0
     */
    @TableField("praise")
    private Integer praise;

    /**
     * 回复的时间
     */
    @TableField("create_at")
    private LocalDateTime createAt;

    /**
     * 评论的用户头像
     */
    @TableField("user_img")
    private String userImg;


}
