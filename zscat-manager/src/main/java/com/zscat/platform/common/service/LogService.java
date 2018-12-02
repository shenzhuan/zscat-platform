package com.zscat.platform.common.service;

import com.zscat.platform.common.domain.LogDO;
import com.zscat.platform.common.domain.PageDO;
import com.zscat.platform.common.utils.Query;
import org.springframework.stereotype.Service;

@Service
public interface LogService {
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
