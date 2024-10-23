package com.dao;

import com.entity.LikaidengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LikaidengjiVO;
import com.entity.view.LikaidengjiView;


/**
 * 离开登记
 * 
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
public interface LikaidengjiDao extends BaseMapper<LikaidengjiEntity> {
	
	List<LikaidengjiVO> selectListVO(@Param("ew") Wrapper<LikaidengjiEntity> wrapper);
	
	LikaidengjiVO selectVO(@Param("ew") Wrapper<LikaidengjiEntity> wrapper);
	
	List<LikaidengjiView> selectListView(@Param("ew") Wrapper<LikaidengjiEntity> wrapper);

	List<LikaidengjiView> selectListView(Pagination page,@Param("ew") Wrapper<LikaidengjiEntity> wrapper);
	
	LikaidengjiView selectView(@Param("ew") Wrapper<LikaidengjiEntity> wrapper);
	
}
