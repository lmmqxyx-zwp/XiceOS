package top.by.xiceos.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import top.by.xiceos.dao.UsersDao;
import top.by.xiceos.service.UsersService;
import top.by.xiceos.vo.Users;

import java.util.List;

@Service(value = "usersService")
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public int addUsers(Users users) {
        return usersDao.insert(users);
    }

    /**
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     *
     * @param pageNum  开始页数
     * @param pageSize 每页显示的数据条数
     * @return
     */
    @Override
    public PageInfo<Users> findAllUsers(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Users> users = usersDao.selectUsers();
        PageInfo result = new PageInfo(users);
        return result;
    }

    @Override
    public Users findUsers(Users users) {
        return usersDao.selectUsers2(users);
    }
}