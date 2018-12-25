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

    ApiResponseData findByType(String type);
}
