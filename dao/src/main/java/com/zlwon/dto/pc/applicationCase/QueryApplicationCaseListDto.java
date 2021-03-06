package com.zlwon.dto.pc.applicationCase;

import lombok.Data;

/**
 * pc官网，查询所有案例条件查询
 * @author yuand
 *
 */
@Data
public class QueryApplicationCaseListDto {

	private  String  mids;//生产商id多个用,隔开
	
	private  String  tids;//商标id多个用,隔开
	
	private  Integer  industryId;//应用行业id，单选
	
	private  String  marketIds;//应用市场id多个用,隔开
	
	private  String   key;//关键字，搜索的是应用产品
	
	private  Integer  uid;//当前用户id，案例列表需要标识该用户是否收藏案例,从redis中获取
	
}
