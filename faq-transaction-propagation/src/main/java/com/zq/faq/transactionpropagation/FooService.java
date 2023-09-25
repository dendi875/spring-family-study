package com.zq.faq.transactionpropagation;

public interface FooService {

	void insertThenRollback() throws RollbackException;

	void invokeInsertThenRollback();
}
