# nestpay-est-gateway-java-wrapper
NestPay (EST) payment processing java wrapper

try { <br />
			PaymentProvider nestpayProvider = PaymentProviderFactory.getPaymentProvider(PaymentProviderTypeEnum.EST, new ProviderConnectionConfigurer("entegrasyon.asseco-see.com.tr", 443, "/fim/api"));<br />
			nestpayProvider.setClientId(clientId);<br />
			nestpayProvider.setUsername(name);<br />
			nestpayProvider.setPassword(password);<br />
			nestpayProvider.setType(ChargeTypeEnum.AUTH);<br />
			PaymentResult paymentResult = nestpayProvider.processTransaction();<br />
			String orderId = paymentResult.getOrderId();<br />
			System.out.println(orderId);<br />
			
			
		} catch (PaymentTransactionException e) {<br />
			System.out.println(e.getResult().getErrMsg());<br />
			System.out.println(e.getResult().getResponse());<br />
			e.printStackTrace();<br />
			
		} catch (ConfigurationException e) {<br />
			
			e.printStackTrace();<br />
			
		}<br />
