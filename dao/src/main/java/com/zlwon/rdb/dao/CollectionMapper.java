package com.zlwon.rdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zlwon.dto.collection.JudgeCollectionDto;
import com.zlwon.rdb.entity.Collection;

/**
 * 用户收藏Mapper
 * @author yangy
 *
 */

public interface CollectionMapper {

	/**
	 * 新增用户收藏
	 * @param insertInfo
	 * @return
	 */
	int insertCollection(Collection insertInfo);
	
	/**
	 * 根据用户ID和信息ID，信息类型查询用户收藏
	 * @param selInfo
	 * @return
	 */
	Collection selectCollectionByUserAndInfo(JudgeCollectionDto selInfo);
	
	/**
	 * 根据用户ID和信息ID，信息类型查询用户收藏
	 * @param type
	 * @param iid
	 * @param userId
	 * @return
	 */
	Collection selectCollectionInfoByUser(@Param("type") Integer type,@Param("iid") Integer iid,@Param("userId") Integer userId);
	
	/**
	 * 根据id查询用户收藏
	 * @param id
	 * @return
	 */
	Collection selectCollectionById(Integer id);
	
	/**
	 * 根据id删除用户收藏
	 * @param id
	 * @return
	 */
	int deleteCollectionById(Integer id);
	
	/**
	 * 测试方法
	 * @return
	 */
	List<Collection> getCollectionTestList();
}
