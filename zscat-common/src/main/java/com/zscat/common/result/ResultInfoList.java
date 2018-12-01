package com.zscat.common.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

/**
 * 返回信息bean定义
 * @author yang.liu
 *
 * @param <T>
 */
public class ResultInfoList<T> extends ResultInfo {
	
	private static final long serialVersionUID = 8907008595856407390L;
	private static Logger log = LoggerFactory.getLogger(ResultInfoList.class);
	private List<T> list = Collections.emptyList();
	
	public ResultInfoList() {
	}
	
	public ResultInfoList(int retcode, String retdesc) {
		super(retcode, retdesc);
	}
	
	public ResultInfoList(List<T> list) {
		this.list = list;
	//	log.info("返回数据:"+JSON.toJSONString(list,false));
	}
	
	public ResultInfoList(int retcode, String retdesc,List<T> list) {
		super(retcode, retdesc);
		this.list = list;
	//	log.info("返回数据:"+JSON.toJSONString(list,false));
	}
	
	public List<T> getList() {
		return this.list;
	}
	
	public void setList(List<T> list) {
		this.list = list;
	//	log.info("返回数据:"+JSON.toJSONString(list,false));
	}
}
