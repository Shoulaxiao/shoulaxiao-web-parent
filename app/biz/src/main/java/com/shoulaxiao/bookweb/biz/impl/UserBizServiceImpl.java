package com.shoulaxiao.bookweb.biz.impl;

import com.shoulaxiao.bookweb.biz.UserBizService;
import com.shoulaxiao.bookweb.dal.mp.entity.User;
import com.shoulaxiao.bookweb.dal.mp.mapper.UserMapper;
import com.shoulaxiao.bookweb.dal.mp.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserBizServiceImpl implements UserBizService {

    @Resource
    private UserMapper userMapper;

//    @Transactional(value = "transactionManager",rollbackFor = Exception.class)
    @Override
    public void testTransaction() {
        insert(20,"shoulaxiao1","@165342");
        testTransaction2();
    }


    public void testTransaction2(){
        insert(22,"shoulaxiao2","@16534");
    }

    private void insert(int age,String name,String email){
        User user = new User();
        user.setAge(age);
        user.setName(name);
        user.setEmail(email);

        boolean flag = userMapper.insert(user)>0;
        if (flag){
            log.info("插入数据成功:{}",flag);
        }else {
            log.error("插入数据失败:{}",flag);
        }
    }
}
