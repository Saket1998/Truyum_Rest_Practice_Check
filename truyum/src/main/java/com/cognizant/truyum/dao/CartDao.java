package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.exception.GlobalExceptionHandler;
import com.cognizant.truyum.model.MenuItem;

public interface CartDao {

	void addCartItem(String userId,long menuItemId) throws GlobalExceptionHandler;
	
	List<MenuItem> getAllCartItems(String userId);
	
	void deleteCartItem(String userId,long menuItemId) throws GlobalExceptionHandler;
	
}
