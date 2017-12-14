package com.github.tangram.fee.common.util.idUtil;

public class InvalidSystemClockException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6768831193089893149L;

	public InvalidSystemClockException(String message) {
        super(message);
    }
}
