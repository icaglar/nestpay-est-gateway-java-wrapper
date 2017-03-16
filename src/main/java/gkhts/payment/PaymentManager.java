package gkhts.payment;

import gkhts.payment.enums.ChargeTypeEnum;
import gkhts.payment.enums.CurrencyEnum;
import gkhts.payment.enums.PaymentProviderTypeEnum;
import gkhts.payment.exceptions.ConfigurationException;
import gkhts.payment.exceptions.PaymentTransactionException;
import gkhts.payment.model.PaymentResult;
import gkhts.payment.model.ProviderConnectionConfigurer;

public class Test {

	private String name;
	private String password;
	private String clientId;

	public void testPayment() {

		try {
			PaymentProvider nestpayProvider = PaymentProviderFactory.getPaymentProvider(PaymentProviderTypeEnum.EST, new ProviderConnectionConfigurer("entegrasyon.asseco-see.com.tr", 443, "/fim/api"));
			nestpayProvider.setClientId(clientId);
			nestpayProvider.setUsername(name);
			nestpayProvider.setPassword(password);
			nestpayProvider.setType(ChargeTypeEnum.AUTH);
			nestpayProvider.setCurrency(CurrencyEnum.TL);
			nestpayProvider.setTotal("price");
			nestpayProvider.setCvv2("cvv or cvv2");
			nestpayProvider.setExpires("expire time mm/yy");
			nestpayProvider.setNumber("credit card number");
			PaymentResult paymentResult = nestpayProvider.processTransaction();
			String orderId = paymentResult.getOrderId();
			System.out.println(orderId);
			
			
		} catch (PaymentTransactionException e) {
			System.out.println(e.getResult().getErrMsg());
			System.out.println(e.getResult().getResponse());
			e.printStackTrace();
			
		} catch (ConfigurationException e) {
			
			e.printStackTrace();
			
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

}
