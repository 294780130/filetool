package com.wind.service.impl;

import java.util.Date;
import java.util.List;
import com.wind.dao.WordMapper;
import com.wind.entity.Word;
import com.wind.service.WordService;
import com.wind.service.base.BaseServiceImpl;
import com.wind.util.StringUtils;
import com.wind.entity.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 评论 service接口实现
 * @author wind
 */
@Service
//@Transactional
public class WordServiceImpl extends BaseServiceImpl<Word, String> implements WordService{

    @Autowired
    private WordMapper mapper;


    @Override
    public int insert(Word r) {
    	r.setWordId(StringUtils.getUUID());
    	r.setCreateTime(new Date());
        int i = mapper.insert(r);
        return i;
    }

    @Override
    public int deleteByCondition(Word r) {
        return mapper.deleteByCondition(r);
    }

    @Override
    public Word findEntity(Word r) {
        List<Word> entitys = mapper.findByCondition(r);
        return entitys.size() == 1 ? entitys.get(0) : null;
    }

    @Override
    public List<Word> findByCondition(Word r) {
        return mapper.findByCondition(r);
    }

    @Override
    public void findPageList(Word r, Page page){
        int totalCount = mapper.countByCondition(r);
        r.setLimit(page.getStartRow() + "," + page.getLineNumber());
        r.setOrder("create_time desc");
        List<Word> entitys = mapper.findPageList(r);
        page.setTotalCount(totalCount);
        page.setResult(entitys);
    }

    @Override
    public int updateByCondition(Word r) {
        return mapper.updateByCondition(r);
    }

    @Override
    public int countByCondition(Word r){
        return mapper.countByCondition(r);
    }
}

