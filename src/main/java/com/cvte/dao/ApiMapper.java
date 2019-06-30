package com.cvte.dao;

import com.cvte.po.Api;
import com.cvte.po.ApiRequestExample;
import com.cvte.po.ApiRequestParameter;
import com.cvte.po.ApiResponseParameter;

import java.util.List;

/**
 * @author pinnuli
 * @date 2019/6/24
 */
public interface ApiMapper {

    Api selectDetailApi(Integer apiId);

    List<Api> selectDetailApiList();

    List<Api> selectOutlineApiList();

    void insertApi(Api api);

    void updateApi(Api api);

    void insertOrUpdateRequestExample(List<ApiRequestExample> apiRequestExampleList);

    void insertOrUpdateRequestParameter(List<ApiRequestParameter> apiRequestParameterList);

    void insertOrUpdateResponseParameter(List<ApiResponseParameter> apiResponseExampleList);

    void deleteApi(Integer apiId);
}
