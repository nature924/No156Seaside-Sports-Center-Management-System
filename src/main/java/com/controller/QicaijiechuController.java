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

import com.entity.QicaijiechuEntity;
import com.entity.view.QicaijiechuView;

import com.service.QicaijiechuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 器材借出
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-06 00:13:19
 */
@RestController
@RequestMapping("/qicaijiechu")
public class QicaijiechuController {
    @Autowired
    private QicaijiechuService qicaijiechuService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QicaijiechuEntity qicaijiechu,
		@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date jiechushijianstart, 
    		@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date jiechushijianend,
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		qicaijiechu.setUserid((Long)request.getSession().getAttribute("userId"));
    	}
        EntityWrapper<QicaijiechuEntity> ew = new EntityWrapper<QicaijiechuEntity>();
		if(jiechushijianstart!=null) ew.ge("jiechushijian", jiechushijianstart);
        	if(jiechushijianend!=null) ew.le("jiechushijian", jiechushijianend);
		PageUtils page = qicaijiechuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qicaijiechu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QicaijiechuEntity qicaijiechu, HttpServletRequest request){
        EntityWrapper<QicaijiechuEntity> ew = new EntityWrapper<QicaijiechuEntity>();
		PageUtils page = qicaijiechuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qicaijiechu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QicaijiechuEntity qicaijiechu){
       	EntityWrapper<QicaijiechuEntity> ew = new EntityWrapper<QicaijiechuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qicaijiechu, "qicaijiechu")); 
        return R.ok().put("data", qicaijiechuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QicaijiechuEntity qicaijiechu){
        EntityWrapper< QicaijiechuEntity> ew = new EntityWrapper< QicaijiechuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qicaijiechu, "qicaijiechu")); 
		QicaijiechuView qicaijiechuView =  qicaijiechuService.selectView(ew);
		return R.ok("查询器材借出成功").put("data", qicaijiechuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QicaijiechuEntity qicaijiechu = qicaijiechuService.selectById(id);
        return R.ok().put("data", qicaijiechu);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QicaijiechuEntity qicaijiechu = qicaijiechuService.selectById(id);
        return R.ok().put("data", qicaijiechu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QicaijiechuEntity qicaijiechu, HttpServletRequest request){
    	qicaijiechu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qicaijiechu);
    	qicaijiechu.setUserid((Long)request.getSession().getAttribute("userId"));
        qicaijiechuService.insert(qicaijiechu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QicaijiechuEntity qicaijiechu, HttpServletRequest request){
    	qicaijiechu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qicaijiechu);
        qicaijiechuService.insert(qicaijiechu);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody QicaijiechuEntity qicaijiechu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qicaijiechu);
        qicaijiechuService.updateById(qicaijiechu);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qicaijiechuService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<QicaijiechuEntity> wrapper = new EntityWrapper<QicaijiechuEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}
		if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		wrapper.eq("userid", (Long)request.getSession().getAttribute("userId"));
    	}


		int count = qicaijiechuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
