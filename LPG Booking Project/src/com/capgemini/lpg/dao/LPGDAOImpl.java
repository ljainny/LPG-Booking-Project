package com.capgemini.lpg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.capgemini.lpg.dto.LPGStock;
import com.capgemini.lpg.exception.LPGException;
import com.capgemini.lpg.util.DBUtil;

/*
 * DAO class for database interaction
 */
/**
 * 
 * @author Smita
 *
 */
public class LPGDAOImpl implements LPGDAO {
	Statement statement = null;
	ResultSet rsSet = null;
	PreparedStatement preparedStatement = null;

	@Override
	public ArrayList<LPGStock> getLPGStockDetails(String location) throws LPGException {

		Connection connection = DBUtil.obtainConnection();
		ArrayList<LPGStock> stockList = new ArrayList<LPGStock>();
		String sql = "SELECT AvQty,UpdatedBy FROM LPGStock where Location=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			//set the placeholder values
			preparedStatement.setString(1, location);
			//executeQuery
			rsSet = preparedStatement.executeQuery();
			LPGStock stock = null;
			while (rsSet.next()) {
				stock = new LPGStock();
				
				// setting value of stock
				stock.setAvQty(rsSet.getInt("AvQty"));
				stock.setUpdatedBy(rsSet.getString("UpdatedBy"));
				// adding to stocklist
				stockList.add(stock);
			}

		} catch (SQLException e) {
			//e.printStackTrace();
			throw new LPGException("Error while fetching LPGStock:::"
					+ e.getMessage());
		}
		return stockList;
	}

	public int updateLPGStock(String updatedBy, int updatedQty)
			throws LPGException {
		Connection connection = DBUtil.obtainConnection();
		int updateRows = 0;
		String updateSql = "UPDATE LPGStock SET AvQty=? WHERE UpdatedBy=?";
		try {
			preparedStatement = connection.prepareStatement(updateSql);
			//setting placeholder values
			preparedStatement.setInt(1, updatedQty);
			preparedStatement.setString(2, updatedBy);
			//executing ps
			updateRows = preparedStatement.executeUpdate();
			//System.out.println("update rows : "+updateRows);
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new LPGException("Error while Updating LPGStock Quatity:::"
					+ e.getMessage());
		}
		return updateRows;
	}
}
