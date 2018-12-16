package top.by.xiceos.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import top.by.xiceos.vo.Users;

import java.util.List;

@Component
@Mapper
public interface UsersDao {

    int insert(Users users);

    List<Users> selectUsers();

    @Select("select * from blog_users where uid = #{uid}")
    Users selectUsers2(Users users);

}
