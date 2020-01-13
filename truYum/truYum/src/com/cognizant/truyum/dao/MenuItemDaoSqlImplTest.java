package com.cognizant.truyum.dao;

import java.util.ArrayList;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {	
	public static void testgetMenuItemListAdmin() {	
	new MenuItemDaoSqlImpl().getMenuItemListAdmin();	
	ArrayList<MenuItem> menuItemList = new MenuItemDaoSqlImpl().getMenuItemListAdmin();				
	System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", "Id", "Name", "Price", "Active", "DateOfLaunch", "FreeDelivery", "Category");
	String active;
	String freeDelivery;
	for (MenuItem menuItem : menuItemList) {
		
		if(menuItem.getActive()== true) {
			active="Yes";
		}else { 
			active="No";
		}
		if(menuItem.getFreeDelivery()== true) {
			freeDelivery="Yes";
		}else { 
			freeDelivery="No";
		}

		System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", menuItem.getId(), menuItem.getName(),
				menuItem.getPrice(), active, menuItem.getDateOfLaunch(), freeDelivery, menuItem.getCategory());		
	}
}
	public static void testgetMenuItemListCustomer() {
	ArrayList<MenuItem> menuItemList = new MenuItemDaoSqlImpl().getMenuItemListCustomer();				
	System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", "Id", "Name", "Price", "Active", "DateOfLaunch", "FreeDelivery", "Category");
	String active;
	String freeDelivery;
	for (MenuItem menuItem : menuItemList) {
		
		if(menuItem.getActive()== true) {
			active="Yes";
		}else { 
			active="No";
		}
		if(menuItem.getFreeDelivery()== true) {
			freeDelivery="Yes";
		}else { 
			freeDelivery="No";
		}

		System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", menuItem.getId(), menuItem.getName(),
				menuItem.getPrice(), active, menuItem.getDateOfLaunch(), freeDelivery, menuItem.getCategory());
	}		
}
	
	public static void testModifyMenuItem() {
		MenuItem menuItem=new MenuItem(12L, "Maggi", 50.00f, true, new DateUtil().convertToDate("23/03/2022"),"Main Course", true);
		new MenuItemDaoSqlImpl().modifyMenuItem(menuItem);
		ArrayList<MenuItem> menuItemList = new MenuItemDaoSqlImpl().getMenuItemListAdmin();	
		System.out.println("AFTER MODIFICATION");
		System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", "Id", "Name", "Price", "Active", "DateOfLaunch", "FreeDelivery", "Category");
		String active;
		String freeDelivery;
		for (MenuItem menuItem1 : menuItemList) {
			
			if(menuItem1.getActive()== true) {
				
				active="Yes";
			}else { 
				active="No";
			}
			if(menuItem1.getFreeDelivery()== true) {
				freeDelivery="Yes";
			}else { 
				freeDelivery="No";
			}

			System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", menuItem1.getId(), menuItem1.getName(),
					menuItem1.getPrice(), active, menuItem1.getDateOfLaunch(), freeDelivery, menuItem1.getCategory());
		}			
		
	}
	
	public static void testgetMenuItem() {
		long menuItemId = 4;
		MenuItem menuItem = new MenuItemDaoSqlImpl().getMenuItem(menuItemId);	
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//DecimalFormat df= new DecimalFormat("##.00");
		//List<MenuItem> menuItemList = new MenuItemDaoSqlImpl().getMenuItemListAdmin();	
		String active;
		String freeDelivery;
		System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", "Id", "Name", "Price", "Active", "DateOfLaunch", "FreeDelivery", "Category");
		if(menuItem.getActive()== true) {
			
			active="Yes";
		}else { 
			active="No";
		}
		if(menuItem.getFreeDelivery()== true) {
			freeDelivery="Yes";
		}else { 
			freeDelivery="No";
		}

			System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", menuItem.getId(), menuItem.getName(),
			menuItem.getPrice(), active, menuItem.getDateOfLaunch(), freeDelivery, menuItem.getCategory());
		}	
				
	public static void main(String[] args) {
		testgetMenuItemListAdmin();	
		testgetMenuItemListCustomer();
		testModifyMenuItem();
		testgetMenuItem();
	}
	
}