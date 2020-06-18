package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.exception.GlobalExceptionHandler;
import com.cognizant.truyum.model.MenuItem;

@Repository
public class MenuItemDaoCollectionImpl implements MenuItemDao{

	private static List<MenuItem> menuItem_List = new ArrayList<>();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemDaoCollectionImpl.class);
	
	public MenuItemDaoCollectionImpl() {
		ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
		menuItem_List=(List<MenuItem>)context.getBean("menuItemList");
	}
	
	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		LOGGER.debug("MenuItems : {}",menuItem_List);
		return menuItem_List;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("Start MenuItemDaoCollectionImpl modifyMenuItem");
		try {
			MenuItem item = getMenuItem(menuItem.getId());
			item.setName(menuItem.getName());
			item.setPrice(menuItem.getPrice());
			item.setActive(menuItem.isActive());
			item.setDateOfLaunch(menuItem.getDateOfLaunch());
			item.setCategory(menuItem.getCategory());
			item.setFreeDelivery(menuItem.isFreeDelivery());
		}
		catch(GlobalExceptionHandler e){
			e.getMessage();
		}
		LOGGER.info("End MenuItemDaoCollectionImpl modifyMenuItem");
	}

	@Override
	public MenuItem getMenuItem(long id) throws GlobalExceptionHandler {
		LOGGER.info("Start MenuItemDaoCollectionImpl getMenuItem");
		MenuItem item=null;
		for (MenuItem i :menuItem_List) {
			if(id==i.getId())
				item=i;
		}
		LOGGER.info("End MenuItemDaoCollectionImpl getMenuItem");
		if(item==null)
			throw new GlobalExceptionHandler("Menu Item Not Found");
		else
			return item;
	}

}
