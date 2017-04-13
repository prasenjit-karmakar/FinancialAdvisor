package com.sbi.planadvisor.entity;

import org.jongo.marshall.jackson.oid.MongoObjectId;

public class AnnualIncomeRisk {
	 @MongoObjectId
	private String id;
	private long income;
	private int riskScore;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getIncome() {
		return income;
	}
	public void setIncome(long income) {
		this.income = income;
	}
	public int getRiskScore() {
		return riskScore;
	}
	public void setRiskScore(int riskScore) {
		this.riskScore = riskScore;
	}
}
