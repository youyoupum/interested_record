package com.happyrecord.servecenter.interestedrecordserve.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.happyrecord.servecenter.interestedrecordserve.pojo.enity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper  extends BaseMapper<User> {

//    /**
//     * 根据openid查询用户
//     * @param openid
//     * @return
//     */
//    @Select("select * from user where openid = #{openid}")
//    User getByOpenid(String openid);
//
//    /**
//     * 插入数据
//     * @param user
//     */
//    void insert(User user);
}
