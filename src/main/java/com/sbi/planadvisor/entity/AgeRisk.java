package com.sbi.planadvisor.entity;

import org.jongo.marshall.jackson.oid.MongoObjectId;

public class AgeRisk {
	 @MongoObjectId
	 private String id;
	 private int age;
	 private int riskScore;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
		
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getRiskScore() {
		return riskScore;
	}
	public void setRiskScore(int riskScore) {
		this.riskScore = riskScore;
	}
	
}
