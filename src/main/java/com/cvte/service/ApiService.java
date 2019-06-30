package com.cvte.service;

import com.cvte.po.Api;
import com.cvte.vo.DetailApiVo;
import com.cvte.vo.OutlineApiVo;

import java.util.List;

/**
 * @author pinnuli
 * @date 2019/6/25
 */
public interface ApiService {

    /**
     * @return 返回所有api信息
     */
    List<DetailApiVo> getDetailApiList();

    List<OutlineApiVo> getOutlineApiList();

    DetailApiVo getDetailApi(Integer apiId);

    void addApi(Api api);

    void updateApi(Api api);

    void deleteApi(Integer apiId);

}
