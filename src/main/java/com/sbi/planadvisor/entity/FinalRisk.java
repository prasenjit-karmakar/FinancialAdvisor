package com.sbi.planadvisor.entity;

import java.math.BigDecimal;

import org.jongo.marshall.jackson.oid.MongoObjectId;

public class FinalRisk {

	 @MongoObjectId
	 private String id;
	 private int minRiskScore;
	 private int maxRiskScore;
	 private BigDecimal contigencyFund;
	 private BigDecimal retirementFund;
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public int getMinRiskScore() {
		return minRiskScore;
	}
	public void setMinRiskScore(int minRiskScore) {
		this.minRiskScore = minRiskScore;
	}
	public int getMaxRiskScore() {
		return maxRiskScore;
	}
	public void setMaxRiskScore(int maxRiskScore) {
		this.maxRiskScore = maxRiskScore;
	}
	public BigDecimal getContigencyFund() {
		return contigencyFund;
	}
	public void setContigencyFund(BigDecimal contigencyFund) {
		this.contigencyFund = contigencyFund;
	}
	public BigDecimal getRetirementFund() {
		return retirementFund;
	}
	public void setRetirementFund(BigDecimal retirementFund) {
		this.retirementFund = retirementFund;
	}
	 
	 
	 
}
