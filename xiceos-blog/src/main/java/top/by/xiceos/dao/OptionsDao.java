package top.by.xiceos.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import top.by.xiceos.vo.Options;

@Component
@Mapper
public interface OptionsDao extends BaseDao<Options> {
}
