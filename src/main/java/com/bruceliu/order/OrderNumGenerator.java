package com.bruceliu.order;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

//生成订单号
public class OrderNumGenerator {

	// 服务器的连接地址
	private static final String connectString = "122.51.50.249:2181";
	// 连接失效时间
	private static final int sessionTimeout = 50000; // 连接会话时间

	// 生成订单号
	public String getOrderNumber() {
		try {
			// 获取订单需要
			ZooKeeper client = new ZooKeeper(connectString, sessionTimeout, null); // 初始化连接对象
			byte[] data = client.getData("/data", false, new Stat());
			String str = new String(data);
			int count = Integer.parseInt(str);

			SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			count++; // 自增生成订单号
			Stat stat = client.setData("/data", (count + "").getBytes(), -1); // 把自增的序号返回去

			return smt.format(new Date()) + "-" + count;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
