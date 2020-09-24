package com.capgemini.lpg.service;

import java.util.ArrayList;

import com.capgemini.lpg.dto.LPGStock;
import com.capgemini.lpg.exception.LPGException;

/*
 * Service Interface , declaring method signatures to be implemented in Service Impl class
 */
/**
 * 
 * @author Smita
 *
 */
public interface LPGService {
	public ArrayList<LPGStock> getLPGStockDetails(String location) throws LPGException ;
	public int updateLPGStock(String updatedBy, int updatedQty)
			throws LPGException;
}
