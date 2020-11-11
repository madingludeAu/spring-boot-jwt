package com.jwt.mapper;





import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jwt.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {


}
