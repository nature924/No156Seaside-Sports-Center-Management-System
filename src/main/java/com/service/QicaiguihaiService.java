package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QicaiguihaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QicaiguihaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QicaiguihaiView;


/**
 * 器材归还
 *
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
public interface QicaiguihaiService extends IService<QicaiguihaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QicaiguihaiVO> selectListVO(Wrapper<QicaiguihaiEntity> wrapper);
   	
   	QicaiguihaiVO selectVO(@Param("ew") Wrapper<QicaiguihaiEntity> wrapper);
   	
   	List<QicaiguihaiView> selectListView(Wrapper<QicaiguihaiEntity> wrapper);
   	
   	QicaiguihaiView selectView(@Param("ew") Wrapper<QicaiguihaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QicaiguihaiEntity> wrapper);
   	
}

