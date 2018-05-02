package com.wind.entity;

import java.util.Date;

/**
 * 评论
 * @author wind
 */
public class Word{

    /**
     * 评论id
     */
    private String wordId;

    /**
     * 留言用户id
     */
    private String userId;

    /**
     * 文件id
     */
    private String fileId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    private Date createTime;
    
    /**
     * 分页从句
     */
    private String limit;
    
    /**
     * 排序从句
     */
    private String order;


    public void setWordId(String wordId){
        this.wordId = wordId;
    }

    public String getWordId(){
        return this.wordId;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserId(){
        return this.userId;
    }
    public void setFileId(String fileId){
        this.fileId = fileId;
    }

    public String getFileId(){
        return this.fileId;
    }
    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return this.content;
    }
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Date getCreateTime(){
        return this.createTime;
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

