package gkhts.payment;

import gkhts.payment.enums.ChargeTypeEnum;
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
}
