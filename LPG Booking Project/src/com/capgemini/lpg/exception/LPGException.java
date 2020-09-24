package com.capgemini.lpg.exception;

/*
 * User exception class to define custom exceptions wrapped around pre-defined exceptions like SQLException, Naming Exception
 */
/**
 * 
 * @author Smita
 *
 */
public class LPGException extends Exception {
	
	private static final long serialVersionUID = -4736365524152221785L;
	public LPGException(String message) {
		super(message);
	}
	public LPGException() {
		// TODO Auto-generated constructor stub
	}
}
