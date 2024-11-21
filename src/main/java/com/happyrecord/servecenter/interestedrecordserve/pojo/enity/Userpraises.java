package com.happyrecord.servecenter.interestedrecordserve.pojo.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 存储用户点赞评论信息的表
 * </p>
 *
 * @author pum
 * @since 2024-11-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Userpraises implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 点赞用户的 ID，外键关联到 Users 表
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 被点赞评论的 ID，外键关联到 Comments 表
     */
    @TableField("comment_id")
    private Integer commentId;

    /**
     * 表示评论是否展开，默认为 FALSE
     */
    @TableField("is_open")
    private boolean isOpen;

    /**
     * 表示评论是否被点赞，默认为 FALSE
     */
    @TableField("is_liked")
    private boolean isLiked;

    /**
     * 表示评论等级 1为父级 ，2为子级
     */
    @TableField("comment_level")
    private Integer commentLevel;

}
