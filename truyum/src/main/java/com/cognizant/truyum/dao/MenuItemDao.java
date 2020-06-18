package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.exception.GlobalExceptionHandler;
import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {

	List<MenuItem> getMenuItemListCustomer();
	
	void modifyMenuItem(MenuItem menuItem);
	
	MenuItem getMenuItem(long id)throws GlobalExceptionHandler;
}