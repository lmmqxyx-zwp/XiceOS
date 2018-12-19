package top.by.xiceos.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import top.by.xiceos.vo.Users;

import java.util.List;

/**
 * <p>Title: UsersDao</p>
 * <p>Description: 用户操作</p>
 *
 * @author zwp
 * @date 2018/12/17 15:42
 */
@Component
@Mapper
public interface UsersDao extends BaseDao<Users> {

    int insert(Users users);

    @Select("select * from blog_users where uid = #{uid}")
    Users selectUsers2(Users users);

}
