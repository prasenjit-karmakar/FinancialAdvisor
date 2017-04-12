package com.sbi.planadvisor.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author Techolution India Pvt Ltd
 */
public class UserData {
    private final int age;

    @JsonCreator
    public UserData(@JsonProperty("age") int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
