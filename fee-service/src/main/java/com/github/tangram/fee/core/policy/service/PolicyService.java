package com.github.tangram.fee.core.policy.service;

import com.github.tangram.fee.core.policy.dao.PolicyMapper;
import com.github.tangram.fee.core.fee.bean.FeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liutao on 2017/10/17.
 */
@Service
public class PolicyService {

    @Autowired
    private PolicyMapper policyMapper;

    public FeeInfo getProviderFeeInfo(String policyId) {
        return policyMapper.getProviderFeeInfo(policyId);
    }

    public FeeInfo getTenantFeeInfo(String policyId) {
        return policyMapper.getTenantFeeInfo(policyId);
    }

    public FeeInfo getAgencyFeeInfo(String policyId) {
        return policyMapper.getAgencyFeeInfo(policyId);
    }
}
