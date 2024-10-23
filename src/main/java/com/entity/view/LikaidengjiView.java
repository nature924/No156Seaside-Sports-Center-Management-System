package com.entity.view;

import com.entity.LikaidengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 离开登记
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
@TableName("likaidengji")
public class LikaidengjiView  extends LikaidengjiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LikaidengjiView(){
	}
 
 	public LikaidengjiView(LikaidengjiEntity likaidengjiEntity){
 	try {
			BeanUtils.copyProperties(this, likaidengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
