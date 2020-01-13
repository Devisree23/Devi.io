package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {
	public static final String GET_ALL_MENUITEM_ADMIN = "select * from menu_item";
	public static final String MODIFY_MENUITEM = "update menu_item set " + "me_name =?," + "me_active=?,"
			+ "me_date_of_launch=?," + "me_category=?," + "me_free_delivery  = ?," + "me_price = ? where me_id= ?";
	public static final String GET_ALL_CUSTOMER_ADMIN = "select * from menu_item where menu_item.me_active = 'Yes' and menu_item.me_date_of_launch >= curdate()";

	public ArrayList<MenuItem> getMenuItemListAdmin() {
		ArrayList<MenuItem> menuItemList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_MENUITEM_ADMIN);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("Yes"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("Yes"));
				menuItemList.add(menuItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}
		return menuItemList;
	}

	public ArrayList<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> menuItemList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_CUSTOMER_ADMIN);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("Yes"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("Yes"));
				menuItemList.add(menuItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}
		return menuItemList;
	}

	public void modifyMenuItem(MenuItem menuItem) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(MODIFY_MENUITEM);
			statement.setLong(7, menuItem.getId());
			statement.setString(1, menuItem.getName());
			statement.setFloat(6, menuItem.getPrice());
			statement.setString(2, menuItem.getActive()?"Yes":"No");
			statement.setDate(3, new java.sql.Date(menuItem.getDateOfLaunch().getTime()));
			statement.setString(4, menuItem.getCategory());
			statement.setString(5, menuItem.getFreeDelivery()?"Yes":"No");

			int noOfRows = statement.executeUpdate();
			if (noOfRows > 0) {
				return;
			}
		} catch (SQLException e) {
			System.out.println("Update not Done");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
			}
		}
		return;
	}

	public static final String GET_ALL_MENUITEM = "select * from menu_item where me_id=?";

	public MenuItem getMenuItem(long menuItemId) {		
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		MenuItem menuItem = null;
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_MENUITEM);
			preparedStatement.setLong(1,menuItemId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("Yes"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("Yes"));
				
			}

		} catch (SQLException e) {
			System.out.println("Id not Found");
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}

		return menuItem;
	}
}