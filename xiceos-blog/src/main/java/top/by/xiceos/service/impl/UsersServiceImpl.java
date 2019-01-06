package top.by.xiceos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.by.xiceos.api.ApiResponseData;
import top.by.xiceos.dao.UsersDao;
import top.by.xiceos.service.UsersService;
import top.by.xiceos.vo.Users;

/**
 * <p>Title: UsersServiceImpl</p>
 * <p>Description: 注意事务需要添加在实现类上面，@Service(value = "usersService")，在接口上面添加事务注解无效</p>
 *
 * @author zwp
 * @date 2018/12/18 21:24
 */
@Service(value = "usersService")
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    //@Transactional
    @Override
    public ApiResponseData insert(Users users) throws RuntimeException {
        Object o = usersDao.insert(users);
        System.out.println(1/0);
        return ApiResponseData.ofSuccess(o);
        //https://blog.csdn.net/shunhua19881987/article/details/75311107
        //https://www.cnblogs.com/kerrycode/p/6999550.html
    }

    @Override
    public ApiResponseData delete(Long id) {
        return ApiResponseData.ofSuccess(usersDao.delete(id));
    }

    @Override
    public ApiResponseData update(Users users) {
        return ApiResponseData.ofSuccess(usersDao.update(users));
    }

    @Override
    public ApiResponseData findById(Long id) {
        return ApiResponseData.ofSuccess(usersDao.findById(id));
    }

    @Override
    public ApiResponseData findByIds(Long[] ids) {
        return ApiResponseData.ofSuccess(usersDao.findByIds(ids));
    }

    @Override
    public ApiResponseData findAll() {
        return ApiResponseData.ofSuccess(usersDao.findAll());
    }

    @Override
    public ApiResponseData getPages(int pageNum, int pageSize) {
        return ApiResponseData.ofSuccess(usersDao.findPages(pageNum, pageSize));
    }
}
