package com.github.tangram.runtime.core.policy.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class Policy implements Serializable {
    private String policyId;

    private String productMetadataId;

    private String skuId;

    private String proposalId;

    private String tradeId;

    private BigDecimal premium;

    private BigDecimal amount;

    private Date acceptedTime;

    private Date startedTime;

    private Date endedTime;

    private String payType;

    private String policyType;

    private String channelId;

    private String openidType;

    private String openid;

    private String referId;

    private String agencyId;

    private String dealerId;

    private String distributorId;

    private String promoterId;

    private String coopProposalId;

    private String coopProposalIdSeq;

    private String handlerServer;

    private Date createdTime;

    private Date updatedTime;

    private String remark;

    private static final long serialVersionUID = 1L;

}