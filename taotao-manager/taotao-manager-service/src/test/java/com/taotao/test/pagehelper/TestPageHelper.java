package com.taotao.test.pagehelper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

public class TestPageHelper {
	@Test
	public void testPageHelper() {
		// 初始化spring容器
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-*.xml");
		//获取mapper代理对象
		TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
		//设置分页信息
				PageHelper.startPage(1, 30);
				//执行查询
				TbItemExample example = new TbItemExample();
				List<TbItem> list = mapper.selectByExample(example);
				//取分页信息
				PageInfo<TbItem> pageInfo = new PageInfo<>(list);
				System.out.println(pageInfo.getTotal());
				System.out.println(pageInfo.getPages());
				System.out.println(pageInfo.getPageNum());
				System.out.println(pageInfo.getPageSize());
	}
}
