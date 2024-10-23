package com.entity.view;

import com.entity.QicaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 器材
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-06 00:13:18
 */
@TableName("qicai")
public class QicaiView  extends QicaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public QicaiView(){
	}
 
 	public QicaiView(QicaiEntity qicaiEntity){
 	try {
			BeanUtils.copyProperties(this, qicaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
