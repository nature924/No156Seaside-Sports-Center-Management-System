package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QicaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QicaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QicaiView;


/**
 * 器材
 *
 * @author 
 * @email 
 * @date 2021-04-06 00:13:18
 */
public interface QicaiService extends IService<QicaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QicaiVO> selectListVO(Wrapper<QicaiEntity> wrapper);
   	
   	QicaiVO selectVO(@Param("ew") Wrapper<QicaiEntity> wrapper);
   	
   	List<QicaiView> selectListView(Wrapper<QicaiEntity> wrapper);
   	
   	QicaiView selectView(@Param("ew") Wrapper<QicaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QicaiEntity> wrapper);
   	
}

