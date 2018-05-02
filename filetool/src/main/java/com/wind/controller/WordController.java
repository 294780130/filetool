package com.wind.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import com.wind.entity.UserInfo;
import com.wind.entity.Word;
import com.wind.service.WordService;
import com.wind.entity.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


/**
 * 评论 controller
 * @author wind
 */
@RestController
@RequestMapping(value = "word")
@Api(value="word")
public class WordController{

    @Autowired
    private WordService wordService;

    /**
     * 添加记录接口
     * word/save
     * @param r
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ApiOperation(value="Word 添加记录接口", notes="Word 添加记录接口")
    public String save(Word r, HttpServletRequest request) {
    	UserInfo userInfo = (UserInfo)request.getSession().getAttribute("currentUser");
    	if(userInfo != null){
    		r.setUserId(userInfo.getUserId());
    	}
        int i = wordService.insert(r);
        JSONObject result = new JSONObject();
        result.put("msg", i > 0 ? "success" : "failure");
        return result.toString();
    }

    /**
     * 删除记录接口
     * word/delete
     * @param r
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ApiOperation(value="Word 删除记录接口", notes="Word 删除记录接口")
    public String delete(Word r) {
        int i = wordService.deleteByCondition(r);
        JSONObject result = new JSONObject();
        result.put("msg", i > 0 ? "success" : "failure");
        return result.toString();
    }

    /**
     * 单条记录查询接口
     * word/findEntity
     * @param r
     * @return
     */
    @RequestMapping(value = "findEntity", method = RequestMethod.POST)
    @ApiOperation(value="Word 单条记录查询接口", notes="Word 单条记录查询接口")
    public Word findWord(Word r) {
        return wordService.findEntity(r);
    }

    /**
     * 批量查询记录接口
     * word/findList
     * @param r
     * @return
     */
    @RequestMapping(value = "findList", method = RequestMethod.POST)
    @ApiOperation(value="Word 批量查询记录接口", notes="Word 批量查询记录接口")
    public List<Word> findByCondition(Word r) {
        return wordService.findByCondition(r);
    }

    /**
     * 分页查询记录接口
     * word/findPageList
     * @param r
     * @return
     */
    @RequestMapping(value = "findPageList", method = RequestMethod.POST)
    @ApiOperation(value="Word 分页查询记录接口", notes="Word 分页查询记录接口")
    public Page findPageList(Word r, Page page){
    	wordService.findPageList(r, page);
        return page;
    }

    /**
     * 修改记录接口
     * word/update
     * @param r
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ApiOperation(value="Word 修改记录接口", notes="Word 修改记录接口")
    public String updateByCondition(Word r) {
        int i = wordService.updateByCondition(r);
        JSONObject result = new JSONObject();
        result.put("msg", i > 0 ? "success" : "failure");
        return result.toString();
    }
}

