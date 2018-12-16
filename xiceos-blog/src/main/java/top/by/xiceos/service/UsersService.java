package top.by.xiceos.service;

import com.github.pagehelper.PageInfo;
import top.by.xiceos.vo.Users;

public interface UsersService {

    int addUsers(Users users);

    PageInfo<Users> findAllUsers(int pageNum, int pageSize);

    Users findUsers(Users users);
}
