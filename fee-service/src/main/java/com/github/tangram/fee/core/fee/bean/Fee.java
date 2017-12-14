package com.github.tangram.fee.core.fee.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class Fee implements Serializable {
    private String feeId;

    private String orgUserJobId;

    private String feeStrategyDetailId;

    private String skuId;

    private String policyId;

    private BigDecimal premium;

    private String feeType;

    private BigDecimal feeMoney;

    private String feeStrategyCollectType;

    private BigDecimal rate;

    private Date earliestSettlementTime;

    private String remark;

    private String clientIp;

    private String handlerServer;

    private Date createdTime;

    private Date updatedTime;

    private String policyStatus;

    private static final long serialVersionUID = 1L;

}