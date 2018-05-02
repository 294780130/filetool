package com.wind.dao;

import java.util.List;
import com.wind.dao.WordMapper;
import com.wind.entity.Word;
import com.wind.entity.base.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * 评论 dao测试
 * @author wind
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class WordMapperTest{

    @Autowired
    WordMapper mapper;

    @Test
    public void insert() {
        Word entity = new Word();
        int i = mapper.insert(entity);
        System.out.println(i);
    }

    @Test
    public void deleteByCondition() {
        Word entity = new Word();
        int i = mapper.deleteByCondition(entity);
        System.out.println(i);
    }

    @Test
    public void findEntity() {
        Word entity = new Word();
        List<Word> entitys = mapper.findByCondition(entity);
        System.out.println(entitys.size());
    }

    @Test
    public void findByCondition() {
        Word entity = new Word();
        List<Word> entitys = mapper.findByCondition(entity);
        System.out.println(entitys.size());
    }

    @Test
    public void findPageList(){
        Word entity = new Word();
        List<Word> entitys = mapper.findPageList(entity);
        System.out.println(entitys.size());
    }

    @Test
    public void updateByCondition() {
        Word entity = new Word();
        int i = mapper.updateByCondition(entity);
        System.out.println(i);
    }

    @Test
    public void countByCondition(){
        Word entity = new Word();
        int count = mapper.countByCondition(entity);
        System.out.println(count);
    }
}

