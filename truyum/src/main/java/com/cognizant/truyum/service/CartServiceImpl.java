package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.exception.GlobalExceptionHandler;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartServiceImpl implements CartService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);
	
	@Autowired
	CartDao cartDao;
	
	@Override
	public void addCartItem(String userId, long menuItemId) throws GlobalExceptionHandler {
		LOGGER.info("Start CartServiceImpl addCartItem");
		cartDao.addCartItem(userId, menuItemId);
		LOGGER.info("End CartServiceImpl addCartItem");
	}

	@Override
	public List<MenuItem> getAllCartItems(String userId) {
		LOGGER.info("Start CartServiceImpl getAllCartItems");
		LOGGER.info("End CartServiceImpl getAllCartItems");
		return cartDao.getAllCartItems(userId);
	}

	@Override
	public void deleteCartItem(String userId, long menuItemId) throws GlobalExceptionHandler {
		LOGGER.info("Start CartServiceImpl deleteCartItem");
		cartDao.deleteCartItem(userId,menuItemId);
		LOGGER.info("End CartServiceImpl deleteCartItem");
	}

}
