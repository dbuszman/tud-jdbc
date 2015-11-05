package com.example.project_jdbc.dbmanager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.example.project_jdbc.dbtable.Magazyn;
import com.example.project_jdbc.dbtable.ToOrder;

public class ToOrderManagerTest {
	
	ToOrderManager toOrderManager = new ToOrderManager();
	
	private final static long IDMAGAZYN_1 = 0;
	private final static int ORDEREDAMOUNT_1 = 5;
	private final static float PRICE_1 = 500;

	@Test
	public void checkConnection(){
		assertNotNull(toOrderManager.getConnection());
	}
	
	@Test
	public void checkAdding() throws SQLException{
		
		ToOrder order = new ToOrder(IDMAGAZYN_1, ORDEREDAMOUNT_1, PRICE_1);
		
		toOrderManager.removeOrders();
		assertEquals(1,toOrderManager.addOrder(order));
		
		List<ToOrder> positions = toOrderManager.getAllOrders();
		ToOrder orderRetrieved = positions.get(0);
		
		assertEquals(IDMAGAZYN_1, orderRetrieved.getMagazynId());
		assertEquals(ORDEREDAMOUNT_1, orderRetrieved.getOrderedAmount());
		assertEquals(PRICE_1, orderRetrieved.getPrice(), 0.0f);
		
	}
	
	@Test
	public void checkRemovingOneElement() throws SQLException{
		
		ToOrder order = new ToOrder(IDMAGAZYN_1, ORDEREDAMOUNT_1, PRICE_1);
		
		toOrderManager.removeOrders();
		
		assertEquals(1,toOrderManager.addOrder(order));
		assertEquals(0,toOrderManager.removeOneOrder(order));
	}
	
	

}