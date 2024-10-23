package com.dao;

import com.entity.QicaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QicaiVO;
import com.entity.view.QicaiView;


/**
 * 器材
 * 
 * @author 
 * @email 
 * @date 2021-04-06 00:13:18
 */
public interface QicaiDao extends BaseMapper<QicaiEntity> {
	
	List<QicaiVO> selectListVO(@Param("ew") Wrapper<QicaiEntity> wrapper);
	
	QicaiVO selectVO(@Param("ew") Wrapper<QicaiEntity> wrapper);
	
	List<QicaiView> selectListView(@Param("ew") Wrapper<QicaiEntity> wrapper);

	List<QicaiView> selectListView(Pagination page,@Param("ew") Wrapper<QicaiEntity> wrapper);
	
	QicaiView selectView(@Param("ew") Wrapper<QicaiEntity> wrapper);
	
}
