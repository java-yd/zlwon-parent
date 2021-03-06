package com.zlwon.pc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.zlwon.dto.applicationCase.ApplicationCaseDto;
import com.zlwon.dto.pc.applicationCase.QueryApplicationCaseListDto;
import com.zlwon.pc.annotations.AuthLogin;
import com.zlwon.rdb.entity.ApplicationCase;
import com.zlwon.rest.ResultData;
import com.zlwon.rest.ResultPage;
import com.zlwon.server.service.ApplicationCaseService;
import com.zlwon.server.service.CollectionService;
import com.zlwon.vo.pc.applicationCase.ApplicationCaseDetailsVo;
import com.zlwon.vo.pc.applicationCase.EditApplicationCaseCustomerVo;
import com.zlwon.vo.pc.applicationCase.IndexHotApplicationCaseVo;

/**
 * 案例api
 * @author yuand
 *
 */
@RestController
@RequestMapping("/pc/applicationCase")
public class ApplicationCaseController {

	@Autowired
	private   ApplicationCaseService   applicationCaseService;
	@Autowired
	private   CollectionService   collectionService;
	
	
	/**
	 * 根据案例id，得到案例详情
	 * @return 案例id
	 */
	@RequestMapping(value="queryApplicationCaseDetails",method=RequestMethod.GET)
	public   ResultData   queryApplicationCaseDetails(Integer  id,HttpServletRequest  request){
		ApplicationCaseDetailsVo   record = applicationCaseService.findApplicationCaseDetailsMake(id,request,1);
		return   ResultData.one(record);
	}
	
	
	/**
	 * 用户修改案例信息
	 * @param request
	 * @param applicationCase
	 * 			id:案例id，必传
	 * 			selectRequirements:选材要求,未修改传null
	 * 			selectCause:选材原因,未修改传null
	 * 			setting:案例背景,未修改传null
	 * @return
	 */
	@AuthLogin
	@RequestMapping(value="editApplicationCase",method=RequestMethod.POST)
	public  ResultData  editApplicationCase(HttpServletRequest  request,ApplicationCase  applicationCase){
		applicationCaseService.alterApplicationCaseByUser(request,applicationCase);
		return   ResultData.ok();
	}
	
	/**
	 * 用户添加案例
	 * @param request
	 * @param applicationCase
	 * @return
	 */
	@AuthLogin
	@RequestMapping(value="addApplicationCase",method=RequestMethod.POST)
	public  ResultData  addApplicationCase(HttpServletRequest  request,ApplicationCaseDto  applicationCase){
		applicationCaseService.saveApplicateCase(request,applicationCase,0);
		return   ResultData.ok();
	}
	
	/**
	 * 得到所有案例，条件查询，分页
	 * @param pageIndex
	 * @param pageSize
	 * @param listVo 条件查询
	 * @return
	 */
	@RequestMapping(value="queryAllApplicationCase",method=RequestMethod.POST)
	public  ResultPage  queryAllApplicationCase(HttpServletRequest  request,@RequestParam(defaultValue="1")Integer  pageIndex,
			@RequestParam(defaultValue="10")Integer  pageSize,QueryApplicationCaseListDto  listDto){
		PageInfo  info = applicationCaseService.findAllApplicationCaseSelective(request,pageIndex, pageSize,listDto,1);
		return   ResultPage.list(info);
	}
	
	
	/**
	 * 首页热门案例查询
	 * @return
	 */
	@RequestMapping(value="queryHotApplicationCase",method=RequestMethod.GET)
	public  ResultData  queryHotApplicationCase(){
		List<IndexHotApplicationCaseVo>  list = applicationCaseService.findHotApplicationCase();
		return  ResultData.one(list);
	}
	
	
	/**
	 * 根据案例id，得到编辑过案例的用户信息，分类型获取
	 * @param id 案例id
	 * @param type 类型0：所有1：案例背景2：选材原因3：选材要求
	 * @return
	 */
	@RequestMapping(value="queryEditApplicationCaseCustomer",method=RequestMethod.GET)
	public  ResultData  queryEditApplicationCaseCustomer(Integer  id,@RequestParam(defaultValue="0")Integer   type){
		List<EditApplicationCaseCustomerVo>  list = applicationCaseService.findEditApplicationCaseCustomerById(id,type);
		return  ResultData.one(list);
	}
	
	
	
	
}
