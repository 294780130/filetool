package com.wind.service.base;

import java.util.List;
import com.wind.entity.base.Page;

/**
 * 数据库dao通用接口
 * @author wind
 * @param <R> 数据库表关联的实体类
 * @param <PK> 主键类型
 */
public interface BaseService<R, PK> {
    /**
     * 添加纪录
     * @param r
     * @return
     */
    int insert(R r);

    /**
     * 删除记录
     * @param id
     * @return
     */
    int deleteByCondition(R r);

    /**
     * 查询单条记录
     * @param id
     * @return
     */
    R findEntity(R r);


    /**
     * 批量查询记录
     * @param r
     * @return
     */
    List<R> findByCondition(R r);

    /**
     * 分页查询
     * @param r
     * @param page
     */
    void findPageList(R r, Page page);

    /**
     * 更新记录
     * @param r
     * @return
     */
    int updateByCondition(R r);

    /**
     * 条件查询记录条数
     * @param r
     * @return
     */
    int countByCondition(R r);
}
