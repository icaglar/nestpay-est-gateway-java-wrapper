# nestpay-est-gateway-java-wrapper
NestPay (EST) payment processing java wrapper
You should install jpay221.jar to m2 repo with maven as below

mvn install:install-file  -DgroupId=com.est.nestpay -DartifactId=jpay -Dpackaging=jar -Dversion=2.2.1 -Dfile=jpay221.jar -DgeneratePom=true



<br />
		
		try {
			PaymentProvider nestpayProvider = PaymentProviderFactory.getPaymentProvider(PaymentProviderTypeEnum.EST, new ProviderConnectionConfigurer("entegrasyon.asseco-see.com.tr", 443, "/fim/api"));
			nestpayProvider.setClientId(clientId);
			nestpayProvider.setUsername(name);
			nestpayProvider.setPassword(password);
			nestpayProvider.setType(ChargeTypeEnum.AUTH);
			PaymentResult paymentResult = nestpayProvider.processTransaction();
			String orderId = paymentResult.getOrderId();
			System.out.println(orderId);
			
			
		} catch (PaymentTransactionException e) {<br />
			System.out.println(e.getResult().getErrMsg());
			System.out.println(e.getResult().getResponse());
			e.printStackTrace();
			
		} catch (ConfigurationException e) {
			
			e.printStackTrace();
			
		}
