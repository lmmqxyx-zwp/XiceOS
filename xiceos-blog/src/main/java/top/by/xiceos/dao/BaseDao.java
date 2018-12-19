package top.by.xiceos.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>Title: BaseDao</p>
 * <p>Description: DAO父接口</p>
 *
 * @author zwp
 * @date 2018/12/18 15:27
 */
public interface BaseDao<T> {

    /**
     * 数据插入
     *
     * @param vo 对应数据实体
     * @return   返回改变的行数
     */
    int insert(T vo);

    /**
     * 数据删除
     *
     * @param id 行数据对应主键ID
     * @return   返回改变的行数
     */
    int delete(Long id);

    /**
     * 数据更新
     *
     * @param vo 对应数据实体
     * @return   返回改变的行数
     */
    int update(T vo);

    /**
     * 数据查询
     *
     * @param id 行数据对应主键ID
     * @return   返回查询得到的数据
     */
    T findById(Long id);

    /**
     * 数据查询
     *
     * @param ids 主键集合
     * @return    返回查询得到的数据集合
     */
    List<T> findByIds(Long[] ids);

    /**
     * 数据查询
     *
     * @return 返回所有的数据
     */
    List<T> findAll();

    /**
     * 默认的分页查询
     *
     * @param pageNum  开始页码
     * @param pageSize 每页显示的数据条数
     * @return 返回查询得到的分页数据
     */
    default PageInfo<T> findPages(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(findAll());

        return pageInfo;
    }
}
