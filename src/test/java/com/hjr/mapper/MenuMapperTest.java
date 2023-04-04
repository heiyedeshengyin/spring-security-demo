package com.hjr.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MenuMapperTest {

    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void selectPermsByUserIdTest() {
        List<String> list = menuMapper.selectPermsByUserId(2L);
        System.out.println(list);
    }
}
