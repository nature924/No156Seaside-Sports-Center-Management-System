package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JinrudengjiEntity;
import com.entity.view.JinrudengjiView;

import com.service.JinrudengjiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 进入登记
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
@RestController
@RequestMapping("/jinrudengji")
public class JinrudengjiController {
    @Autowired
    private JinrudengjiService jinrudengjiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JinrudengjiEntity jinrudengji,
		@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date tiyuguanjinrushijianstart, 
    		@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date tiyuguanjinrushijianend,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		jinrudengji.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<JinrudengjiEntity> ew = new EntityWrapper<JinrudengjiEntity>();
		if(tiyuguanjinrushijianstart!=null) ew.ge("tiyuguanjinrushijian", tiyuguanjinrushijianstart);
        	if(tiyuguanjinrushijianend!=null) ew.le("tiyuguanjinrushijian", tiyuguanjinrushijianend);
		PageUtils page = jinrudengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jinrudengji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JinrudengjiEntity jinrudengji, HttpServletRequest request){
        EntityWrapper<JinrudengjiEntity> ew = new EntityWrapper<JinrudengjiEntity>();
		PageUtils page = jinrudengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jinrudengji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JinrudengjiEntity jinrudengji){
       	EntityWrapper<JinrudengjiEntity> ew = new EntityWrapper<JinrudengjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jinrudengji, "jinrudengji")); 
        return R.ok().put("data", jinrudengjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JinrudengjiEntity jinrudengji){
        EntityWrapper< JinrudengjiEntity> ew = new EntityWrapper< JinrudengjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jinrudengji, "jinrudengji")); 
		JinrudengjiView jinrudengjiView =  jinrudengjiService.selectView(ew);
		return R.ok("查询进入登记成功").put("data", jinrudengjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JinrudengjiEntity jinrudengji = jinrudengjiService.selectById(id);
        return R.ok().put("data", jinrudengji);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JinrudengjiEntity jinrudengji = jinrudengjiService.selectById(id);
        return R.ok().put("data", jinrudengji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JinrudengjiEntity jinrudengji, HttpServletRequest request){
    	jinrudengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jinrudengji);
    	jinrudengji.setUserid((Long)request.getSession().getAttribute("userId"));
        jinrudengjiService.insert(jinrudengji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JinrudengjiEntity jinrudengji, HttpServletRequest request){
    	jinrudengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jinrudengji);
        jinrudengjiService.insert(jinrudengji);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody JinrudengjiEntity jinrudengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jinrudengji);
        jinrudengjiService.updateById(jinrudengji);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jinrudengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<JinrudengjiEntity> wrapper = new EntityWrapper<JinrudengjiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}
		if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		wrapper.eq("userid", (Long)request.getSession().getAttribute("userId"));
    	}


		int count = jinrudengjiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
