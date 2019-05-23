package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;

/**
 * 商品业务逻辑接口实现类
 * 
 * @author Junjunlei
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;

	@Override
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {

		//设置分页信息
		PageHelper.startPage(page,rows);
		//执行查询
		TbItemExample example =new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		//获取取分页信息
		PageInfo<TbItem> pageInfo=new PageInfo<TbItem>(list);
		//创建返回对象
		EasyUIDataGridResult result=new EasyUIDataGridResult();
		result.setTotal((int)pageInfo.getTotal());
		result.setRows(list);
		return result;
	}

}
