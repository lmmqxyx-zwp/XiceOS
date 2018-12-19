package top.by.xiceos.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import top.by.xiceos.vo.Fields;

@Component
@Mapper
public interface FieldsDao extends BaseDao<Fields> {
}
