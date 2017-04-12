package com.sbi.planadvisor.dto;

import java.math.BigDecimal;

/**
 * @author Techolution India Pvt Ltd
 */
public class FundAdvice {
    private final BigDecimal contigencyFund;
    private final BigDecimal retirementFund;

    public FundAdvice(BigDecimal contigencyFund, BigDecimal retirementFund) {
        this.contigencyFund = contigencyFund;
        this.retirementFund = retirementFund;
    }

    public BigDecimal getContigencyFund() {
        return contigencyFund;
    }

    public BigDecimal getRetirementFund() {
        return retirementFund;
    }
}
