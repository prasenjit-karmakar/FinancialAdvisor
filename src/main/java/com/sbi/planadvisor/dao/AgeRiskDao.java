package com.sbi.planadvisor.dao;

import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sbi.planadvisor.entity.AgeRisk;

/**
 * @author Techolution India Pvt Ltd
 */
@Repository
public class AgeRiskDao {
    private final MongoCollection ageRisk;

    @Autowired
    public AgeRiskDao(@Qualifier("ageRisk") MongoCollection ageRisk) {
        this.ageRisk = ageRisk;
    }

    /*public AgeRisk save(AgeRisk ageRisk) {
    	ageRisk.save(ageRisk);
        return ageRisk;
    }
*/
    public int getRiskScoreByAge(int age) {
    	int riskScore = 0;
        Iterable<AgeRisk> ageRisks = this.ageRisk.find("{ age : # }", age).as(AgeRisk.class);
        if(ageRisks != null) {
        	for(AgeRisk obj : ageRisks) {
        		riskScore = obj.getRiskScore();
        	}
        }
        return riskScore;
    }
}
