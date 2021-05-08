package com.bruceliu.order;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

public class Test {

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10; i++) {
			Thread.sleep(1000);
			new Thread(new OrderService()).start();
		}
	}
}
