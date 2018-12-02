package com.zscat.platform.common.service.impl;

import com.zscat.platform.common.dao.TaskDao;
import com.zscat.platform.common.domain.ScheduleJob;
import com.zscat.platform.common.domain.TaskDO;
import com.zscat.platform.common.service.JobService;
import com.zscat.platform.common.utils.ScheduleJobUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JobServiceImpl implements JobService {
	
	@Autowired
	private TaskDao taskScheduleJobMapper;


	@Override
	public TaskDO get(Long id) {
		return taskScheduleJobMapper.get(id);
	}

	@Override
	public List<TaskDO> list(Map<String, Object> map) {
		return taskScheduleJobMapper.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return taskScheduleJobMapper.count(map);
	}

	@Override
	public int save(TaskDO taskScheduleJob) {
		return taskScheduleJobMapper.save(taskScheduleJob);
	}

	@Override
	public int update(TaskDO taskScheduleJob) {
		return taskScheduleJobMapper.update(taskScheduleJob);
	}

	@Override
	public int remove(Long id) {
		return 0;
	}

	@Override
	public int batchRemove(Long[] ids) {
		return 0;
	}


}
