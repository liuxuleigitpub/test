package com.dm.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.dm.entity.ChannelUserInfo;
import com.dm.entity.UserInfo;
import com.dm.service.UserInfoService;
import com.dm.util.PageData;
import com.dm.util.SessionKey;

@Controller
@RequestMapping("/user")
public class UserInfoController extends BasicController{
	
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping("/userlist")
	public void userList(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int pageNum = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		String userName = request.getParameter("userName");
		int usertype = Integer.parseInt(request.getParameter("usertype"));
		PageData<UserInfo> pageData = userInfoService.getUserInfoByPage(pageNum, pageSize, userName,usertype);
		writeJSON(response, pageData.toJSON());
	}
	
	@RequestMapping("/adduserinfo")
	public void addUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String cnname = request.getParameter("cnname");
		int usertype = Integer.parseInt(request.getParameter("usertype"));
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(username);
		userInfo.setPassword(password);
		userInfo.setCnname(cnname);
		userInfo.setUsertype(usertype);
		int result = userInfoService.addUserInfo(userInfo);
		writeInt(response, result);
	}
	@RequestMapping("/updateuserinfo")
	public void updateuserinfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String cnname = request.getParameter("cnname");
		int usertype = Integer.parseInt(request.getParameter("usertype"));
		int id = Integer.parseInt(request.getParameter("id"));
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(username);
		userInfo.setPassword(password);
		userInfo.setCnname(cnname);
		userInfo.setUsertype(usertype);
		userInfo.setId(id);
		int result = userInfoService.updateUserInfo(userInfo);
		writeInt(response, result);
	}
	@RequestMapping("/deleteUserInfo")
	public void deleteUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		UserInfo userInfo = new UserInfo();
		userInfo.setId(id);
		int result = userInfoService.deleteUserInfo(userInfo);
		writeInt(response, result);
	}
	
	@RequestMapping("/channeltouser")
	public void channeltouser(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int pageNum = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		int chid = Integer.parseInt(request.getParameter("chid"));
		PageData<UserInfo> pageData = userInfoService.getChannelUserByPage(pageNum, pageSize, chid);
		writeJSON(response, pageData.toJSON());
	}
	@RequestMapping("/adduserbychannel")
	public void adduserbychannel(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int usertype = Integer.parseInt(request.getParameter("usertype"));
		String cnname = request.getParameter("cnname");
		int chid = Integer.parseInt(request.getParameter("chid"));
		System.out.println(chid);
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(username);
		userInfo.setPassword(password);
		userInfo.setCnname(cnname);
		userInfo.setUsertype(usertype);
		userInfo.setChid(chid);
		int result = userInfoService.addUserByChannel(userInfo);
		writeInt(response, result);
	}
	@RequestMapping("/updateuserbychannel")
	public void updateuserbychannel(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String cnname = request.getParameter("cnname");
		int usertype = Integer.parseInt(request.getParameter("usertype"));
		int id = Integer.parseInt(request.getParameter("id"));
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(username);
		userInfo.setPassword(password);
		userInfo.setCnname(cnname);
		userInfo.setUsertype(usertype);
		userInfo.setId(id);
		int result = userInfoService.updateUserByChannel(userInfo);
		writeInt(response, result);
	}
	
	@RequestMapping("/addchannelbyuserid")
	public void addchannelbyuserid(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String channelid = request.getParameter("channelid");
		int userid = Integer.parseInt(request.getParameter("id"));
		ChannelUserInfo channelUserInfo = new ChannelUserInfo();
		channelUserInfo.setChannelid(channelid);
		channelUserInfo.setUserid(userid);
		int result = userInfoService.addChannelidByUserid(channelUserInfo);
		writeInt(response, result);
	}
	
	
}
