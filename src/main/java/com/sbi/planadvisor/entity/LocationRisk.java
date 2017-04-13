package com.sbi.planadvisor.entity;

import org.jongo.marshall.jackson.oid.MongoObjectId;

public class LocationRisk {

	 @MongoObjectId
	private String id;
	private String location;
	private int riskScore;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getRiskScore() {
		return riskScore;
	}
	public void setRiskScore(int riskScore) {
		this.riskScore = riskScore;
	}
	
	
}
