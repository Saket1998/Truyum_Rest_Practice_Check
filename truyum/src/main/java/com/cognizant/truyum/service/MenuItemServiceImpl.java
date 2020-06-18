package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.exception.GlobalExceptionHandler;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemServiceImpl implements MenuItemService{

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemServiceImpl.class);
	
	@Autowired
	MenuItemDao menuItemDao;
	
	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		LOGGER.info("Start MenuItemServiceImpl getMenuItemListCustomer");
		LOGGER.info("End MenuItemServiceImpl getMenuItemListCustomer");
		return menuItemDao.getMenuItemListCustomer();
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("Start MenuItemServiceImpl modifyMenuItem");
		menuItemDao.modifyMenuItem(menuItem);
		LOGGER.info("End MenuItemServiceImpl modifyMenuItem");
	}

	@Override
	public MenuItem getMenuItem(long id) throws GlobalExceptionHandler {
		LOGGER.info("Start MenuItemServiceImpl getMenuItem");
		LOGGER.info("End MenuItemServiceImpl getMenuItem");
		return menuItemDao.getMenuItem(id);
	}

}
