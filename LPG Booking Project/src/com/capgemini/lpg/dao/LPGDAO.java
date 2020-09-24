package com.capgemini.lpg.dao;

import java.util.ArrayList;

import com.capgemini.lpg.dto.LPGStock;
import com.capgemini.lpg.exception.LPGException;

/*
 * DAO Interface , declaring method signatures to be implemented in DAO Impl class
 */
/**
 * 
 * @author Smita
 *
 */
public interface LPGDAO {
	public ArrayList<LPGStock> getLPGStockDetails(String location) throws LPGException;
	public int updateLPGStock(String updatedBy, int updatedQty)
			throws LPGException;
}
