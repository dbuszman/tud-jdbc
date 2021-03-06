package com.example.project_jdbc.dbmanager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.example.project_jdbc.dbtable.Magazyn;

public class MagazynManagerTest {

	MagazynManager magazynManager = new MagazynManager();
	
	private final static String NAME_1 = "Intel i7 2,8Ghz 4gen";
	private final static int AMOUNT_1 = 5;
	private final static int MARGIN_1 = 10;
	
	private final static String NAME_2 = "Nvidia GF 950 GTX";
	private final static int AMOUNT_2 = 1;
	private final static int MARGIN_2 = 10;
	
	private final static String NAME_3 = "WD BLUE 500 GB";
	private final static int AMOUNT_3 = 2;
	private final static int MARGIN_3 = 11;
	
	private final static String NAME_4 = "TP Link WRL-8424ND";
	private final static int AMOUNT_4 = 1;
	private final static int MARGIN_4 = 5;
	
	private final static int DEFAULT_MARGIN = 15;
	private final static int MIN_AMOUNT = 2;

	@Test
	public void checkConnection(){
		assertNotNull(magazynManager.getConnection());
	}
	
	@Test
	public void checkAdding() throws SQLException{
		
		Magazyn position = new Magazyn(NAME_1, AMOUNT_1, MARGIN_1);
		
		magazynManager.removePositions();
		assertEquals(1,magazynManager.addPosition(position));
		
		List<Magazyn> positions = magazynManager.getAllPositions();
		Magazyn positionRetrieved = positions.get(0);
		
		assertEquals(NAME_1, positionRetrieved.getName());
		assertEquals(AMOUNT_1, positionRetrieved.getAmount());
		assertEquals(MARGIN_1, positionRetrieved.getMargin());
		
	}
	
	@Test
	public void checkRemovingOneElement() throws SQLException{
		
		Magazyn position = new Magazyn(NAME_1, AMOUNT_1, MARGIN_1);
		
		magazynManager.removePositions();
		
		assertEquals(1,magazynManager.addPosition(position));
		assertEquals(0,magazynManager.removeOnePosition(position));
	}
	
	@Test
	public void checkUpdating() throws SQLException{
		
		magazynManager.removePositions();
		
		Magazyn positionToUpdate = new Magazyn(NAME_2, AMOUNT_2, MARGIN_2);
		
		assertEquals(1,magazynManager.addPosition(positionToUpdate));
		
		magazynManager.updatePositions(DEFAULT_MARGIN, MIN_AMOUNT);
		
		List<Magazyn> positions = magazynManager.getAllPositions();
		Magazyn positionRetrieved = positions.get(0);
		
		assertTrue(positionRetrieved.getAmount()<MIN_AMOUNT);
		assertEquals(positionRetrieved.getMargin(), DEFAULT_MARGIN);		
	}
	
	@Test
	public void checkCountingRecords() throws SQLException{
		
		magazynManager.removePositions();
		
		Magazyn p1 = new Magazyn (NAME_1, AMOUNT_1, MARGIN_1);
		assertEquals(1,magazynManager.addPosition(p1));
		
		Magazyn p2 = new Magazyn (NAME_2, AMOUNT_2, MARGIN_2);
		assertEquals(1,magazynManager.addPosition(p2));
		
		Magazyn p3 = new Magazyn (NAME_3, AMOUNT_3, MARGIN_3);
		assertEquals(1,magazynManager.addPosition(p3));
		
		Magazyn p4 = new Magazyn (NAME_4, AMOUNT_4, MARGIN_4);
		assertEquals(1,magazynManager.addPosition(p4));
	
		assertEquals(4, magazynManager.getCount());
	}
	
}
