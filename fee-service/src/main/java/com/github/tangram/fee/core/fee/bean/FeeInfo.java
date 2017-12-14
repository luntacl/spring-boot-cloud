package com.github.tangram.fee.core.fee.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by liutao on 2017/10/17.
 */
@Data
public class FeeInfo {

    private String policyId;

    private String skuId;

    private Date startedTime;

    private String agencyId;

    private BigDecimal premium;

    private String jobId;

    private String orgId;

    private BigDecimal rate;

    private String feeStrategyDetailId;

    private String feeStrategyCollectType;
}
