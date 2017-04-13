package com.sbi.planadvisor.entity;

import org.jongo.marshall.jackson.oid.MongoObjectId;

import java.math.BigDecimal;

/**
 * @author Techolution India Pvt Ltd
 */
public class AgeFundMapping {
    @MongoObjectId
    private String id;
    private int age;
    private String gender;
    private String location;
    private String martialStatus;
    private int numberOfKids;
    private BigDecimal contigencyFund;
    private BigDecimal retirementFund;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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
    
}
