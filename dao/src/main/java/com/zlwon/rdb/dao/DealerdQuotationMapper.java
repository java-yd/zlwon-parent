package com.zlwon.rdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zlwon.rdb.entity.DealerdQuotation;
import com.zlwon.vo.pc.dealerQuotate.DealerdQuotationDetailVo;

/**
 * 物性表材料报价记录Mapper
 * @author yangy
 *
 */

public interface DealerdQuotationMapper {
    
	int deleteByPrimaryKey(Integer id);

    int insert(DealerdQuotation record);

    int insertSelective(DealerdQuotation record);

    DealerdQuotation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DealerdQuotation record);

    int updateByPrimaryKey(DealerdQuotation record);
    
    /**
     * 根据物性规格,用户ID和色号查询材料报价单（未驳回）
     * @param specId
     * @param color
     * @return
     */
    DealerdQuotation selectDealerdQuotationBySpecAndColor(@Param("specId") Integer specId,@Param("color") String color,@Param("userId") Integer userId);
    
    /**
     * 根据用户ID查询材料报价单
     * @param uid
     * @return
     */
    List<DealerdQuotationDetailVo> selectDealerdQuotationByUid(Integer uid);
    
    /**
     * 根据物性规格ID查询材料报价单
     * @param specId
     * @return
     */
    List<DealerdQuotationDetailVo> selectDealerdQuotationBySpecId(Integer specId);
    
    /**
     * 查询全部材料报价单
     * @return
     */
    List<DealerdQuotationDetailVo> selectAllDealerdQuotation();
    
    /**
     * 根据ID查询材料报价单详情
     * @return
     */
    DealerdQuotationDetailVo selectDealerdQuotationDetailById(Integer id);
}