package com.wind.service.impl;

import java.util.List;
import com.wind.dao.UserInfoMapper;
import com.wind.entity.UserInfo;
import com.wind.service.UserInfoService;
import com.wind.service.base.BaseServiceImpl;
import com.wind.util.StringUtils;
import com.wind.entity.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户表 service接口实现
 * @author wind
 */
@Service
//@Transactional
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo, String> implements UserInfoService{

    @Autowired
    private UserInfoMapper mapper;


    @Override
    public int insert(UserInfo r) {
    	r.setUserId(StringUtils.getUUID());
        int i = mapper.insert(r);
        return i;
    }

    @Override
    public int deleteByCondition(UserInfo r) {
        return mapper.deleteByCondition(r);
    }

    @Override
    public UserInfo findEntity(UserInfo r) {
        List<UserInfo> entitys = mapper.findByCondition(r);
        return entitys.size() == 1 ? entitys.get(0) : null;
    }

    @Override
    public List<UserInfo> findByCondition(UserInfo r) {
        return mapper.findByCondition(r);
    }

    @Override
    public void findPageList(UserInfo r, Page page){
        int totalCount = mapper.countByCondition(r);
        r.setLimit(page.getStartRow() + "," + page.getLineNumber());
        List<UserInfo> entitys = mapper.findPageList(r);
        page.setTotalCount(totalCount);
        page.setResult(entitys);
    }

    @Override
    public int updateByCondition(UserInfo r) {
        return mapper.updateByCondition(r);
    }

    @Override
    public int countByCondition(UserInfo r){
        return mapper.countByCondition(r);
    }
    
    @Override
    public int login(UserInfo r) {
    	String userName = r.getUserName();
    	int result;
    	String password = r.getPassword();
    	UserInfo u = new UserInfo();
    	u.setUserName(userName);
    	List<UserInfo> entitys = mapper.findByCondition(u);
    	if(entitys.size() == 1){
    		UserInfo user = entitys.get(0);
    		if(password != null && password.equals(user.getPassword())){
    			result = 1;
    			r.setUserId(user.getUserId());
    			r.setType(user.getType());
    		}else{
    			result = 0;
    		}
    	}else{
    		result = -1;
    	}
    	return result;
    }
}

