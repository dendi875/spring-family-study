package com.zq.springdeclarativetransaction;

public interface FooService {

	void insertRecord();

	void insertThenRollback() throws RollbackException;

	void invokeInsertThenRollback() throws RollbackException;
}
