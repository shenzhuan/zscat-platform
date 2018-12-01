package com.zscat.common.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * 返回object信息bean定义
 * @author yang.liu
 *
 * @param <T>
 */
public class ResultInfoObject<T> extends ResultInfo implements Serializable{
	private static Logger log = LoggerFactory.getLogger(ResultInfoList.class);
	private static final long serialVersionUID = 3270955436491899764L;
	private T object = null;
	
	public ResultInfoObject() {
	}
	
	public ResultInfoObject(int retcode, String retdesc) {
		super(retcode, retdesc);
	}
	
	public ResultInfoObject(int retcode, String retdesc, T object) {
		super(retcode, retdesc);
		this.object = object;
	//	log.info("返回数据:"+JSON.toJSONString(object,false));
	}
	
	public T getObject() {
		return this.object;
	}
	
	public void setObject(T object) {
		this.object = object;
	//	log.info("返回数据:"+JSON.toJSONString(object,false));
	}
}
