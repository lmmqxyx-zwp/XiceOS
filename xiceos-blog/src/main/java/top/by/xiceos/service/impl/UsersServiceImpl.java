package top.by.xiceos.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import top.by.xiceos.dao.UsersDao;
import top.by.xiceos.service.UsersService;
import top.by.xiceos.vo.Users;

import java.util.List;

@Service(value = "usersService")
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    /**
     * 注意事务需要添加在实现类上面，@Service(value = "usersService")，在接口上面添加事务注解无效
     *
     * @param users
     * @return
     */
    @Transactional
    @Override
    public int addUsers(Users users) {

        int count = usersDao.insert(users);

        // 测试事务不提交
        System.out.println(10/0);

        return count;
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
