package top.by.xiceos.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import top.by.xiceos.vo.Metas;

@Component
@Mapper
public interface MetasDao extends BaseDao<Metas> {
}
