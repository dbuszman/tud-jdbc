package com.example.project_jdbc.dbmanager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.example.project_jdbc.dbtable.Magazyn;

public class MagazynManagerTest {

	MagazynManager magazynManager = new MagazynManager();
	
	private final static String NAME_1 = "Intel i7 2,8Ghz 4gen";
	private final static int AMOUNT_1 = 5;
	private final static int MARGIN_1 = 10;

	@Test
	public void checkConnection(){
		assertNotNull(magazynManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Magazyn position = new Magazyn(NAME_1, AMOUNT_1, MARGIN_1);
		
		magazynManager.removePositions();
		assertEquals(1,magazynManager.addPosition(position));
		
		List<Magazyn> positions = magazynManager.getAllPositions();
		Magazyn positionRetrieved = positions.get(0);
		
		assertEquals(NAME_1, positionRetrieved.getName());
		assertEquals(AMOUNT_1, positionRetrieved.getAmount());
		assertEquals(MARGIN_1, positionRetrieved.getMargin());
		
	}
}
