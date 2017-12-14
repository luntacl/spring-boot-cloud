package com.github.tangram.fee.common.util.idUtil;

public interface EntityIdGenerator {
    long generateLongId() throws InvalidSystemClockException, GetHardwareIdFailedException;

    String generateLongIdString() throws InvalidSystemClockException, GetHardwareIdFailedException;
}