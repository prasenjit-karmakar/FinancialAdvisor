package com.sbi.planadvisor.dao;

import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sbi.planadvisor.entity.MartialStatusRisk;

@Repository
public class MartialStatusRiskDao {

 private final MongoCollection martialStatusRisk;
	 
	 @Autowired
	    public MartialStatusRiskDao(@Qualifier("martialStatusRisk") MongoCollection martialStatusRisk) {
	        this.martialStatusRisk = martialStatusRisk;
	    }
	 
	 public int getRiskScoreByMartialStatus(String martialStatus) {
		 int riskScore = 0;

	        Iterable<MartialStatusRisk> martialStatusRisks =  this.martialStatusRisk.find("{ martialStatus : # }", martialStatus).as(MartialStatusRisk.class);
	        if(martialStatusRisks != null) {
	        	for(MartialStatusRisk obj : martialStatusRisks) {
	        		riskScore = obj.getRiskScore();
	        	}
	        }
	        return riskScore;
	    }
}
