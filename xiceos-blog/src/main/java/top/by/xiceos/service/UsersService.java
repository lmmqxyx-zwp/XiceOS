package top.by.xiceos.service;

import com.github.pagehelper.PageInfo;
import top.by.xiceos.vo.Users;

/**
 * <p>Title: UsersService</p>
 * <p>Description: 用户操作</p>
 *
 * @author zwp
 * @date 2018/12/17 15:43
 */
public interface UsersService {

    int addUsers(Users users);

    PageInfo<Users> findAllUsers(int pageNum, int pageSize);

    Users findUsers(Users users);
}
