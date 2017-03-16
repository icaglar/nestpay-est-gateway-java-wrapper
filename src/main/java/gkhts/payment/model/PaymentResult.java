package gkhts.payment.model;

public class PaymentResult {

	private String orderId;
	private String groupId;
	private String response;
	private String authCode;
	private String hostRefNum;
	private String procReturnCode;
	private String transId;
	private String errMsg;
	private String extra;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getHostRefNum() {
		return hostRefNum;
	}

	public void setHostRefNum(String hostRefNum) {
		this.hostRefNum = hostRefNum;
	}

	public String getProcReturnCode() {
		return procReturnCode;
	}

	public void setProcReturnCode(String procReturnCode) {
		this.procReturnCode = procReturnCode;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}
}
