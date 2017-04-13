package com.sbi.planadvisor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbi.planadvisor.dao.AgeRiskDao;
import com.sbi.planadvisor.dao.AnnualIncomeRiskDao;
import com.sbi.planadvisor.dao.LocationRiskDao;
import com.sbi.planadvisor.dao.MartialStatusRiskDao;
import com.sbi.planadvisor.dao.RiskScoreDao;
import com.sbi.planadvisor.dto.FundAdvice;
import com.sbi.planadvisor.dto.UserData;

/**
 * @author Techolution India Pvt Ltd
 */
@Service
public class FundAdviceService {
    private final AgeRiskDao ageRiskDao;
    private final LocationRiskDao locationRiskDao;
    private final MartialStatusRiskDao martialStatusRiskDao;
    private final AnnualIncomeRiskDao annualIncomeRiskDao;
    private final RiskScoreDao riskScoreDao;

    @Autowired
    public FundAdviceService(AgeRiskDao ageRiskDao,LocationRiskDao locationRiskDao,MartialStatusRiskDao martialStatusRiskDao,
    		AnnualIncomeRiskDao annualIncomeRiskDao, RiskScoreDao riskScoreDao) {
        this.ageRiskDao = ageRiskDao;
        this.locationRiskDao = locationRiskDao;
        this.martialStatusRiskDao = martialStatusRiskDao;
        this.annualIncomeRiskDao = annualIncomeRiskDao;
        this.riskScoreDao =  riskScoreDao;
    }

    public FundAdvice getFundAdviceByAge(UserData request){
    	int age = request.getAge();
    	String location = request.getLocation();
    	String martialStatus = request.getMartialStatus();
    	int numberOfKids = request.getNumberOfKids(); 
    	String annualIncome = request.getAnnualIncome();
        int ageRiskScore = ageRiskDao.getRiskScoreByAge(age);
        int locationRiskScore = locationRiskDao.getRiskScoreByLocation(location);
        int martialStatusRiskScore = martialStatusRiskDao.getRiskScoreByMartialStatus(martialStatus);
        int annualIncomeRiskScore = annualIncomeRiskDao.getRiskScoreByAnnualIncome(annualIncome);
        int count = 0;
        if(ageRiskScore != 0) {
        	++count;
        }
        if(locationRiskScore != 0) {
        	++count;
        }
        if(annualIncomeRiskScore != 0) {
        	++count;
        }
        int averageRiskScore = (ageRiskScore + locationRiskScore +annualIncomeRiskScore)/count;
        return riskScoreDao.getFundAdviceMetricsByRiskScore(averageRiskScore);
    }
}
