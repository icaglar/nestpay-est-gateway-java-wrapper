package gkhts.payment;

import gkhts.payment.enums.PaymentProviderTypeEnum;
import gkhts.payment.model.ProviderConnectionConfigurer;

public class PaymentProviderFactory {

	public static PaymentProvider getPaymentProvider(PaymentProviderTypeEnum paymentProviderType,ProviderConnectionConfigurer providerConfigurer ) {
		
		if(paymentProviderType == PaymentProviderTypeEnum.EST){
			PaymentManager instance = PaymentManager.getInstance(providerConfigurer.getHost(), providerConfigurer.getPort(), providerConfigurer.getPath());
			
			return instance;
		}
		return null;
		
	
		
	}
	
	
}
