package com.github.tangram.fee.core.policy.dao;


import com.github.tangram.fee.core.fee.bean.FeeInfo;
import com.github.tangram.fee.core.policy.bean.Policy;
import com.github.tangram.fee.core.policy.bean.PolicyWithBLOBs;

public interface PolicyMapper {
    int deleteByPrimaryKey(String policyId);

    int insert(PolicyWithBLOBs record);

    int insertSelective(PolicyWithBLOBs record);

    PolicyWithBLOBs selectByPrimaryKey(String policyId);

    int updateByPrimaryKeySelective(PolicyWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PolicyWithBLOBs record);

    int updateByPrimaryKey(Policy record);

    FeeInfo getProviderFeeInfo(String policyId);

    FeeInfo getTenantFeeInfo(String policyId);

    FeeInfo getAgencyFeeInfo(String policyId);
}