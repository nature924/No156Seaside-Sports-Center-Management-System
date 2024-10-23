package com.dao;

import com.entity.JinrudengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JinrudengjiVO;
import com.entity.view.JinrudengjiView;


/**
 * 进入登记
 * 
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
public interface JinrudengjiDao extends BaseMapper<JinrudengjiEntity> {
	
	List<JinrudengjiVO> selectListVO(@Param("ew") Wrapper<JinrudengjiEntity> wrapper);
	
	JinrudengjiVO selectVO(@Param("ew") Wrapper<JinrudengjiEntity> wrapper);
	
	List<JinrudengjiView> selectListView(@Param("ew") Wrapper<JinrudengjiEntity> wrapper);

	List<JinrudengjiView> selectListView(Pagination page,@Param("ew") Wrapper<JinrudengjiEntity> wrapper);
	
	JinrudengjiView selectView(@Param("ew") Wrapper<JinrudengjiEntity> wrapper);
	
}
