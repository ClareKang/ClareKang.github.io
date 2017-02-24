package net.meshkorea.mcp.api.entity.common;

import net.meshkorea.mcp.api.entity.execption.DifferentCurrencyException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

/**
 * Created by jihunlee on 2016. 1. 17..
 */
@Embeddable
public class Money {

    @Column( name = "amount" )
    private BigDecimal amount;

    @Column( name = "currency" )
    private Currency currency;

    public Money() { }

    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Money)) {
            return false;
        }
        Money m = (Money)obj;
        // CAUTION: BigDecimals are equal only if they are equal in VALUE AND SCALE. So we are using compareTo() instead of equals()
        return currency.equals(m.getCurrency()) && amount.compareTo(m.getAmount()) == 0;
    }

    public Money negate() {
        return new Money(amount.negate(), currency);
    }

    public int compareTo(Money m) throws DifferentCurrencyException {
        if (!currency.equals(m.getCurrency())) {
            throw new DifferentCurrencyException(currency, m.currency);
        }

        return amount.compareTo(m.getAmount());
    }

    public Money add(Money operand) throws DifferentCurrencyException {
        if(!currency.equals(operand.currency)) {
            throw new DifferentCurrencyException(currency, operand.currency);
        }

        return new Money(amount.add(operand.amount), this.currency);
    }

	public Money subtract(Money operand) throws DifferentCurrencyException {
		if(!currency.equals(operand.currency)) {
			throw new DifferentCurrencyException(currency, operand.currency);
		}

		return new Money(amount.subtract(operand.amount), this.currency);
	}

	public Money multiply(BigDecimal mulplyFactor) throws DifferentCurrencyException {
		return new Money(amount.multiply(mulplyFactor), currency);
	}

    public Money multiply(double mulplyFactor) throws DifferentCurrencyException {
        return new Money(amount.multiply(new BigDecimal(mulplyFactor)), currency);
    }

    public Money setScale(int scale, RoundingMode roundingMode) {
        return new Money(amount.setScale(scale, roundingMode), currency);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency=" + currency +
                '}';
    }
}
