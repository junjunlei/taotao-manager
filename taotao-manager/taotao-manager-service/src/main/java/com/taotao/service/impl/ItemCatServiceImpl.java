package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.ItemCatService;

/**
 * 商品类目选择业务逻辑实现类
 * 
 * @author Junjunlei
 *
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<EasyUITreeNode> getItemCatList(Long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		// 查询条件
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		// 执行查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		// 转为返回值所需要的list
		List<EasyUITreeNode> resultList = new ArrayList<EasyUITreeNode>();
		EasyUITreeNode node = null;
		for (TbItemCat itemCat : list) {
			node = new EasyUITreeNode();
			node.setId(itemCat.getId());
			node.setState(itemCat.getIsParent()?"closed":"open");
			node.setText(itemCat.getName());
			resultList.add(node);
		}
		return resultList;
	}

}
