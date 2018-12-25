package top.by.xiceos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.by.xiceos.api.ApiResponseData;
import top.by.xiceos.dao.MetasDao;
import top.by.xiceos.service.MetasService;
import top.by.xiceos.vo.Metas;

@Service(value = "metasService")
public class MetasServiceImpl implements MetasService {

    @Autowired
    private MetasDao metasDao;

    @Transactional
    @Override
    public ApiResponseData insert(Metas metas) {
        return ApiResponseData.ofSuccess(metasDao.insert(metas));
    }

    @Override
    public ApiResponseData delete(Long id) {
        return ApiResponseData.ofSuccess(metasDao.delete(id));
    }

    @Override
    public ApiResponseData update(Metas metas) {
        return ApiResponseData.ofSuccess(metasDao.update(metas));
    }

    @Override
    public ApiResponseData findById(Long id) {
        return ApiResponseData.ofSuccess(metasDao.findById(id));
    }

    @Override
    public ApiResponseData findByIds(Long[] ids) {
        return ApiResponseData.ofSuccess(metasDao.findByIds(ids));
    }

    @Override
    public ApiResponseData findAll() {
        return ApiResponseData.ofSuccess(metasDao.findAll());
    }

    @Override
    public ApiResponseData getPages(int pageNum, int pageSize) {
        return ApiResponseData.ofSuccess(metasDao.findPages(pageNum, pageSize));
    }

    @Override
    public ApiResponseData findByType(String type) {
        return ApiResponseData.ofSuccess(metasDao.findByType(type));
    }
}
