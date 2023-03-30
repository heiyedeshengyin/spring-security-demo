package com.hjr.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjr.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
