package com.taotao.service;
/**
 * 商品分类业务逻辑接口
 * @author Junjunlei
 *
 */

import java.util.List;

import com.taotao.common.pojo.EasyUITreeNode;

public interface ItemCatService {
	/**
	 * 根据父节点id查询子节点
	 * 
	 * @param parentId
	 * @return
	 */
	public List<EasyUITreeNode> getItemCatList(Long parentId);
}
