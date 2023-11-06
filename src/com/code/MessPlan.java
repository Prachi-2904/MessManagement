package com.code;

public enum MessPlan {

	 MONTHLY(3000), QUATERLY(11700), HALFYEAR(17500), YEARLY (32000);
	 private double charges;
	 
	private MessPlan(double charges) {
		this.charges=charges;
	}

	public double getCharges() {
		return charges;
	}
}
