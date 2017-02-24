package net.meshkorea.mcp.api.entity.execption;

import java.util.Currency;

/**
 * Created by jihunlee on 2016. 2. 23..
 */
public class DifferentCurrencyException extends RuntimeException {
    private final Currency currency1;
    private final Currency currency2;

    public DifferentCurrencyException(Currency currency1, Currency currency2) {
        super();
        this.currency1 = currency1;
        this.currency2 = currency2;
    }

    public DifferentCurrencyException(String message, Currency currency1, Currency currency2) {
        super(message);
        this.currency1 = currency1;
        this.currency2 = currency2;
    }
}
