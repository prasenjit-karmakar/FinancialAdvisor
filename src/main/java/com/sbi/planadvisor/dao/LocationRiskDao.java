package com.sbi.planadvisor.dao;

import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.sbi.planadvisor.entity.LocationRisk;

@Repository
public class LocationRiskDao {

	 private final MongoCollection locationRisk;
	 
	 @Autowired
	    public LocationRiskDao(@Qualifier("locationRisk") MongoCollection locationRisk) {
	        this.locationRisk = locationRisk;
	    }
	 
	 public int getRiskScoreByLocation(String location) {
		 int riskScore = 0;
	        Iterable<LocationRisk> locationRiskList =  this.locationRisk.find("{ location : # }", location).as(LocationRisk.class);
	        if(locationRiskList != null) {
	        	for(LocationRisk obj : locationRiskList) {
	        		riskScore = obj.getRiskScore();
	        	}
	        }
	        return riskScore;
	    }
}
