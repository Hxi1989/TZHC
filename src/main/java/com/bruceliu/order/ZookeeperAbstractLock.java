package com.bruceliu.order;


import org.I0Itec.zkclient.ZkClient;

// #####ZookeeperAbstractLock抽象类接口 ######
public abstract class ZookeeperAbstractLock implements Lock {

	private static final String CONNECT_ADDRES = "122.51.50.249:2181";

	protected ZkClient zkClient = new ZkClient(CONNECT_ADDRES);

	protected String PATH = "/lock";  //临时节点！！！

	public void getLock() {
		// 如果当前节点已经存在,则等待
		if (tryLock()) {
			System.out.println("获取到锁 get");
		} else {
			// 等待
			waitLock();
			// 重新获取锁
			getLock();
		}
	}

	protected abstract void waitLock();

	protected abstract boolean tryLock();

	public void unLock() {
		if (zkClient != null) {
			zkClient.close();
		}
		System.out.println("已经释放锁...");
	}
}