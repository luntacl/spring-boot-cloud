package com.github.tangram.fee.controller;

import com.github.tangram.fee.common.rest.Response;
import com.github.tangram.fee.core.fee.service.FeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by liutao on 2017/10/17.
 */
@RestController
@RequestMapping("feeInfo/generation")
public class FeeController {

    @Autowired
    FeeService feeService;

    @PostMapping("{instance}")
    public String generateFee(@PathVariable("instance")String feeInstance,
                              @RequestParam(value = "policyId")String policyId) {
        if (StringUtils.isBlank(feeInstance)) {
            return null;
        }
        int result = feeService.generateFeeInfo(feeInstance,policyId);
        if (result > 0) {
            return Response.successBuilder().BuildString();
        }
        return Response.failureBuilder().BuildString();
    }
}
