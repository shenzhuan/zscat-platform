package com.zscat.common.utils;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.apache.zookeeper.Watcher.Event.KeeperState;

import java.util.List;

/***
 * zk回调适配器类
 * @author zscat
 * @version 1.0
 */
public abstract class BaseZkCallableAdapter implements IZkDataListener,IZkChildListener,IZkStateListener {

	@Override
	public void handleNewSession() throws Exception {

	}

	@Override
	public void handleStateChanged(KeeperState arg0) throws Exception {

	}

	@Override
	public void handleChildChange(String arg0, List<String> arg1) throws Exception {

	}

	@Override
	public void handleDataChange(String arg0, Object arg1) throws Exception {

	}

	@Override
	public void handleDataDeleted(String arg0) throws Exception {

	}

}
