package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
/**
 * 商品业务逻辑接口
 * @author Junjunlei
 *
 */
public interface ItemService {
	/**
	 * 获取商品列表
	 * @param page 当前页
	 * @param rows 每页显示条数
	 * @return
	 */
	public EasyUIDataGridResult getItemList(Integer page,Integer rows);
}
