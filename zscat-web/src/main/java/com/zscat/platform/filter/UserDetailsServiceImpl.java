package com.zscat.platform.filter;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zscat.user.entity.TMemberDO;
import com.zscat.user.service.TMemberService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by echisan on 2018/6/23
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Reference(
            version = "${web.service.version}",
            application = "${dubbo.application.id}",
            registry = "${dubbo.registry.id}"
    )
    private TMemberService tMemberService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);

        TMemberDO user = tMemberService.selectOne(params);
        return new JwtUser(user);
    }

}
