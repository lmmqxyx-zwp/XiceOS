package top.by.xiceos.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import top.by.xiceos.vo.Comments;

@Component
@Mapper
public interface CommentsDao extends BaseDao<Comments> {
}
