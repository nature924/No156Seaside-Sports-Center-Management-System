package com.dao;

import com.entity.DengguangbaoxiuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DengguangbaoxiuVO;
import com.entity.view.DengguangbaoxiuView;


/**
 * 灯光保修
 * 
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
public interface DengguangbaoxiuDao extends BaseMapper<DengguangbaoxiuEntity> {
	
	List<DengguangbaoxiuVO> selectListVO(@Param("ew") Wrapper<DengguangbaoxiuEntity> wrapper);
	
	DengguangbaoxiuVO selectVO(@Param("ew") Wrapper<DengguangbaoxiuEntity> wrapper);
	
	List<DengguangbaoxiuView> selectListView(@Param("ew") Wrapper<DengguangbaoxiuEntity> wrapper);

	List<DengguangbaoxiuView> selectListView(Pagination page,@Param("ew") Wrapper<DengguangbaoxiuEntity> wrapper);
	
	DengguangbaoxiuView selectView(@Param("ew") Wrapper<DengguangbaoxiuEntity> wrapper);
	
}
