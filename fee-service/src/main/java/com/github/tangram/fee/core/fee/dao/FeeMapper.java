package com.github.tangram.fee.core.fee.dao;


import com.github.tangram.fee.core.fee.bean.Fee;

public interface FeeMapper {
    int deleteByPrimaryKey(String feeId);

    int insert(Fee record);

    int insertSelective(Fee record);

    Fee selectByPrimaryKey(String feeId);

    int updateByPrimaryKeySelective(Fee record);

    int updateByPrimaryKey(Fee record);
}