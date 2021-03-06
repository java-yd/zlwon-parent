package com.zlwon.rdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zlwon.rdb.entity.CharacteristicBusiness;

/**
 * 个人业务标签mapper
 * @author yangy
 *
 */

public interface CharacteristicBusinessMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(CharacteristicBusiness record);

    int insertSelective(CharacteristicBusiness record);

    CharacteristicBusiness selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CharacteristicBusiness record);

    int updateByPrimaryKey(CharacteristicBusiness record);
    
    /**
     * 根据父ID查询个人业务标签
     * @param parentId
     * @return
     */
    List<CharacteristicBusiness> selectCharacteristicBusinessByParentId(Integer parentId);
    
    /**
     * 根据ID字符串查询个人业务标签
     * @param idStr
     * @return
     */
    List<CharacteristicBusiness> selectCharacteristicBusinessByIdStr(@Param("idStr") String idStr);
}