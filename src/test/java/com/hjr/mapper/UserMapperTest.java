package com.hjr.mapper;

import com.hjr.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void userMapperTest() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}
