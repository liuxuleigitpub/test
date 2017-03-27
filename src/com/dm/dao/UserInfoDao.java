package com.dm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dm.entity.ChannelUserInfo;
import com.dm.entity.UserInfo;

public interface UserInfoDao {
	
	public UserInfo getUserInfo(@Param("username")String username, @Param("password")String password);

	public int getUserInfoCount(@Param("userName")String userName,@Param("usertype")int usertype);

	public List<UserInfo> getUserInfoByPage(@Param("startNum")int startNum,
			@Param("pageSize")int pageSize, @Param("userName")String userName,@Param("usertype")int usertype);

	public int addUserInfo(UserInfo userInfo);

	public int updateUserInfo(@Param("userInfo")UserInfo userInfo);
	
	public int deleteUserInfo(@Param("userInfo")UserInfo userInfo);
	public int getChannelUserCount(@Param("id")List<Integer> id);
	
	public List<UserInfo> getChannelUserByPage(@Param("startNum")int startNum,@Param("pageSize")int pageSize, @Param("userid")int userid);
	
	public List<UserInfo> getChannelUserByPageList(@Param("startNum")int startNum,@Param("pageSize")int pageSize, @Param("id")List<Integer> id);

	public List<Integer> getUserId(@Param("chid")int chid);

	public int addUserByChannel(@Param("userInfo")UserInfo userInfo);

	public int addUseridAndChid(@Param("userid")int userid,@Param("chid")int chid);

	public int updateUserByChannel(@Param("userInfo")UserInfo userInfo);

	public void deleteUserByChid(@Param("userInfo")UserInfo userInfo);

	public int GetChidByChannelid(@Param("channelUserInfo")ChannelUserInfo channelUserInfo);

	public int addChannelidByUserid(@Param("channelUserInfo")ChannelUserInfo channelUserInfo);

}