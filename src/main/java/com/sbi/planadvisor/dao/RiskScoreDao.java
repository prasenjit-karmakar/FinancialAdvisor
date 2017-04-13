package com.sbi.planadvisor.dao;

import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sbi.planadvisor.dto.FundAdvice;
import com.sbi.planadvisor.entity.RiskScoreMetrics;

@Repository
public class RiskScoreDao {

	 private final MongoCollection finalRisk;

	    @Autowired
	    public RiskScoreDao(@Qualifier("finalRisk") MongoCollection finalRisk) {
	        this.finalRisk = finalRisk;
	    }

	    public FundAdvice getFundAdviceMetricsByRiskScore(int riskScore) {
	    	FundAdvice fundAdvice = null;
	        Iterable<RiskScoreMetrics> riskMetrics = this.finalRisk.find("{ $and : [ { minRiskScore : { $lte : # } } , { maxRiskScore : {  $gte : # } } ] }",riskScore,riskScore).as(RiskScoreMetrics.class);
	        if(riskMetrics != null) {
	        	for(RiskScoreMetrics obj : riskMetrics) {
	        		fundAdvice = new FundAdvice(obj.getContigencyFund(), obj.getRetirementFund());
	        	}
	        }
	        return fundAdvice;
	    }
}

