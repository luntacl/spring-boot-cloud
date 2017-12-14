package com.github.tangram.fee.core.fee.service;

import com.github.tangram.fee.common.util.idUtil.BasicEntityIdGenerator;
import com.github.tangram.fee.core.fee.bean.Fee;
import com.github.tangram.fee.core.fee.bean.FeeInfo;
import com.github.tangram.fee.core.fee.dao.FeeMapper;
import com.github.tangram.fee.core.policy.service.PolicyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by liutao on 2017/10/17.
 */
@Service
public class FeeService {
    @Autowired
    PolicyService policyService;
    @Autowired
    FeeMapper feeMapper;

    public int generateFeeInfo(String instance, String policyId) {
        FeeInfo feeInfo = null;
        if (instance.equals("provide")) {
            feeInfo = policyService.getProviderFeeInfo(policyId);
        } else if (instance.equals("tenant")) {
            feeInfo = policyService.getTenantFeeInfo(policyId);
        } else if (instance.equals("agency")) {
            feeInfo = policyService.getAgencyFeeInfo(policyId);
        }
        if (feeInfo == null) {
            return -1;
        }
        return this.saveFee(feeInfo);
    }

    public int saveFee(FeeInfo feeInfo) {
        Fee fee = new Fee();
        String feeId = BasicEntityIdGenerator.getInstance().generateLongIdString();
        fee.setFeeId(feeId);
        fee.setPolicyId(feeInfo.getPolicyId());
        fee.setPremium(feeInfo.getPremium());
        fee.setSkuId(feeInfo.getSkuId());
        fee.setEarliestSettlementTime(feeInfo.getStartedTime());
        fee.setFeeStrategyCollectType(feeInfo.getFeeStrategyCollectType());
        fee.setFeeStrategyDetailId(feeInfo.getFeeStrategyDetailId());
        if (StringUtils.isNotBlank(feeInfo.getAgencyId())) {
            fee.setOrgUserJobId(feeInfo.getAgencyId());
        } else {
            fee.setOrgUserJobId(feeInfo.getJobId());
        }
        BigDecimal premium = feeInfo.getPremium();
        BigDecimal rate = feeInfo.getRate();
        BigDecimal feeMoney = premium.multiply(rate).divide(new BigDecimal(100));
        fee.setFeeMoney(feeMoney);
        fee.setRate(rate);
        fee.setClientIp("127.0.0.1");
        fee.setHandlerServer("127.0.0.1");
        return feeMapper.insertSelective(fee);
    }
}
