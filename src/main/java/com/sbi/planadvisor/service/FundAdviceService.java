package com.sbi.planadvisor.service;

import com.sbi.planadvisor.dao.AgeFundMappingDao;
import com.sbi.planadvisor.dto.FundAdvice;
import com.sbi.planadvisor.entity.AgeFundMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Techolution India Pvt Ltd
 */
@Service
public class FundAdviceService {
    private final AgeFundMappingDao ageFundMappingDao;

    @Autowired
    public FundAdviceService(AgeFundMappingDao ageFundMappingDao) {
        this.ageFundMappingDao = ageFundMappingDao;
    }

    public FundAdvice getFundAdviceByAge(int age) {
        Iterable<AgeFundMapping> ageFundMappings = ageFundMappingDao.getByAge(age);
        List<AgeFundMapping> mappings = new ArrayList<>();
        for (AgeFundMapping mapping : ageFundMappings) {
            mappings.add(mapping);
        }
        if (!mappings.isEmpty()) {
            AgeFundMapping mapping = mappings.get(0);
            return new FundAdvice(mapping.getContigencyFund(), mapping.getRetirementFund());
        } else return null;
    }
}
