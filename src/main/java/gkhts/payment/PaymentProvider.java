package gkhts.payment;

import gkhts.payment.enums.ChargeTypeEnum;
import gkhts.payment.enums.CurrencyEnum;
import gkhts.payment.exceptions.ConfigurationException;
import gkhts.payment.exceptions.PaymentTransactionException;
import gkhts.payment.model.PaymentResult;

public interface PaymentProvider {

	public  PaymentResult processTransaction() throws PaymentTransactionException,ConfigurationException;
	
	public String getClientId();
	
	public void setClientId(String clientId);
	
	public String getUsername();
	
	public void setUsername(String userName);

	public String getPassword();
	
	public void setPassword(String password);
	
	public  ChargeTypeEnum getType();
	
	public void setType(ChargeTypeEnum type);
	
	public void setNumber(String creditCardNumber);
	
	public String getNumber();
	
	public String getCvv2();
	
	public void setCvv2(String cvv2);
	
	public String getExpires();
	
	public void setExpires(String value);
	
	public String getTotal();
	
	public void setTotal(String total);
	
	public CurrencyEnum getCurrency();
	
	public void setCurrency(CurrencyEnum currencyEnum);
		
}
