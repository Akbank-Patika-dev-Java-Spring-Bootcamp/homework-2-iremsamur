package com.akbankbootcamp.ETradeBackend.customermessages;

import com.akbankbootcamp.ETradeBackend.general.BaseMessage;
import com.fasterxml.jackson.databind.ser.Serializers;

public enum CustomerMessages implements BaseMessage {

    CUSTOMER_NOT_FOUND("Customer not found!");
    private String message;

    CustomerMessages(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
