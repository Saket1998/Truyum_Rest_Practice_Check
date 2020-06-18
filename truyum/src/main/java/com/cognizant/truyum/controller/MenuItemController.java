package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.GlobalExceptionHandler;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
	
	@Autowired
	MenuItemService menuItemService;
	
	@GetMapping()
	public List<MenuItem> getAllMenuItems(){
		LOGGER.info("Start MenuItemController getAllMenuItems");
		LOGGER.info("End MenuItemController getAllMenuItems");
		return menuItemService.getMenuItemListCustomer();
	}
	
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable long id)throws GlobalExceptionHandler{
		LOGGER.info("Start MenuItemController getMenuItem");
		LOGGER.info("End MenuItemController getMenuItem");
		return menuItemService.getMenuItem(id);
	}
	
	@PutMapping
	public void modifyMenuItem(@RequestBody MenuItem menuItem) {
		LOGGER.info("Start MenuItemController modifyMenuItem");
		menuItemService.modifyMenuItem(menuItem);
		LOGGER.info("End MenuItemController modifyMenuItem");
	}
}
	
