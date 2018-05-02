package com.wind.dao;

import java.util.List;
import com.wind.dao.FileInfoMapper;
import com.wind.entity.FileInfo;
import com.wind.entity.base.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * 工具文件表 dao测试
 * @author wind
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class FileInfoMapperTest{

    @Autowired
    FileInfoMapper mapper;

    @Test
    public void insert() {
        FileInfo entity = new FileInfo();
        int i = mapper.insert(entity);
        System.out.println(i);
    }

    @Test
    public void deleteByCondition() {
        FileInfo entity = new FileInfo();
        int i = mapper.deleteByCondition(entity);
        System.out.println(i);
    }

    @Test
    public void findEntity() {
        FileInfo entity = new FileInfo();
        List<FileInfo> entitys = mapper.findByCondition(entity);
        System.out.println(entitys.size());
    }

    @Test
    public void findByCondition() {
        FileInfo entity = new FileInfo();
        //entity.setFileDesc("23");
        entity.setKeyword("sublime");
        List<FileInfo> entitys = mapper.findByCondition(entity);
        System.out.println(entitys.size());
    }

    @Test
    public void findPageList(){
        FileInfo entity = new FileInfo();
        entity.setLimit("0, 1");
        List<FileInfo> entitys = mapper.findPageList(entity);
        System.out.println(entitys.size());
    }

    @Test
    public void updateByCondition() {
        FileInfo entity = new FileInfo();
        int i = mapper.updateByCondition(entity);
        System.out.println(i);
    }

    @Test
    public void countByCondition(){
        FileInfo entity = new FileInfo();
        int count = mapper.countByCondition(entity);
        System.out.println(count);
    }
}

