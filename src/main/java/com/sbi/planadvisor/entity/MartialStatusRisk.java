package com.sbi.planadvisor.entity;

import org.jongo.marshall.jackson.oid.MongoObjectId;

public class MartialStatusRisk {
	 @MongoObjectId
	 private String id;
	 private String martialStatus;
	 private int numberOfKids;
	 private int riskScore;
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMartialStatus() {
		return martialStatus;
	}
	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}
	public int getNumberOfKids() {
		return numberOfKids;
	}
	public void setNumberOfKids(int numberOfKids) {
		this.numberOfKids = numberOfKids;
	}
	public int getRiskScore() {
		return riskScore;
	}
	public void setRiskScore(int riskScore) {
		this.riskScore = riskScore;
	}
}
