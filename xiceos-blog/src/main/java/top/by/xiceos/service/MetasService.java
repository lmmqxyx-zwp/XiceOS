package top.by.xiceos.service;

import top.by.xiceos.api.ApiResponseData;
import top.by.xiceos.vo.Metas;

public interface MetasService {

    ApiResponseData insert(Metas metas);

    ApiResponseData delete(Long id);

    ApiResponseData update(Metas metas);

    ApiResponseData findById(Long id);

    ApiResponseData findByIds(Long[] ids);

    ApiResponseData findAll();

    ApiResponseData getPages(int pageNum, int pageSize);

    /**
     * 根据类型获取所有分类(由于分类和标签存储在同一张表中的原因导致不能直接获取全部数据)
     *
     * @param type 类型
     * @return 所有分类
     */
    ApiResponseData findByType(String type);
}
