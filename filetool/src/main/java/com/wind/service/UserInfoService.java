package com.wind.service;

import com.wind.entity.UserInfo;
import com.wind.service.base.BaseService;
/**
 * 用户表 service接口
 * @author wind
 */
public interface UserInfoService extends BaseService<UserInfo, String>{
	/**
	 * 登陆操作	
	 * @param r
	 * @return -1表示账号不存在, 0表示密码错误,1表示登陆成功
	 */
	int login(UserInfo r);
}

