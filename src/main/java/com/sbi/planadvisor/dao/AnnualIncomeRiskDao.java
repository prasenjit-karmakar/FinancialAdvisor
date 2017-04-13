package com.sbi.planadvisor.dao;

import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sbi.planadvisor.entity.AnnualIncomeRisk;
import com.sbi.planadvisor.entity.LocationRisk;

@Repository
public class AnnualIncomeRiskDao {
	private final MongoCollection annualIncomeRisk;
	 
	 @Autowired
	    public AnnualIncomeRiskDao(@Qualifier("annualIncomeRisk") MongoCollection annualIncomeRisk) {
	        this.annualIncomeRisk = annualIncomeRisk;
	    }
	 
	 public int getRiskScoreByAnnualIncome(String annualIncome) {
		 int riskScore = 0;
	        Iterable<AnnualIncomeRisk> annualIncomeRisks =  this.annualIncomeRisk.find("{ annualIncome : # }", annualIncome).as(AnnualIncomeRisk.class);
	        if(annualIncomeRisks != null) {
	        	for(AnnualIncomeRisk obj : annualIncomeRisks) {
	        		riskScore = obj.getRiskScore();
	        	}
	        }
	        return riskScore;
	    }
}
