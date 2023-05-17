package com.akbankbootcamp.ETradeBackend.general;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

public class BusinessException extends RuntimeException{

    private final BaseErrorMessage baseErrorMessage;
    public BusinessException(BaseErrorMessage baseErrorMessage) {
        this.baseErrorMessage = baseErrorMessage;
    }

    public BaseErrorMessage getBaseErrorMessage() {
        return baseErrorMessage;
    }
}
