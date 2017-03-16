# nestpay-est-gateway-java-wrapper
NestPay (EST) payment processing java wrapper

try {
			PaymentProvider nestpayProvider = PaymentProviderFactory.getPaymentProvider(PaymentProviderTypeEnum.EST, new ProviderConnectionConfigurer("entegrasyon.asseco-see.com.tr", 443, "/fim/api"));
			nestpayProvider.setClientId(clientId);
			nestpayProvider.setUsername(name);
			nestpayProvider.setPassword(password);
			nestpayProvider.setType(ChargeTypeEnum.AUTH);
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
