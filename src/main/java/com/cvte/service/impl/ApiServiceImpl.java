package com.cvte.service.impl;

import com.cvte.po.Api;
import com.cvte.repository.ApiRepository;
import com.cvte.service.ApiService;
import com.cvte.vo.ApiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pinnuli
 * @date 2019/6/25
 */
@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private ApiRepository apiRepository;

    @Override
    public List<ApiVo> getAllApi() {
        List<ApiVo> apiVoList = new ArrayList<>();
        for (Api api : apiRepository.getAllApi()) {
            apiVoList.add(new ApiVo(api));
        }
        return apiVoList;
    }
}
