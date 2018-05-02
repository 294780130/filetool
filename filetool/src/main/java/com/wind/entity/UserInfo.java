package com.wind.entity;


/**
 * 用户表
 * @author wind
 */
public class UserInfo{

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户账号
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 类型，1表示管理员  0表示普通用户
     */
    private Integer type;
    
    /**
     * 分页从句
     */
    private String limit;
    
    /**
     * 排序从句
     */
    private String order;


    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserId(){
        return this.userId;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return this.userName;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
    public void setType(Integer type){
        this.type = type;
    }

    public Integer getType(){
        return this.type;
    }

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
}

