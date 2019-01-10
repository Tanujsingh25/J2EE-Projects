package com.cg.payroll.util;

import java.util.HashMap;

import com.cg.payroll.beans.Associate;

public class PayrollUtil {
	
	private static int ASSOCIATE_ID_COUNTER=100;

	public static HashMap<Integer, Associate> associates = new HashMap<>();
	
	private static int ASSOCIATE_IDX=0;
	
	
	
	public static int getASSOCIATE_ID_COUNTER() {
		return ++ASSOCIATE_ID_COUNTER;
	}

	public static int getASSOCIATE_IDX() {
		return ASSOCIATE_IDX++;
	}
	
}
