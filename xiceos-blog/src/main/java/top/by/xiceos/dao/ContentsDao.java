package top.by.xiceos.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import top.by.xiceos.vo.Contents;

@Component
@Mapper
public interface ContentsDao extends BaseDao<Contents> {
}
