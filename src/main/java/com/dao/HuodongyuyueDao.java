package com.dao;

import com.entity.HuodongyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuodongyuyueVO;
import com.entity.view.HuodongyuyueView;


/**
 * 活动预约
 * 
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
public interface HuodongyuyueDao extends BaseMapper<HuodongyuyueEntity> {
	
	List<HuodongyuyueVO> selectListVO(@Param("ew") Wrapper<HuodongyuyueEntity> wrapper);
	
	HuodongyuyueVO selectVO(@Param("ew") Wrapper<HuodongyuyueEntity> wrapper);
	
	List<HuodongyuyueView> selectListView(@Param("ew") Wrapper<HuodongyuyueEntity> wrapper);

	List<HuodongyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<HuodongyuyueEntity> wrapper);
	
	HuodongyuyueView selectView(@Param("ew") Wrapper<HuodongyuyueEntity> wrapper);
	
}
