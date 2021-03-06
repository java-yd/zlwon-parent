package com.zlwon.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.zlwon.rest.ResultData;
import com.zlwon.rest.ResultPage;
import com.zlwon.server.service.InvitationRecordService;
import com.zlwon.vo.invitationRecord.InvitationRecordVo;
import com.zlwon.web.annotations.AuthLogin;

/**
 * 企业邀请知料师
 * @author FelixChen
 *
 */
@AuthLogin
@RestController
@RequestMapping("invitationRecord")
public class InvitationRecordController {

	@Autowired
	private   InvitationRecordService   invitationRecordService;
	
	/**
	 * 得到所有企业邀请的知料师信息，分页查找
	 * @param pageIndex 
	 * @param pageSize
	 * @param invitation 邀请接受状态，0邀请确认中，1接受，-1拒绝
	 * @return
	 */
	@RequestMapping(value="queryAllInvitationRecord",method=RequestMethod.GET)
	public  ResultPage  queryAllInvitationRecord(@RequestParam(defaultValue="${page.pageIndex}")Integer  pageIndex,
			@RequestParam(defaultValue="${page.pageSize}")Integer  pageSize,Integer  invitation){
		PageInfo pageInfo = invitationRecordService.findAllInvitationRecord(pageIndex,pageSize,invitation);
		return  ResultPage.list(pageInfo);
	}
	
	/**
	 * 得到所有企业邀请的知料师信息，不分页
	 * @param invitation 邀请接受状态，0邀请确认中，1接受，-1拒绝
	 * @return
	 */
	@RequestMapping(value="queryAllInvitationRecordDeatils",method=RequestMethod.GET)
	public  ResultData  queryAllInvitationRecordDeatils(Integer  invitation){
		List<InvitationRecordVo> list = invitationRecordService.findAllInvitationRecord(invitation);
		return  ResultData.one(list);
	}
	
	/**
	 * 根据邀请id，删除邀请信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="cancelInvitationRecordById",method=RequestMethod.GET)
	public  ResultData cancelInvitationRecordById(Integer  id){
		invitationRecordService.removeInvitationRecordById(id);
		return  ResultData.ok();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
