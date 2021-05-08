package com.bruceliu.order;


import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

// #####ZookeeperAbstractLock抽象类接口 ######
//实现锁
public class ZookeeperDistrbuteLock extends ZookeeperAbstractLock {

	private CountDownLatch countDownLatch = new CountDownLatch(1);

	@Override
	protected boolean tryLock() {
		try {
			zkClient.createEphemeral(PATH);
			// 创建成功
			return true;
		} catch (Exception e) {
			// 创建失败
			return false;
		}
	}

	@Override
	protected void waitLock() {
		try {
			//监听Zk节点删除事件
			IZkDataListener iZkDataListener = new IZkDataListener() {
				public void handleDataDeleted(String path) throws Exception {
					// 唤醒等待线程， 继续往下走.
					if (countDownLatch != null) {
						countDownLatch.countDown();
						System.out.println("删除节点");
					}
				}
				public void handleDataChange(String path, Object data) throws Exception {

				}
			};
			// 注册到zk监听中
			zkClient.subscribeDataChanges(PATH, iZkDataListener);
			if (zkClient.exists(PATH)) {
				countDownLatch = new CountDownLatch(1);
				// 等待
				countDownLatch.await();
			}
			// 删除事件通知
			zkClient.unsubscribeDataChanges(PATH, iZkDataListener);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
