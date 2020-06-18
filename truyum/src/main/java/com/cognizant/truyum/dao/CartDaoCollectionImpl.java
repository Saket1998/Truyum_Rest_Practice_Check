package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.exception.GlobalExceptionHandler;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@Repository
public class CartDaoCollectionImpl implements CartDao{

	private static final Logger LOGGER = LoggerFactory.getLogger(CartDaoCollectionImpl.class);
	
	private static Map<String,Cart> cartItems = new HashMap<>();
	
	@Autowired
	MenuItemService menuItemService;
	
	@Override
	public void addCartItem(String userId, long menuItemId) throws GlobalExceptionHandler {
		LOGGER.info("Start CartDaoCollectionImpl addCartItem");
		MenuItem mi = menuItemService.getMenuItem(menuItemId);
		if(cartItems.containsKey(userId))
		{
			Cart user = cartItems.get(userId);
			List<MenuItem> list = user.getMenuItem_List();
			list.add(mi);
			user.setMenuItem_List(list);
			user.setTotal(user.getTotal()+mi.getPrice());
			cartItems.put(userId, user);
		}
		else
		{
			Cart user1 = new Cart();
			List<MenuItem> list = new ArrayList<>();
			list.add(mi);
			user1.setMenuItem_List(list);
			user1.setTotal(mi.getPrice());
			cartItems.put(userId, user1);
		}
		LOGGER.info("End CartDaoCollectionImpl addCartItem");
	}

	@Override
	public List<MenuItem> getAllCartItems(String userId) {
		Cart cart = cartItems.get(userId);
		LOGGER.info("Start CartDaoCollectionImpl getAllCartItems");
		LOGGER.info("End CartDaoCollectionImpl getAllCartItems");
		return cart.getMenuItem_List();
	}

	@Override
	public void deleteCartItem(String userId, long menuItemId) throws GlobalExceptionHandler {
		LOGGER.info("Start CartDaoCollectionImpl deleteCartItem");
		MenuItem item = menuItemService.getMenuItem(menuItemId);
		Cart cart = cartItems.get(userId);
		List<MenuItem> list=cart.getMenuItem_List();
		list.remove(item);
		cart.setTotal(cart.getTotal()-item.getPrice());
		cartItems.put(userId, cart);
		LOGGER.info("End CartDaoCollectionImpl deleteCartItem");
	}

}
