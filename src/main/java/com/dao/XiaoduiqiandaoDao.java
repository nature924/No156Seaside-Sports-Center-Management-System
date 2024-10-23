package com.dao;

import com.entity.XiaoduiqiandaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiaoduiqiandaoVO;
import com.entity.view.XiaoduiqiandaoView;


/**
 * 校队签到
 * 
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
public interface XiaoduiqiandaoDao extends BaseMapper<XiaoduiqiandaoEntity> {
	
	List<XiaoduiqiandaoVO> selectListVO(@Param("ew") Wrapper<XiaoduiqiandaoEntity> wrapper);
	
	XiaoduiqiandaoVO selectVO(@Param("ew") Wrapper<XiaoduiqiandaoEntity> wrapper);
	
	List<XiaoduiqiandaoView> selectListView(@Param("ew") Wrapper<XiaoduiqiandaoEntity> wrapper);

	List<XiaoduiqiandaoView> selectListView(Pagination page,@Param("ew") Wrapper<XiaoduiqiandaoEntity> wrapper);
	
	XiaoduiqiandaoView selectView(@Param("ew") Wrapper<XiaoduiqiandaoEntity> wrapper);
	
}
