package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LikaidengjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LikaidengjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LikaidengjiView;


/**
 * 离开登记
 *
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
public interface LikaidengjiService extends IService<LikaidengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LikaidengjiVO> selectListVO(Wrapper<LikaidengjiEntity> wrapper);
   	
   	LikaidengjiVO selectVO(@Param("ew") Wrapper<LikaidengjiEntity> wrapper);
   	
   	List<LikaidengjiView> selectListView(Wrapper<LikaidengjiEntity> wrapper);
   	
   	LikaidengjiView selectView(@Param("ew") Wrapper<LikaidengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LikaidengjiEntity> wrapper);
   	
}

