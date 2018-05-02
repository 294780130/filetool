package com.wind.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;
import com.wind.entity.UserInfo;
import com.wind.service.UserInfoService;
import com.wind.entity.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


/**
 * 用户表 controller
 * @author wind
 */
@RestController
@RequestMapping(value = "userInfo")
@Api(value="userInfo")
public class UserInfoController{

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 添加记录接口
     * userInfo/save
     * @param r
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ApiOperation(value="UserInfo 添加记录接口", notes="UserInfo 添加记录接口")
    public String save(UserInfo r) {
        int i = userInfoService.insert(r);
        JSONObject result = new JSONObject();
        result.put("msg", i > 0 ? "success" : "failure");
        return result.toString();
    }
    
    /**
     * 登陆接口
     * userInfo/login
     * @param r
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ApiOperation(value="UserInfo 登陆接口", notes="UserInfo 登陆接口")
    public String login(UserInfo r, HttpServletRequest request) {
        int i = userInfoService.login(r);
        JSONObject result = new JSONObject();
        if(i == 1){
        	request.getSession().setAttribute("currentUser", r);
        	result.put("userinfo", r);
        }
        result.put("msg", i);
        return result.toString();
    }

    /**
     * 删除记录接口
     * userInfo/delete
     * @param r
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ApiOperation(value="UserInfo 删除记录接口", notes="UserInfo 删除记录接口")
    public String delete(UserInfo r) {
        int i = userInfoService.deleteByCondition(r);
        JSONObject result = new JSONObject();
        result.put("msg", i > 0 ? "success" : "failure");
        return result.toString();
    }

    /**
     * 单条记录查询接口
     * userInfo/findEntity
     * @param r
     * @return
     */
    @RequestMapping(value = "findEntity", method = RequestMethod.POST)
    @ApiOperation(value="UserInfo 单条记录查询接口", notes="UserInfo 单条记录查询接口")
    public UserInfo findUserInfo(UserInfo r) {
        return userInfoService.findEntity(r);
    }

    /**
     * 批量查询记录接口
     * userInfo/findList
     * @param r
     * @return
     */
    @RequestMapping(value = "findList", method = RequestMethod.POST)
    @ApiOperation(value="UserInfo 批量查询记录接口", notes="UserInfo 批量查询记录接口")
    public List<UserInfo> findByCondition(UserInfo r) {
        return userInfoService.findByCondition(r);
    }

    /**
     * 分页查询记录接口
     * userInfo/findPageList
     * @param r
     * @return
     */
    @RequestMapping(value = "findPageList", method = RequestMethod.POST)
    @ApiOperation(value="UserInfo 分页查询记录接口", notes="UserInfo 分页查询记录接口")
    public Page findPageList(UserInfo r, Page page){
    	userInfoService.findPageList(r, page);
        return page;
    }

    /**
     * 修改记录接口
     * userInfo/update
     * @param r
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ApiOperation(value="UserInfo 修改记录接口", notes="UserInfo 修改记录接口")
    public String updateByCondition(UserInfo r) {
        int i = userInfoService.updateByCondition(r);
        JSONObject result = new JSONObject();
        result.put("msg", i > 0 ? "success" : "failure");
        return result.toString();
    }
}

