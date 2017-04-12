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
}
