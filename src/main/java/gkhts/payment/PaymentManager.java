package gkhts.payment;

import gkhts.payment.enums.ChargeTypeEnum;
import gkhts.payment.enums.CurrencyEnum;
import gkhts.payment.exceptions.ConfigurationException;
import gkhts.payment.exceptions.PaymentTransactionException;
import gkhts.payment.model.PaymentResult;
import gkhts.payment.utils.StringUtils;

import com.est.jpay;

public class PaymentManager implements PaymentProvider {

	public static PaymentManager instance = null;

	String host;
	Integer port;
	String path;
	String username;
	String password;
	String clientId;
	ChargeTypeEnum type;
	String creditCardNumber;
	String expires;
	String total;
	String cvv2;
	CurrencyEnum currencyEnum;

	protected PaymentManager() {

	}

	private PaymentManager(String host, Integer port, String path) {
		this.host = host;
		this.port = port;
		this.path = path;

	}
	public static PaymentManager getInstance() {
		if (instance == null) {
			synchronized (PaymentManager.class) {
				if (instance == null) {
					instance = new PaymentManager();
				}
			}
		}
		return instance;
	}
	public static PaymentManager getInstance(String host, Integer port, String path) {
		if (instance == null) {
			synchronized (PaymentManager.class) {
				if (instance == null) {
					instance = new PaymentManager(host, port, path);
				}
			}
		}
		return instance;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getClientId() {
		return clientId;
	}

	@Override
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Override
	public ChargeTypeEnum getType() {
		return type;
	}

	@Override
	public void setType(ChargeTypeEnum type) {
		this.type = type;
	}

	@Override
	public PaymentResult processTransaction() throws PaymentTransactionException,ConfigurationException {
		PaymentResult paymentResult = new PaymentResult();

		if (StringUtils.isNullOrEmpty(clientId)) {
			throw new ConfigurationException("ClientId can not be null");
		} else if (StringUtils.isNullOrEmpty(port)) {
			throw new ConfigurationException("Port can not be null");
		} else if (StringUtils.isNullOrEmpty(path)) {
			throw new ConfigurationException("Path can not be null");
		} else if (StringUtils.isNullOrEmpty(username)) {
			throw new ConfigurationException("User name can not be null");
		} else if (StringUtils.isNullOrEmpty(password)) {
			throw new ConfigurationException("Password name can not be null");
		} else if (StringUtils.isNullOrEmpty(type.getName())) {
			throw new ConfigurationException("ChargeType name can not be null");
		}

		jpay jpy = new jpay();
		jpy.setName(username);
		jpy.setPassword(password);
		jpy.setClientId(clientId);
		jpy.setType(type.getName());
		jpy.setCurrency(currencyEnum.getName());
		jpy.setTotal(total);
		jpy.setCvv2Val(cvv2);
		jpy.setNumber(creditCardNumber);
		jpy.setExpires(expires);
		if (jpy.processTransaction(clientId, port, path) > 0) {

			paymentResult.setOrderId(jpy.getOrderId());
			paymentResult.setGroupId(jpy.getGroupId());
			paymentResult.setResponse(jpy.getResponse());
			paymentResult.setAuthCode(jpy.getAuthCode());
			paymentResult.setHostRefNum(jpy.getHostRefNum());
			paymentResult.setProcReturnCode(jpy.getProcReturnCode());
			paymentResult.setTransId(jpy.getTransId());
			paymentResult.setErrMsg(jpy.getErrMsg());

		} else {

			paymentResult.setOrderId(jpy.getOrderId());
			paymentResult.setGroupId(jpy.getGroupId());
			paymentResult.setResponse(jpy.getResponse());
			paymentResult.setAuthCode(jpy.getAuthCode());
			paymentResult.setHostRefNum(jpy.getHostRefNum());
			paymentResult.setProcReturnCode(jpy.getProcReturnCode());
			paymentResult.setTransId(jpy.getTransId());
			paymentResult.setErrMsg(jpy.getErrMsg());

			throw new PaymentTransactionException("Transaction Aborted.For detail see paymentresult object", paymentResult);

		}
		return paymentResult;
	}

	@Override
	public void setNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public String getNumber() {
		return this.creditCardNumber;
	}

	@Override
	public String getCvv2() {
		return this.cvv2;
	}

	@Override
	public void setCvv2(String cvv2) {
		this.cvv2 = cvv2;
	}

	@Override
	public String getExpires() {
		
		return this.expires;
	}

	@Override
	public void setExpires(String value) {
		this.expires = value;
	}

	@Override
	public String getTotal() {
		return this.total;
	}

	@Override
	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public CurrencyEnum getCurrency() {
		return this.currencyEnum;
	}

	@Override
	public void setCurrency(CurrencyEnum currencyEnum) {
		this.currencyEnum = currencyEnum;
	}

}
