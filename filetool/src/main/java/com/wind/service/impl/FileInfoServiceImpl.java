package com.wind.service.impl;

import java.util.Date;
import java.util.List;
import com.wind.dao.FileInfoMapper;
import com.wind.dao.WordMapper;
import com.wind.entity.FileInfo;
import com.wind.entity.Word;
import com.wind.service.FileInfoService;
import com.wind.service.base.BaseServiceImpl;
import com.wind.util.StringUtils;
import com.wind.entity.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 工具文件表 service接口实现
 * @author wind
 */
@Service
//@Transactional
public class FileInfoServiceImpl extends BaseServiceImpl<FileInfo, String> implements FileInfoService{

    @Autowired
    private FileInfoMapper mapper;
    
    @Autowired
    private WordMapper wordMapper;


    @Override
    public int insert(FileInfo r) {
    	r.setFileId(StringUtils.getUUID());
    	r.setStatus(2);
    	r.setAgreeCount(0);
    	r.setCreateTime(new Date());
        int i = mapper.insert(r);
        return i;
    }

    @Override
    public int deleteByCondition(FileInfo r) {
        return mapper.deleteByCondition(r);
    }

    @Override
    public FileInfo findEntity(FileInfo r) {
        List<FileInfo> entitys = mapper.findByCondition(r);
        if(entitys.size() == 1){
        	FileInfo entity = entitys.get(0);
        	String fileId = entity.getFileId();
        	Word word = new Word();
        	word.setFileId(fileId);
        	entity.setWords(wordMapper.findByCondition(word));
        	return entity;
        }
        return null;
    }

    @Override
    public List<FileInfo> findByCondition(FileInfo r) {
        return mapper.findByCondition(r);
    }

    @Override
    public void findPageList(FileInfo r, Page page){
    	
    	String skill = r.getSkill();
        if(skill != null && skill.trim().equals("")){
        	r.setSkill(null);
        }
    	
        int totalCount = mapper.countByCondition(r);
        r.setLimit(page.getStartRow() + "," + page.getLineNumber());
        int i = r.getOrderWay();
        if(i == 0){
        	r.setOrder("create_time desc");
        }else if(i == 1){
        	r.setOrder("create_time asc");
        }else if(i == 2){
        	r.setOrder("agree_count desc");
        }else if(i == 3){
        	r.setOrder("agree_count asc");
        }
        
        List<FileInfo> entitys = mapper.findPageList(r);
        page.setTotalCount(totalCount);
        page.setResult(entitys);
    }

    @Override
    public int updateByCondition(FileInfo r) {
        return mapper.updateByCondition(r);
    }

    @Override
    public int countByCondition(FileInfo r){
        return mapper.countByCondition(r);
    }
}

