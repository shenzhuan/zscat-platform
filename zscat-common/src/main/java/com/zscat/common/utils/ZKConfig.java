package com.zscat.common.utils;

import org.I0Itec.zkclient.ZkClient;

import java.io.Serializable;

/**
 * zk配置
 * @author zscat
 * @version 1.0
 */
public class ZKConfig implements Serializable {
    static final long serialVersionUID = -1L;

    private String zkRoot = "/";

    /** 是否打开zk*/
    private boolean zkEnable = true;

    /** zk主机地址*/
    private String zkConnect;

    private int zkSessionTimeoutMs = 30000;

    private int zkConnectionTimeoutMs = 30000;

    private int zkSyncTimeMs = 5000;

    private ZkClient zkClient;

    public ZkClient getZkClient() {
		return zkClient;
	}

	public void setZkClient(ZkClient zkClient) {
		this.zkClient = zkClient;
	}

	public void init() {
		if (this.zkConnect != null) {
			this.zkClient = new ZkClient(this.zkConnect, this.zkSessionTimeoutMs, this.zkConnectionTimeoutMs, new ZkUtils.StringSerializer());
		}
	}

	public ZKConfig(final String zkConnect, final int zkSessionTimeoutMs, final int zkConnectionTimeoutMs,
            final int zkSyncTimeMs) {
        super();
        this.zkConnect = zkConnect;
        this.zkSessionTimeoutMs = zkSessionTimeoutMs;
        this.zkConnectionTimeoutMs = zkConnectionTimeoutMs;
        this.zkSyncTimeMs = zkSyncTimeMs;
    }

    public ZKConfig(final String zkRoot, final String zkConnect, final int zkSessionTimeoutMs,
            final int zkConnectionTimeoutMs, final int zkSyncTimeMs, final boolean zkEnable) {
        super();
        this.zkRoot = zkRoot;
        this.zkConnect = zkConnect;
        this.zkSessionTimeoutMs = zkSessionTimeoutMs;
        this.zkConnectionTimeoutMs = zkConnectionTimeoutMs;
        this.zkSyncTimeMs = zkSyncTimeMs;
        this.zkEnable = zkEnable;
    }

    public String getZkRoot() {
        return this.zkRoot;
    }

    public void setZkRoot(String zkRoot) {
        this.zkRoot = zkRoot;
    }

    public boolean isZkEnable() {
        return this.zkEnable;
    }

    public void setZkEnable(boolean zkEnable) {
        this.zkEnable = zkEnable;
    }

    public String getZkConnect() {
        return this.zkConnect;
    }

    public void setZkConnect(String zkConnect) {
        this.zkConnect = zkConnect;
    }

    public int getZkSessionTimeoutMs() {
        return this.zkSessionTimeoutMs;
    }

    public void setZkSessionTimeoutMs(int zkSessionTimeoutMs) {
        this.zkSessionTimeoutMs = zkSessionTimeoutMs;
    }

    public int getZkConnectionTimeoutMs() {
        return this.zkConnectionTimeoutMs;
    }

    public void setZkConnectionTimeoutMs(int zkConnectionTimeoutMs) {
        this.zkConnectionTimeoutMs = zkConnectionTimeoutMs;
    }

    public int getZkSyncTimeMs() {
        return this.zkSyncTimeMs;
    }

    public void setZkSyncTimeMs(int zkSyncTimeMs) {
        this.zkSyncTimeMs = zkSyncTimeMs;
    }

    public ZKConfig() {
        super();
        this.zkConnect = "127.0.0.1:2181";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (this.zkConnect == null ? 0 : this.zkConnect.hashCode());
        result = prime * result + this.zkConnectionTimeoutMs;
        result = prime * result + (this.zkEnable ? 1231 : 1237);
        result = prime * result + (this.zkRoot == null ? 0 : this.zkRoot.hashCode());
        result = prime * result + this.zkSessionTimeoutMs;
        result = prime * result + this.zkSyncTimeMs;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        ZKConfig other = (ZKConfig) obj;
        if (this.zkConnect == null) {
            if (other.zkConnect != null) {
                return false;
            }
        }
        else if (!this.zkConnect.equals(other.zkConnect)) {
            return false;
        }
        if (this.zkConnectionTimeoutMs != other.zkConnectionTimeoutMs) {
            return false;
        }
        if (this.zkEnable != other.zkEnable) {
            return false;
        }
        if (this.zkRoot == null) {
            if (other.zkRoot != null) {
                return false;
            }
        }
        else if (!this.zkRoot.equals(other.zkRoot)) {
            return false;
        }
        if (this.zkSessionTimeoutMs != other.zkSessionTimeoutMs) {
            return false;
        }
        if (this.zkSyncTimeMs != other.zkSyncTimeMs) {
            return false;
        }
        return true;
    }


}
