package com.github.tangram.fee.common.util.idUtil;

public class GetHardwareIdFailedException extends RuntimeException {

	private static final long serialVersionUID = 1294316891352259983L;

	GetHardwareIdFailedException(String reason) {
        super(reason);
    }

    GetHardwareIdFailedException(Exception e) {
        super(e);
    }
}