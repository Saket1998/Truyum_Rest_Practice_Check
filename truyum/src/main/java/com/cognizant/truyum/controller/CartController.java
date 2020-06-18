package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.GlobalExceptionHandler;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	CartService cartService;
	
	@PostMapping("/{userId}/{menuItemId}")
	void addCartItem(@PathVariable String userId, @PathVariable long menuItemId)throws GlobalExceptionHandler{
		LOGGER.info("Start CartController addCartItem");
		cartService.addCartItem(userId, menuItemId);
		LOGGER.info("End CartController addCartItem");
	}
	
	@GetMapping("/{userId}")
	List<MenuItem> getAllCartItems(@PathVariable String userId){
		LOGGER.info("Start CartController getAllCartItems");
		LOGGER.info("End CartController getAllCartItems");
		return cartService.getAllCartItems(userId);
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	void deleteCartItem(@PathVariable String userId, @PathVariable long menuItemId)throws GlobalExceptionHandler{
		LOGGER.info("Start CartController deleteCartItem");
		cartService.deleteCartItem(userId, menuItemId);
		LOGGER.info("End CartController deleteCartItem");
	}
}
