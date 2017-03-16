package gkhts.payment;

import gkhts.payment.enums.ChargeTypeEnum;
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

	protected PaymentManager() {

	}

	private PaymentManager(String host, Integer port, String path) {
		this.host = host;
		this.port = port;
		this.path = path;

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

}
