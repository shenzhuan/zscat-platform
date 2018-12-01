package com.zscat.common.utils;

import com.google.common.base.Charsets;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkMarshallingError;
import org.I0Itec.zkclient.exception.ZkNoNodeException;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;
import org.I0Itec.zkclient.serialize.ZkSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/***
 * ZkUtils
 * @author zscat
 * @version 1.0
 */

public class ZkUtils {

    private static Logger log = LoggerFactory.getLogger(ThreadPoolUtils.class);

	private static ZkClient zkClient = null;
    private static ZKConfig zkConfig = null;

    public static void setZkConfig(ZKConfig zkConfig) {
    	ZkUtils.zkConfig = zkConfig;
    }

    /**
     * 获取zkConfig
     * @return
     */
    public static ZKConfig getZkConfig() {
    	return zkConfig;
    }

    /**
     * 获取zkClient
     * @return
     */
    public static ZkClient getZkClient() {
    	if (zkClient == null) {
    		synchronized (ZkUtils.class){
    			if (zkClient == null) {
    				zkClient = new ZkClient(getZkConfig().getZkConnect(), getZkConfig().getZkSessionTimeoutMs(), getZkConfig().getZkConnectionTimeoutMs(), new ZkUtils.StringSerializer());
    			}
    		}
    	}
    	return zkClient;
    }

	/**
	 * 确保指定path的节点是存在的
	 * @param client
	 * @param path
	 * @return
	 */
    public static boolean makeSurePersistentPathExists( ZkClient client,  String path) {
        if (path == null || path.trim().length() < 1) {
            return false;
        }

        if (!client.exists(path)) {
            try {
                client.createPersistent(path, true);
                return true;
            } catch (ZkNodeExistsException e) {
                log.error("zkClient createPersistent ZkNodeExistsException", e);
            } catch (Exception e) {
                log.error("zkClient createPersistent error", e);
            }
            return false;

        }
        return true;
    }

    public static boolean makeSurePersistentPathExists(String path){
    	return makeSurePersistentPathExists(getZkClient(), path);
    }

    /**
     * 创建父节点
     * @param client zkClient实例
     * @param path 路径
     * @return
     */
    public static boolean createParentPath( ZkClient client,  String path) {
    	if (path == null || path.trim().length() < 1) {
    	    return false;
        }

        String parentDir = path.substring(0, path.lastIndexOf('/'));
        if (parentDir.length() != 0) {
            client.createPersistent(parentDir, true);
            return true;
        }
        return false;
    }

    public static boolean createParentPath(String path) {
    	return createParentPath(getZkClient(), path);
    }

    /**
     * 创建临时节点
     * @param client zkClient实例
     * @param path path
     * @param data data
     */
    public static void createEphemeralPath( ZkClient client,  String path,  String data) {
        if (path == null || path.trim().length() < 1) {
            return;
        }

        try {
            client.createEphemeral(path, data);
        } catch (ZkNoNodeException e) {
            log.info("ZkUtils createEphemeralPath error", e);
            createParentPath(client, path);
            client.createEphemeral(path, data);
        }
    }

    public static void createEphemeralPath(String path,  String data) {
    	createEphemeralPath(getZkClient(), path, data);
    }


    /**
     * 创建临时节点，如果存在则返回false
     * @param client
     * @param path
     * @param data
     * @return
     */
    public static boolean createEphemeralPathExpectConflict( ZkClient client,  String path,  String data) {
    	if (path == null || path.trim().length() < 1) {
    	    return false;
        }

        try {
            createEphemeralPath(client, path, data);
            return true;
        } catch ( ZkNodeExistsException e) {
            String storedData = null;
            try {
                storedData = readData(client, path);
            } catch (ZkNoNodeException e1) {
                log.info("ZkUtils createEphemeralPathExpectConflict--ZkNoNodeException error", e1);
            } catch (Exception e2) {
                log.error("ZkUtils createEphemeralPathExpectConflict error", e2);
            }

            if (storedData == null || !storedData.equals(data)) {
                log.info("ZkUtils createEphemeralPathExpectConflict is error ,because the path is exists ,the path's value is:" + storedData);
            } else {
                log.info(path + " exists with value " + data + " during connection loss; this is ok");
            }
        }
        catch ( Exception e) {
            log.error("ZkUtils createEphemeralPathExpectConflict error", e);
        }
        return false;

    }

    public static boolean createEphemeralPathExpectConflict(String path,  String data) {
    	return createEphemeralPathExpectConflict(getZkClient(), path, data);
    }

    /**
     * 订阅指定path节点数据变化事件
     * @param client zkClient
     * @param path path
     * @param zkCall 回调函数
     */
    public static void subscribeDataChanges( ZkClient client,  String path,  BaseZkCallableAdapter zkCall) {
    	client.subscribeDataChanges(path, zkCall);
    }

    public static void subscribeChildChanges( ZkClient client,  String path,  BaseZkCallableAdapter zkCall) {
    	client.subscribeChildChanges(path, zkCall);
    }

    public static void subscribeStateChanges( ZkClient client,  BaseZkCallableAdapter zkCall) {
    	client.subscribeStateChanges(zkCall);
    }

    /**
     * 更新指定path的持久节点值，如果path不存在则创建
     * @param client zkClient
     * @param path path
     * @param data data
     * @return
     */
    public static boolean updatePersistentPath( ZkClient client,  String path,  String data) {
        if (path == null || path.trim().length() < 1) {
            return false;
        }

        try {
            client.writeData(path, data);
        } catch (ZkNoNodeException e) {
            log.info("ZkUtils updatePersistentPath--ZkNoNodeException error", e);
            createParentPath(client, path);
            client.createPersistent(path, data);
        } catch (Exception e) {
            log.error("ZkUtils updatePersistentPath error", e);
            return false;
        }
        return true;
    }

    public static boolean updatePersistentPath(String path,  String data) {
    	return updatePersistentPath(getZkClient(), path, data);
    }

    /**
     * 读取指定path的值
     * @param client zkClient
     * @param path path
     * @return
     */
    public static String readData( ZkClient client,  String path) {
    	if (path == null || path.trim().length() < 1) {
    	    return "";
        }

        return client.readData(path);
    }
    public static String readDataMaybeNull( ZkClient client,  String path) {
    	if (path == null || path.trim().length() < 1) {
    	    return null;
        }

        return client.readData(path, true);
    }

    public static String readData(String path) {
    	return readData(getZkClient(), path);
    }
    public static String readDataMaybeNull(String path) {
    	return readDataMaybeNull(getZkClient(), path);
    }

    /**
     * 更新临时节点数据
     * @param client zkClient
     * @param path path
     * @param data
     * @return
     */
    public static boolean updateEphemeralPath( ZkClient client,  String path,  String data) {
        try {
            client.writeData(path, data);
        } catch (ZkNoNodeException e) {
            log.info("ZkUtils updateEphemeralPath--ZkNoNodeException error");
            createParentPath(client, path);
            client.createEphemeral(path, data);
        } catch (Exception e) {
            log.error("ZkUtils updateEphemeralPath error", e);
            return false;
        }
        return true;
    }

    /**
     * 删除指定path的节点
     * @param client
     * @param path
     * @return
     */
    public static boolean deletePath( ZkClient client,  String path) {
        try {
            client.delete(path);
        } catch (ZkNoNodeException e) {
            log.info(path + " delete during connection loss; this is ok");
        } catch (Exception e) {
            log.error("ZkUtils deletePath error", e);
            return false;
        }
        return true;
    }

    /**
     * 删除指定path的节点及子节点
     * @param client zkClient
     * @param path path
     * @return
     */
    public static boolean deletePathRecursive( ZkClient client,  String path) {
        try {
            client.deleteRecursive(path);
        } catch (ZkNoNodeException e) {
            log.info(path + " recursive delete during connection loss; this is ok");
        } catch (Exception e) {
            log.error("ZkUtils deletePathRecursive error", e);
            return false;
        }
        return true;
    }

    /**
     * 获取指定path的所有子节点
     * @param client zkClient
     * @param path path
     * @return
     */
    public static List<String> getChildrenMaybeNull( ZkClient client,  String path) {
        try {
            return client.getChildren(path);
        } catch (ZkNoNodeException e) {
            return null;
        }
    }

    public static List<String> getChildrenMaybeNull(String path) {
    	return getChildrenMaybeNull(getZkClient(), path);
    }

    /**
     * 检测path是否存在
     * @param client zkClient
     * @param path path
     * @return
     */
    public static boolean pathExists( ZkClient client,  String path) {
        return client.exists(path);
    }

    public static boolean pathExists(String path) {
    	return pathExists(getZkClient(), path);
    }

    /**
     * zk序列化-反序列化
     * @author zscat
     */
    public static class StringSerializer implements ZkSerializer {
        @Override
        public Object deserialize(byte[] bytes) throws ZkMarshallingError {
            return new String(bytes, Charsets.UTF_8);
        }

        @Override
        public byte[] serialize(Object data) throws ZkMarshallingError {
            return ((String) data).getBytes(Charsets.UTF_8);
        }
    }
}