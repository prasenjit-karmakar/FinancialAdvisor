package com.sbi.planadvisor.exception;

/**
 * @author Techolution India Pvt Ltd
 */
public enum ErrorCodes {
    FA_INVALID_INPUT("Invalid user data");
    private String message;

    private ErrorCodes(String message) {
        this.message = message;
    }

}
