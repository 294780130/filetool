package com.wind.entity;

import java.util.Date;
import java.util.List;

/**
 * 工具文件表
 * @author wind
 */
public class FileInfo{

    /**
     * 工具id
     */
    private String fileId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 工具名称
     */
    private String fileName;

    /**
     * 工具说明
     */
    private String fileDesc;

    /**
     * 版本号
     */
    private String version;

    /**
     * 标签
     */
    private String skill;

    /**
     * 点赞次数
     */
    private Integer agreeCount;

    /**
     * 工具状态，-1表示上传失败，0表示不可见，1表示上传中，2上传成功
     */
    private Integer status;

    /**
     * 上传时间
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
    
    /**
     * 排序方式 0时间降序 1时间升序  2点赞降序 3点赞升序
     */
    private int orderWay;
    
    /**
     * 关键词搜索
     */
    private String keyword;
    
    private List<Word> words;


    public void setFileId(String fileId){
        this.fileId = fileId;
    }

    public String getFileId(){
        return this.fileId;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserId(){
        return this.userId;
    }
    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    public String getFileName(){
        return this.fileName;
    }
    public void setFileDesc(String fileDesc){
        this.fileDesc = fileDesc;
    }

    public String getFileDesc(){
        return this.fileDesc;
    }
    public void setVersion(String version){
        this.version = version;
    }

    public String getVersion(){
        return this.version;
    }
    public void setSkill(String skill){
        this.skill = skill;
    }

    public String getSkill(){
        return this.skill;
    }
    public void setAgreeCount(Integer agreeCount){
        this.agreeCount = agreeCount;
    }

    public Integer getAgreeCount(){
        return this.agreeCount;
    }
    public void setStatus(Integer status){
        this.status = status;
    }

    public Integer getStatus(){
        return this.status;
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

	public int getOrderWay() {
		return orderWay;
	}

	public void setOrderWay(int orderWay) {
		this.orderWay = orderWay;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}
}

