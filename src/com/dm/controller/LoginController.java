package com.dm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dm.entity.ChannelInfo;
import com.dm.entity.UserInfo;
import com.dm.service.ChannelInfoService;
import com.dm.service.UserInfoService;
import com.dm.util.SessionKey;

@Controller
@RequestMapping("/")
public class LoginController extends BasicController {
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private ChannelInfoService channelInfoService;
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username == null||password == null){
			return new ModelAndView("redirect:login.jsp");
		}
		UserInfo userInfo = userInfoService.getUserInfo(username, password);
		if(userInfo == null){
			return new ModelAndView("redirect:login.jsp");
		}
		int userid = userInfo.getId();
		int userType = userInfo.getUsertype();
		String url = null;
		if (userType == 1) {
			List<ChannelInfo> channelInfoList = channelInfoService.getChannelInfoList(userid);
			if (channelInfoList == null || channelInfoList.size() == 0) {
				return new ModelAndView("redirect:login.jsp");
			}
			List<String> l = new ArrayList<String>();
			for (ChannelInfo vo : channelInfoList) {
				l.add("'" + vo.getChannelid() + "'");
			} 
			String channelIds = org.apache.commons.lang.StringUtils.join(l, ",");
			request.getSession().setAttribute(SessionKey.CHANNNELID, channelIds);
			url = "statics/income_profile.jsp";
		}else{
			url = "admin/income_profile.jsp";
		}
		ModelAndView modelAndView = new ModelAndView("redirect:"+url);
		request.getSession().setAttribute(SessionKey.USERID, userid);
		request.getSession().setAttribute(SessionKey.USERNAME, userInfo.getUsername());
		request.getSession().setAttribute(SessionKey.ROLEID, userType);
		return modelAndView;
	}
	
	@RequestMapping("/loginout")
	public ModelAndView loginout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		request.getSession().removeAttribute(SessionKey.CHANNNELID);
		request.getSession().removeAttribute(SessionKey.USERID);
		request.getSession().removeAttribute(SessionKey.USERNAME);
		request.getSession().removeAttribute(SessionKey.ROLEID);
		return new ModelAndView("redirect:login.jsp");
	}

}
