package top.by.xiceos.service;

import com.github.pagehelper.PageInfo;
import top.by.xiceos.api.ApiResponseData;
import top.by.xiceos.vo.Users;

/**
 * <p>Title: UsersService</p>
 * <p>Description: 用户操作</p>
 *
 * @author zwp
 * @date 2018/12/17 15:43
 */
public interface UsersService {

    ApiResponseData insert(Users users) throws RuntimeException;

    ApiResponseData delete(Long id);

    ApiResponseData update(Users users);

    ApiResponseData findById(Long id);

    ApiResponseData findByIds(Long[] ids);

    ApiResponseData findAll();

    ApiResponseData getPages(int pageNum, int pageSize);
}
