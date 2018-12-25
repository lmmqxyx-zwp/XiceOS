package top.by.xiceos.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import top.by.xiceos.vo.Metas;

import java.util.List;

@Component
@Mapper
public interface MetasDao extends BaseDao<Metas> {

    @Select("select `mid`, `name`, `slug`, `type`, `description`, `count`, `order`, `parent` from blog_metas where type = #{type}")
    List<Metas> findByType(@Param("type") String type);
}
