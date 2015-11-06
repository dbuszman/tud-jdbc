package com.example.project_jdbc.dbmanager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

//import com.example.project_jdbc.dbtable.Magazyn;
import com.example.project_jdbc.dbtable.ToOrder;

public class ToOrderManagerTest {
	
	ToOrderManager toOrderManager = new ToOrderManager();
	//MagazynManager magazynManager = new MagazynManager();
	
	
	private final static int ORDEREDAMOUNT_1 = 5;
	private final static float PRICE_1 = 500;
	
	/*private final static String NAME_1 = "Intel SSD";
	private final static int AMOUNT_1 = 5;
	private final static int MARGIN_1 = 10;

	Magazyn position = new Magazyn(NAME_1, AMOUNT_1, MARGIN_1);
	*/
	
	
	@Test
	public void checkConnection(){
		assertNotNull(toOrderManager.getConnection());
		
	}
	
	@Test
	public void checkAdding() throws SQLException{
	
	//	magazynManager.addPosition(position);
		
		ToOrder order = new ToOrder(ORDEREDAMOUNT_1, PRICE_1);
		
		toOrderManager.removeOrders();
		assertEquals(1,toOrderManager.addOrder(order));
		
		List<ToOrder> orders = toOrderManager.getAllOrders();
		ToOrder orderRetrieved = orders.get(0);
		
		assertEquals(ORDEREDAMOUNT_1, orderRetrieved.getOrderedAmount());
		assertEquals(PRICE_1, orderRetrieved.getPrice(), 0.0f);
		
	}
	
	@Test
	public void checkRemovingOneElement() throws SQLException{
		
		ToOrder order = new ToOrder(ORDEREDAMOUNT_1, PRICE_1);
		
		toOrderManager.removeOrders();
		
		assertEquals(1,toOrderManager.addOrder(order));
		assertEquals(0,toOrderManager.removeOneOrder(order));
	}
	
	

}