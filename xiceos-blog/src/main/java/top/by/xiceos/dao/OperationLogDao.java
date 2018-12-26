package top.by.xiceos.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import top.by.xiceos.vo.OperationLog;

@Component
@Mapper
public interface OperationLogDao extends BaseDao<OperationLog> {

}