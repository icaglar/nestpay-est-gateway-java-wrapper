package gkhts.payment.exceptions;

import gkhts.payment.model.PaymentResult;

public class PaymentTransactionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PaymentResult result;
	
	public PaymentTransactionException() {

	}

	public PaymentTransactionException(Throwable cause) {
		super(cause);
	}

	public PaymentTransactionException(String message,PaymentResult paymentResult) {
		super(message, null);
		this.result = paymentResult;
	}

	public PaymentTransactionException(String message, Throwable cause) {
		super(message, cause);
	}

	public PaymentResult getResult() {
		return result;
	}

	public void setResult(PaymentResult result) {
		this.result = result;
	}

}
