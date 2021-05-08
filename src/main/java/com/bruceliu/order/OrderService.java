package com.bruceliu.order;

//#####订单业务逻辑######
public class OrderService implements Runnable {

	private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();

	//自己实现了锁的机制
	private Lock lock = new ZookeeperDistrbuteLock();

	public void run() {
		getNumber();
	}

	public void getNumber() {
		lock.getLock();//枷锁
		String orderNumber = orderNumGenerator.getOrderNumber();
		System.err.println("获取订单号:" + orderNumber);
		lock.unLock();//释放锁锁
	}

}