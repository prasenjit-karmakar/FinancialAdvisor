package com.sbi.planadvisor.controller;

import com.sbi.planadvisor.dto.FundAdvice;
import com.sbi.planadvisor.dto.UserData;
import com.sbi.planadvisor.service.FundAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Techolution India Pvt Ltd
 */
@RestController
@RequestMapping("/api/v0/advice/")
public class AdviceController {
    private final FundAdviceService fundAdviceService;

    @Autowired
    public AdviceController(FundAdviceService fundAdviceService) {
        this.fundAdviceService = fundAdviceService;
    }

    @RequestMapping(value = "/fundvalue", method = RequestMethod.POST , consumes = "application/json")
    @ResponseBody
    public FundAdvice getFundValues(@Valid @RequestBody UserData request) {
        return fundAdviceService.getFundAdviceByAge(request);
    }
}
