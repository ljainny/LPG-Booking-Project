package com.capgemini.lpg.service;

import java.util.ArrayList;

import com.capgemini.lpg.dao.LPGDAO;
import com.capgemini.lpg.dao.LPGDAOImpl;
import com.capgemini.lpg.dto.LPGStock;
import com.capgemini.lpg.exception.LPGException;
/*
 *  LPGServiceImpl class dispatching calls to the Database layer (DAOImpl)
 */
public class LPGServiceImpl implements LPGService {
	LPGDAO lpgDAO;

	public LPGServiceImpl() {
		lpgDAO = new LPGDAOImpl();
	}

	@Override
	public ArrayList<LPGStock> getLPGStockDetails(String location) 
			throws LPGException {
		return lpgDAO.getLPGStockDetails(location);
	}

	@Override
	public int updateLPGStock(String updatedBy, int updatedQty)
			throws LPGException {
		return lpgDAO.updateLPGStock(updatedBy, updatedQty);
	}
}
