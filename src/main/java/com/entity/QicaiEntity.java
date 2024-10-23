package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 器材
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-04-06 00:13:18
 */
@TableName("qicai")
public class QicaiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public QicaiEntity() {
		
	}
	
	public QicaiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 器材编号
	 */
					
	private String qicaibianhao;
	
	/**
	 * 器材名称
	 */
					
	private String qicaimingcheng;
	
	/**
	 * 器材分类
	 */
					
	private String qicaifenlei;
	
	/**
	 * 器材注意事项
	 */
					
	private String qicaizhuyishixiang;
	
	/**
	 * 器材说明
	 */
					
	private String qicaishuoming;
	
	/**
	 * 器材图片
	 */
					
	private String qicaitupian;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：器材编号
	 */
	public void setQicaibianhao(String qicaibianhao) {
		this.qicaibianhao = qicaibianhao;
	}
	/**
	 * 获取：器材编号
	 */
	public String getQicaibianhao() {
		return qicaibianhao;
	}
	/**
	 * 设置：器材名称
	 */
	public void setQicaimingcheng(String qicaimingcheng) {
		this.qicaimingcheng = qicaimingcheng;
	}
	/**
	 * 获取：器材名称
	 */
	public String getQicaimingcheng() {
		return qicaimingcheng;
	}
	/**
	 * 设置：器材分类
	 */
	public void setQicaifenlei(String qicaifenlei) {
		this.qicaifenlei = qicaifenlei;
	}
	/**
	 * 获取：器材分类
	 */
	public String getQicaifenlei() {
		return qicaifenlei;
	}
	/**
	 * 设置：器材注意事项
	 */
	public void setQicaizhuyishixiang(String qicaizhuyishixiang) {
		this.qicaizhuyishixiang = qicaizhuyishixiang;
	}
	/**
	 * 获取：器材注意事项
	 */
	public String getQicaizhuyishixiang() {
		return qicaizhuyishixiang;
	}
	/**
	 * 设置：器材说明
	 */
	public void setQicaishuoming(String qicaishuoming) {
		this.qicaishuoming = qicaishuoming;
	}
	/**
	 * 获取：器材说明
	 */
	public String getQicaishuoming() {
		return qicaishuoming;
	}
	/**
	 * 设置：器材图片
	 */
	public void setQicaitupian(String qicaitupian) {
		this.qicaitupian = qicaitupian;
	}
	/**
	 * 获取：器材图片
	 */
	public String getQicaitupian() {
		return qicaitupian;
	}

}
