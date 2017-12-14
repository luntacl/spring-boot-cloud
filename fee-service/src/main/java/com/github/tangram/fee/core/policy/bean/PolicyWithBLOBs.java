package com.github.tangram.fee.core.policy.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class PolicyWithBLOBs extends Policy implements Serializable {
    private String policyContent;

    private String requestContent;

    private String responseContent;

    private static final long serialVersionUID = 1L;
}