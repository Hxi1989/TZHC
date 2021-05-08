package com.hxscpro.test;

import com.hxscpro.util.BaseZookeeper;
import org.apache.zookeeper.KeeperException;
import org.junit.Before;
import org.junit.Test;

/**
 * @author hx
 * @version 1.0
 * @date 2021/2/26 14:39
 */
public class TestZookeeper {
    BaseZookeeper baseZookeeper;

    @Before
    public void init(){
        try {
            baseZookeeper=new BaseZookeeper();
            baseZookeeper.connectZookeeper("127.0.0.1:2181");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    @Test
    public void testCreateNode(){
        try {
            baseZookeeper.createNode("/testNode","test Data!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    @Test
    public void testGetData(){
        try {
            String data = baseZookeeper.getData("/testNode");
            System.out.println(data);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }

}
