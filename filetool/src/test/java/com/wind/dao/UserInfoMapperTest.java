package com.wind.dao;

import java.util.List;
import com.wind.dao.UserInfoMapper;
import com.wind.entity.UserInfo;
import com.wind.entity.base.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * 用户表 dao测试
 * @author wind
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class UserInfoMapperTest{

    @Autowired
    UserInfoMapper mapper;

    @Test
    public void insert() {
        UserInfo entity = new UserInfo();
        int i = mapper.insert(entity);
        System.out.println(i);
    }

    @Test
    public void deleteByCondition() {
        UserInfo entity = new UserInfo();
        int i = mapper.deleteByCondition(entity);
        System.out.println(i);
    }

    @Test
    public void findEntity() {
        UserInfo entity = new UserInfo();
        List<UserInfo> entitys = mapper.findByCondition(entity);
        System.out.println(entitys.size());
    }

    @Test
    public void findByCondition() {
        UserInfo entity = new UserInfo();
        List<UserInfo> entitys = mapper.findByCondition(entity);
        System.out.println(entitys.size());
    }

    @Test
    public void findPageList(){
        UserInfo entity = new UserInfo();
        List<UserInfo> entitys = mapper.findPageList(entity);
        System.out.println(entitys.size());
    }

    @Test
    public void updateByCondition() {
        UserInfo entity = new UserInfo();
        int i = mapper.updateByCondition(entity);
        System.out.println(i);
    }

    @Test
    public void countByCondition(){
        UserInfo entity = new UserInfo();
        int count = mapper.countByCondition(entity);
        System.out.println(count);
    }
}

