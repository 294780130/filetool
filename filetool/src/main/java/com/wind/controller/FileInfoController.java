package com.wind.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import com.wind.entity.FileInfo;
import com.wind.entity.UserInfo;
import com.wind.service.FileInfoService;
import com.wind.entity.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


/**
 * 工具文件表 controller
 * @author wind
 */
@RestController
@RequestMapping(value = "fileInfo")
@Api(value="fileInfo")
public class FileInfoController{

    @Autowired
    private FileInfoService fileInfoService;

    @Value("${filepath}") 
    private String filepath;

    /**
     * 添加记录接口
     * fileInfo/save
     * @param r
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ApiOperation(value="FileInfo 添加记录接口", notes="FileInfo 添加记录接口")
    public String save(FileInfo r) {
        int i = fileInfoService.insert(r);
        JSONObject result = new JSONObject();
        result.put("msg", i > 0 ? "success" : "failure");
        return result.toString();
    }

    /**
     * 删除记录接口
     * fileInfo/delete
     * @param r
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ApiOperation(value="FileInfo 删除记录接口", notes="FileInfo 删除记录接口")
    public String delete(FileInfo r) {
        int i = fileInfoService.deleteByCondition(r);
        JSONObject result = new JSONObject();
        result.put("msg", i > 0 ? "success" : "failure");
        return result.toString();
    }

    /**
     * 单条记录查询接口
     * fileInfo/findEntity
     * @param r
     * @return
     */
    @RequestMapping(value = "findEntity", method = RequestMethod.POST)
    @ApiOperation(value="FileInfo 单条记录查询接口", notes="FileInfo 单条记录查询接口")
    public FileInfo findFileInfo(FileInfo r) {
        return fileInfoService.findEntity(r);
    }
    
    /**
     * 文件上传
     * @return
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upload(HttpServletRequest request){
    	
    	 //用来检测程序运行时间
        long  startTime = System.currentTimeMillis();
    	 //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        JSONObject result = new JSONObject();
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request)){
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
           //获取multiRequest 中所有的文件名
            Iterator<String> iter = multiRequest.getFileNames();
             
            while(iter.hasNext()){
                //一次遍历所有文件
                MultipartFile file= multiRequest.getFile(iter.next());
                if(file != null){
                	String skill = multiRequest.getParameter("skill");
                	String fileDesc = multiRequest.getParameter("fileDesc");
                	String version = multiRequest.getParameter("version");
                	String fileName = file.getOriginalFilename();
                	FileInfo fileInfo = new FileInfo();
                	fileInfo.setFileName(fileName);
                	fileInfo.setVersion(version);
                	int i = fileInfoService.countByCondition(fileInfo);
                	if(i > 0){
                		result.put("status", 0);
                		break;
                	}else{
                		result.put("status", 1);
                		fileInfo.setSkill(skill);
                		fileInfo.setFileDesc(fileDesc);
                		UserInfo userInfo = (UserInfo)request.getSession().getAttribute("currentUser");
                		if(userInfo != null){
                			fileInfo.setUserId(userInfo.getUserId());
                		}
                		
                		i = fileInfoService.insert(fileInfo);
                	}
                	
                	String path = "";
                	if(i > 0){
                		path += fileInfo.getFileId() + "/";
                	}
                	File dir = new File(filepath + path);
                	if(!dir.exists()){
                		dir.mkdirs();
                	}
                    path = filepath + path + fileName;
                    //上传
                    try {
                    	File newFile = new File(path);
                    	if(!newFile.exists()){
                    		file.transferTo(new File(path));
                    	}
					} catch (IllegalStateException e) {
						i = -1;
						e.printStackTrace();
					} catch (IOException e) {
						i = -1;
						e.printStackTrace();
					}
                    
                    if(i == -1){
                    	result.put("status", -1);
                    	FileInfo fi = new FileInfo();
                    	fi.setFileId(fileInfo.getFileId());
                    	fi.setStatus(-1);
                    	fileInfoService.insert(fi);
                    }
                }  
            }
        }
        long  endTime = System.currentTimeMillis();
        System.out.println("time：" + (endTime-startTime) + "ms");
        return result.toString();
    }
    
    @RequestMapping(value = "down", method = RequestMethod.GET)
    public void down(HttpServletRequest request,  HttpServletResponse response){
    	String fileId = request.getParameter("fileId");
    	FileInfo fileInfo = new FileInfo();
    	fileInfo.setFileId(fileId);
    	FileInfo r = fileInfoService.findEntity(fileInfo);
    	OutputStream os = null;
    	InputStream in = null;
    	try {
    		if(r != null){
        		String fileName = r.getFileName();
            	String path = filepath + fileId + "/" + fileName;
            	File file = new File(path);
            	if(file.exists()){
            		//设置响应头和客户端保存文件名
            	    response.setCharacterEncoding("utf-8");
            	    response.setContentType("multipart/form-data");
            	    response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
            	    //打开本地文件流
            	    in = new FileInputStream(file);
    				//激活下载操作
    	            os = response.getOutputStream();

    	            //循环写入输出流
    	            byte[] b = new byte[2048];
    	            int length;
    	            while ((length = in.read(b)) > 0) {
    	                os.write(b, 0, length);
    	            }
            	}else{
            		response.sendError(404);
            	}
        	}else{
        		response.sendError(404);
        	}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(os != null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    }

    /**
     * 批量查询记录接口
     * fileInfo/findList
     * @param r
     * @return
     */
    @RequestMapping(value = "findList", method = RequestMethod.POST)
    @ApiOperation(value="FileInfo 批量查询记录接口", notes="FileInfo 批量查询记录接口")
    public List<FileInfo> findByCondition(FileInfo r) {
        return fileInfoService.findByCondition(r);
    }

    /**
     * 分页查询记录接口
     * fileInfo/findPageList
     * @param r
     * @return
     */
    @RequestMapping(value = "findPageList", method = RequestMethod.POST)
    @ApiOperation(value="FileInfo 分页查询记录接口", notes="FileInfo 分页查询记录接口")
    public Page findPageList(FileInfo r, Page page){
    	fileInfoService.findPageList(r, page);
        return page;
    }

    /**
     * 修改记录接口
     * fileInfo/update
     * @param r
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ApiOperation(value="FileInfo 修改记录接口", notes="FileInfo 修改记录接口")
    public String updateByCondition(FileInfo r) {
        int i = fileInfoService.updateByCondition(r);
        JSONObject result = new JSONObject();
        result.put("msg", i > 0 ? "success" : "failure");
        return result.toString();
    }
}

