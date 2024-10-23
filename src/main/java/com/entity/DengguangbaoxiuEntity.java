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
 * 灯光保修
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
@TableName("dengguangbaoxiu")
public class DengguangbaoxiuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DengguangbaoxiuEntity() {
		
	}
	
	public DengguangbaoxiuEntity(T t) {
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
	 * 设备名称
	 */
					
	private String shebeimingcheng;
	
	/**
	 * 灯光类型
	 */
					
	private String dengguangleixing;
	
	/**
	 * 是否维修
	 */
					
	private String shifouweixiu;
	
	/**
	 * 维修时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date weixiushijian;
	
	/**
	 * 灯光具体位置
	 */
					
	private String dengguangjutiweizhi;
	
	/**
	 * 灯光损害程度
	 */
					
	private String dengguangsunhaichengdu;
	
	/**
	 * 备注
	 */
					
	private String beizhu;
	
	/**
	 * 维修联系电话
	 */
					
	private String weixiulianxidianhua;
	
	
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
	 * 设置：设备名称
	 */
	public void setShebeimingcheng(String shebeimingcheng) {
		this.shebeimingcheng = shebeimingcheng;
	}
	/**
	 * 获取：设备名称
	 */
	public String getShebeimingcheng() {
		return shebeimingcheng;
	}
	/**
	 * 设置：灯光类型
	 */
	public void setDengguangleixing(String dengguangleixing) {
		this.dengguangleixing = dengguangleixing;
	}
	/**
	 * 获取：灯光类型
	 */
	public String getDengguangleixing() {
		return dengguangleixing;
	}
	/**
	 * 设置：是否维修
	 */
	public void setShifouweixiu(String shifouweixiu) {
		this.shifouweixiu = shifouweixiu;
	}
	/**
	 * 获取：是否维修
	 */
	public String getShifouweixiu() {
		return shifouweixiu;
	}
	/**
	 * 设置：维修时间
	 */
	public void setWeixiushijian(Date weixiushijian) {
		this.weixiushijian = weixiushijian;
	}
	/**
	 * 获取：维修时间
	 */
	public Date getWeixiushijian() {
		return weixiushijian;
	}
	/**
	 * 设置：灯光具体位置
	 */
	public void setDengguangjutiweizhi(String dengguangjutiweizhi) {
		this.dengguangjutiweizhi = dengguangjutiweizhi;
	}
	/**
	 * 获取：灯光具体位置
	 */
	public String getDengguangjutiweizhi() {
		return dengguangjutiweizhi;
	}
	/**
	 * 设置：灯光损害程度
	 */
	public void setDengguangsunhaichengdu(String dengguangsunhaichengdu) {
		this.dengguangsunhaichengdu = dengguangsunhaichengdu;
	}
	/**
	 * 获取：灯光损害程度
	 */
	public String getDengguangsunhaichengdu() {
		return dengguangsunhaichengdu;
	}
	/**
	 * 设置：备注
	 */
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
	/**
	 * 设置：维修联系电话
	 */
	public void setWeixiulianxidianhua(String weixiulianxidianhua) {
		this.weixiulianxidianhua = weixiulianxidianhua;
	}
	/**
	 * 获取：维修联系电话
	 */
	public String getWeixiulianxidianhua() {
		return weixiulianxidianhua;
	}

}
