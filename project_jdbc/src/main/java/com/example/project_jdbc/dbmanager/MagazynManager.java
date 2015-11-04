package com.example.project_jdbc.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.project_jdbc.dbtable.Magazyn;

public class MagazynManager {

	private Connection connection;
	
	private String url = "jdbc:hsqldb:hsql://localhost/workdb";
	
	private String createTableMagazyn = "CREATE TABLE Magazyn(id_position BIGINT UNIQUE GENERATED BY DEFAULT AS IDENTITY, name VARCHAR(30), amount INTEGER, margin INTEGER)";

	private PreparedStatement addPositionStmt;
	private PreparedStatement deleteAllPositionsStmt;
	private PreparedStatement getAllPositionsStmt;
	private PreparedStatement updatePositionsStmt;

	private Statement statement;

	public MagazynManager() {
		try {
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();

			ResultSet rs = connection.getMetaData().getTables(null, null, null,
					null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("Magazyn".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}

			if (!tableExists)
				statement.executeUpdate(createTableMagazyn);

			addPositionStmt = connection
					.prepareStatement("INSERT INTO Magazyn (name, amount, margin) VALUES (?, ?, ?)");
			updatePositionsStmt = connection
					.prepareStatement("UPDATE Magazyn SET margin=15 WHERE amount < 2");
			deleteAllPositionsStmt = connection
					.prepareStatement("DELETE FROM Magazyn");
			getAllPositionsStmt = connection
					.prepareStatement("SELECT id_position, name, amount, margin FROM Magazyn");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	Connection getConnection() {
		return connection;
	}

	
	
	void removePositions() {
		try {
			deleteAllPositionsStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void updatePositions() {
		try {
			updatePositionsStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int addPosition(Magazyn position) {
		int count = 0;
		try {
			addPositionStmt.setString(1, position.getName());
			addPositionStmt.setInt(2, position.getAmount());
			addPositionStmt.setInt(3, position.getMargin());

			count = addPositionStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public List<Magazyn> getAllPositions() {
		List<Magazyn> positions = new ArrayList<Magazyn>();

		try {
			ResultSet rs = getAllPositionsStmt.executeQuery();

			while (rs.next()) {
				Magazyn m = new Magazyn();
				m.setId(rs.getInt("id_position"));
				m.setName(rs.getString("name"));
				m.setAmount(rs.getInt("amount"));
				m.setMargin(rs.getInt("margin"));
				positions.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return positions;
	}
	
}

