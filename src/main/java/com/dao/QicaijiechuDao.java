package com.dao;

import com.entity.QicaijiechuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QicaijiechuVO;
import com.entity.view.QicaijiechuView;


/**
 * 器材借出
 * 
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
public interface QicaijiechuDao extends BaseMapper<QicaijiechuEntity> {
	
	List<QicaijiechuVO> selectListVO(@Param("ew") Wrapper<QicaijiechuEntity> wrapper);
	
	QicaijiechuVO selectVO(@Param("ew") Wrapper<QicaijiechuEntity> wrapper);
	
	List<QicaijiechuView> selectListView(@Param("ew") Wrapper<QicaijiechuEntity> wrapper);

	List<QicaijiechuView> selectListView(Pagination page,@Param("ew") Wrapper<QicaijiechuEntity> wrapper);
	
	QicaijiechuView selectView(@Param("ew") Wrapper<QicaijiechuEntity> wrapper);
	
}
