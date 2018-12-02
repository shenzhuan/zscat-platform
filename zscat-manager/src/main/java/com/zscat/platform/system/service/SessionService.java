package com.zscat.platform.system.service;

import com.zscat.platform.system.domain.UserOnline;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SessionService {
	List<UserOnline> list();
}
