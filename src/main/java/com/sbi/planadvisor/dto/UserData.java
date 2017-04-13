package com.sbi.planadvisor.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Techolution India Pvt Ltd
 */
public class UserData {
    private final int age;
    private final String gender;
    private final String location;
    private final String martialStatus;
    private final String annualIncome;
    private final int numberOfKids;
    
    
    @JsonCreator
    public UserData(@JsonProperty("age") int age, @JsonProperty("gender") String gender,@JsonProperty("location")  String location, 
    		@JsonProperty("martialStatus") String martialStatus, @JsonProperty("numberOfKids")  int numberOfKids,
    		@JsonProperty("annualIncome")  String annualIncome) {
		super();
		this.age = age;
		this.gender = gender;
		this.location = location;
		this.martialStatus = martialStatus;
		this.numberOfKids = numberOfKids;
		this.annualIncome = annualIncome;
	}


    public String getAnnualIncome() {
		return annualIncome;
	}


	public int getAge() {
        return age;
    }


	public String getGender() {
		return gender;
	}


	public String getLocation() {
		return location;
	}


	public String getMartialStatus() {
		return martialStatus;
	}


	public int getNumberOfKids() {
		return numberOfKids;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserData [age=").append(age).append(", gender=").append(gender).append(", location=")
				.append(location).append(", martialStatus=").append(martialStatus).append(", annualIncome=")
				.append(annualIncome).append(", numberOfKids=").append(numberOfKids).append("]");
		return builder.toString();
	}
    
}
