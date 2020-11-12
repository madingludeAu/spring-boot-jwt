package com.jwt.mapper;





import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jwt.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {


    @Select("select id from sys_user where NAME = #{username}")
    String getRole(String username);


    @Select("select id from sys_user where NAME = #{username}")
    String getRolePermission(String username);

    @Select("select id from sys_user where NAME = #{username}")
    String getPermission(String username);

    @Select("select id from sys_user where NAME = #{username}")
    String  getPassword(String username);
}
