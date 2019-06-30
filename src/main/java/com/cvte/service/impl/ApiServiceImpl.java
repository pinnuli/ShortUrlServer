package com.cvte.service.impl;

import com.cvte.dao.ApiMapper;
import com.cvte.po.Api;
import com.cvte.po.ApiRequestExample;
import com.cvte.po.ApiRequestParameter;
import com.cvte.po.ApiResponseParameter;
import com.cvte.service.ApiService;
import com.cvte.vo.DetailApiVo;
import com.cvte.vo.OutlineApiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pinnuli
 * @date 2019/6/25
 */
@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private ApiMapper apiMapper;

    @Override
    public List<DetailApiVo> getDetailApiList() {
        List<DetailApiVo> detailApiVoList = new ArrayList<>();
        for (Api api : apiMapper.selectDetailApiList()) {
            detailApiVoList.add(new DetailApiVo(api));
        }
        return detailApiVoList;
    }

    @Override
    public List<OutlineApiVo> getOutlineApiList() {
        List<OutlineApiVo> outlineApiVoList = new ArrayList<>();
        for (Api api : apiMapper.selectOutlineApiList()) {
            outlineApiVoList.add(new OutlineApiVo(api));
        }
        return outlineApiVoList;
    }

    @Override
    public DetailApiVo getDetailApi(Integer apiId) {
        return new DetailApiVo(apiMapper.selectDetailApi(apiId));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addApi(Api api) {
        apiMapper.insertApi(api);
        generateRequestParameter(api);
        generateApiId(api);
        apiMapper.insertOrUpdateRequestExample(api.getRequestExampleList());
        apiMapper.insertOrUpdateRequestParameter(api.getRequestParameterList());
        apiMapper.insertOrUpdateResponseParameter(api.getResponseParameterList());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateApi(Api api) {
        apiMapper.updateApi(api);
        generateRequestParameter(api);
        generateApiId(api);
        apiMapper.insertOrUpdateRequestExample(api.getRequestExampleList());
        apiMapper.insertOrUpdateRequestParameter(api.getRequestParameterList());
        apiMapper.insertOrUpdateResponseParameter(api.getResponseParameterList());
    }

    @Override
    public void deleteApi(Integer apiId) {
        apiMapper.deleteApi(apiId);
    }

    private void generateApiId(Api api) {
        Integer apiId = api.getApiId();
        for (ApiRequestExample apiRequestExample : api.getRequestExampleList()) {
            apiRequestExample.setApiId(apiId);
        }
        for (ApiRequestParameter apiRequestParameter : api.getRequestParameterList()) {
            apiRequestParameter.setApiId(apiId);
        }
        for (ApiResponseParameter apiResponseParameter : api.getResponseParameterList()) {
            apiResponseParameter.setApiId(apiId);
        }
    }

    private void generateRequestParameter(Api api) {
        api.setRequestParameterList(new ArrayList<ApiRequestParameter>());
        List<ApiRequestParameter> apiRequestParameterList = api.getRequestParameterList();
        for (ApiRequestParameter apiRequestParameter : api.getRequestHeaderParameterList()) {
            apiRequestParameter.setCategory(1);
            apiRequestParameterList.add(apiRequestParameter);
        }
        for (ApiRequestParameter apiRequestParameter : api.getRequestBodyParameterList()) {
            apiRequestParameter.setCategory(2);
            apiRequestParameterList.add(apiRequestParameter);
        }
    }
}
