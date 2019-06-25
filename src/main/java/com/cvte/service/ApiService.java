package com.cvte.service;

import com.cvte.vo.ApiVo;

import java.util.List;

/**
 * @author pinnuli
 * @date 2019/6/25
 */
public interface ApiService {

    /**
     * @return 返回所有api信息
     */
    List<ApiVo> getAllApi();

}
