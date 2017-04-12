package com.sbi.planadvisor.dao;

import com.sbi.planadvisor.entity.AgeFundMapping;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * @author Techolution India Pvt Ltd
 */
@Repository
public class AgeFundMappingDao {
    private final MongoCollection ageFundmappings;

    @Autowired
    public AgeFundMappingDao(@Qualifier("ageFundMapping") MongoCollection ageFundmappings) {
        this.ageFundmappings = ageFundmappings;
    }

    public AgeFundMapping save(AgeFundMapping ageFundMapping) {
        ageFundmappings.save(ageFundMapping);
        return ageFundMapping;
    }

    public Iterable<AgeFundMapping> getByAge(int age) {
        return this.ageFundmappings.find("{ age : # }", age).as(AgeFundMapping.class);
    }
}
