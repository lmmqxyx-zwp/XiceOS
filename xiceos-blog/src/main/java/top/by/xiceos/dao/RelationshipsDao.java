package top.by.xiceos.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import top.by.xiceos.vo.Relationships;

@Component
@Mapper
public interface RelationshipsDao extends BaseDao<Relationships> {
}
