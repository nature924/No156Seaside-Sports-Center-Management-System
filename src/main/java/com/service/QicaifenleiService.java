package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QicaifenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QicaifenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QicaifenleiView;


/**
 * 器材分类
 *
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
public interface QicaifenleiService extends IService<QicaifenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QicaifenleiVO> selectListVO(Wrapper<QicaifenleiEntity> wrapper);
   	
   	QicaifenleiVO selectVO(@Param("ew") Wrapper<QicaifenleiEntity> wrapper);
   	
   	List<QicaifenleiView> selectListView(Wrapper<QicaifenleiEntity> wrapper);
   	
   	QicaifenleiView selectView(@Param("ew") Wrapper<QicaifenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QicaifenleiEntity> wrapper);
   	
}

