package com.dm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.dm.entity.ChannelInfo;
import com.dm.entity.ChannelUserInfo;
import com.dm.service.ChannelInfoService;
import com.dm.util.PageData;
import com.dm.util.SessionKey;
import com.dm.util.redis.RedisFactory;

@Controller
@RequestMapping("/channel")
public class ChannelInfoController extends BasicController {
	@Autowired
	private ChannelInfoService channelInfoService;
	
	@RequestMapping("/dataStatics")
	public void dataStatics(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		JSONObject json = new JSONObject();
		String channelIds = (String)request.getSession().getAttribute(SessionKey.CHANNNELID);
		List<Map<String,Object>> list = channelInfoService.getChannelStatic(channelIds, starttime, endtime);
		json.put("list", list);
		writeJSON(response, json);
	}
	@RequestMapping("/orderlist")
	public void orderlist(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String starttime = request.getParameter("starttime")+" 00:00:00";
		String endtime = request.getParameter("endtime")+" 23:59:59";
		String channelid = request.getParameter("channelid");
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		String channelIds = (String)request.getSession().getAttribute(SessionKey.CHANNNELID);
		int roleId = (int)request.getSession().getAttribute(SessionKey.ROLEID);
		PageData<Map<String, Object>> pageData = new PageData<Map<String, Object>>();
		if((roleId==1&&channelIds.contains("'"+channelid+"'"))||roleId==0){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("starttime", starttime);
			map.put("endtime", endtime);
			map.put("channelid", channelid);
			map.put("page", page);
			map.put("pageSize", pageSize);
			map.put("roleId", roleId);
			pageData = channelInfoService.getOrderlistByPage(map);
		}
		writeJSON(response, pageData.toJSON());
	}
	@RequestMapping("/dataStaticsdetail")
	public void dataStaticsdetail(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int pageNum = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		int userId = Integer.parseInt(request.getParameter("userid"));
		PageData<ChannelInfo> list = channelInfoService.getChannelInfoByPage(pageNum, pageSize,userId);
		writeJSON(response, list.toJSON());
	}
	@RequestMapping("/admindataStatics")
	public void adminDataStatics(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		JSONObject json = new JSONObject();
		List<Map<String,Object>> list = channelInfoService.getAdminChannelStatic(starttime, endtime);
		json.put("list", list);
		writeJSON(response, json);
	}
	
	@RequestMapping("/channelInfoList")
	public void channelInfoList(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int pageNum = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		int userId = Integer.parseInt(request.getParameter("userid"));
		PageData<ChannelInfo> list = channelInfoService.getChannelInfoByPage(pageNum, pageSize,userId);
		writeJSON(response, list.toJSON());
	}
	@RequestMapping("/getchannellistbyuser")
	public void getchannellistbyuser(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int pageNum = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		int userId = Integer.parseInt(request.getParameter("userid"));
		PageData<ChannelInfo> list = channelInfoService.getChannelListByUser(pageNum, pageSize,userId);
		writeJSON(response, list.toJSON());
	}
	@RequestMapping("/channelDetailInfoList")
	public void channelDetailInfoList(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int pageNum = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		String channelid = request.getParameter("channelid");
		PageData<ChannelInfo> list = channelInfoService.getDetailChannelInfoList(pageNum, pageSize,channelid);
		writeJSON(response, list.toJSON());
	}
	@RequestMapping("/addchannelinfo")
	public void addChannelInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String channelid = request.getParameter("channelid");
		int klxs = Integer.parseInt(request.getParameter("klxs"));
		ChannelInfo channelInfo = new ChannelInfo();
		channelInfo.setChannelid(channelid);
		channelInfo.setKlxs(klxs);
		int n = channelInfoService.addChannelInfo(channelInfo);
		RedisFactory.set("VEDIODEDUTIONKEY_" + channelid, klxs+"");
		writeInt(response, n);
	}
	@RequestMapping("/addchannelinfobyuser")
	public void addchannelinfobyuser(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String channelid = request.getParameter("channelid");
		int klxs = Integer.parseInt(request.getParameter("klxs"));
		int userid = Integer.parseInt(request.getParameter("userid"));
		ChannelUserInfo channelUserInfo = new ChannelUserInfo();
		channelUserInfo.setChannelid(channelid);
		channelUserInfo.setKlxs(klxs);
		channelUserInfo.setUserid(userid);
		int n = channelInfoService.addChannelInfoByUserid(channelUserInfo);
		RedisFactory.set("VEDIODEDUTIONKEY_" + channelid, klxs+"");
		writeInt(response, n);
	}

	@RequestMapping("/updatechannelinfo")
	public void updateChannelInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String channelid = request.getParameter("channelid");
		int klxs = Integer.parseInt(request.getParameter("klxs"));
		ChannelInfo channelInfo = new ChannelInfo();
		channelInfo.setChannelid(channelid);
		channelInfo.setKlxs(klxs);
		int n = channelInfoService.updatechannelinfo(channelInfo);
		RedisFactory.set("VEDIODEDUTIONKEY_" + channelid, klxs+"");
		writeInt(response, n);
	}
	@RequestMapping("/deletechannelinfo")
	public void deletechannelinfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		int n = channelInfoService.deletechannelinfo(id);
		writeInt(response, n);
	}
	@RequestMapping("/getallchannel")
	public void getallchannel(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int userid = Integer.parseInt(request.getParameter("id"));
		System.out.println("userid"+userid);
		ChannelUserInfo channelUserInfo  = new ChannelUserInfo();
		channelUserInfo.setUserid(userid);
		List<Map<String,Object>> list = channelInfoService.getAllChannel(channelUserInfo);
		JSONObject json = new JSONObject();
		json.put("list", list);
		writeJSON(response, json);
	}
	
}
