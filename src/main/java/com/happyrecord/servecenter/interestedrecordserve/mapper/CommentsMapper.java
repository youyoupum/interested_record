package com.happyrecord.servecenter.interestedrecordserve.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.Comments;
import org.apache.ibatis.annotations.Mapper;


/**
 * <p>
 * 存储评论信息的表 Mapper 接口
 * </p>
 *
 * @author pum
 * @since 2024-11-22
 */
@Mapper
public interface CommentsMapper extends BaseMapper<Comments> {

}
