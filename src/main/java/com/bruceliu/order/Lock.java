package com.bruceliu.order;

// s#####lock接口 ######
public interface Lock {

	// 获取锁
	public void getLock();

	// 释放锁
	public void unLock();

}