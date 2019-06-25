package com.cvte.vo;

import com.cvte.po.Api;
import com.cvte.po.ApiRequestExample;
import com.cvte.po.ApiRequestParameter;
import com.cvte.po.ApiResponseParameter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pinnuli
 * @date 2019/6/25
 */
public class ApiVo implements Serializable{

    private static final long serialVersionUID = -8813883619650408687L;

    private String illustration;

    private String requestAddress;

    private String requestMethod;

    private String contentType;

    private List<ApiRequestParameterVo> requestBodyParameterList;

    private List<ApiRequestParameterVo> requestHeaderParameterList;

    private List<ApiRequestExampleVo> requestExampleList;

    private String responseExample;

    private List<ApiResponseParameterVo> responseParameterList;

    public ApiVo(Api api) {
        this.contentType = api.getContentType();
        this.illustration = api.getIllustration();
        this.requestAddress = api.getRequestAddress();
        this.requestMethod = api.getRequestMethod();
        this.responseExample = api.getResponseExample();
        this.requestExampleList = new ArrayList<>();
        this.requestHeaderParameterList = new ArrayList<>();
        this.requestBodyParameterList = new ArrayList<>();
        this.responseParameterList = new ArrayList<>();
        for (ApiRequestExample apiRequestExample : api.getRequestExampleList()) {
            this.requestExampleList.add(new ApiRequestExampleVo(apiRequestExample));
        }
        for (ApiRequestParameter apiRequestParameter : api.getRequestParameterList()) {
            if (apiRequestParameter.getCategory().equals(1)) {
                this.requestHeaderParameterList.add(new ApiRequestParameterVo(apiRequestParameter));
            } else {
                this.requestBodyParameterList.add(new ApiRequestParameterVo(apiRequestParameter));
            }
        }
        for (ApiResponseParameter apiResponseParameter : api.getResponseParameterList()) {
            this.responseParameterList.add(new ApiResponseParameterVo(apiResponseParameter));
        }
    }

    public String getIllustration() {
        return illustration;
    }

    public void setIllustration(String illustration) {
        this.illustration = illustration;
    }

    public String getRequestAddress() {
        return requestAddress;
    }

    public void setRequestAddress(String requestAddress) {
        this.requestAddress = requestAddress;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public List<ApiRequestParameterVo> getRequestBodyParameterList() {
        return requestBodyParameterList;
    }

    public void setRequestBodyParameterList(List<ApiRequestParameterVo> requestBodyParameterList) {
        this.requestBodyParameterList = requestBodyParameterList;
    }

    public List<ApiRequestParameterVo> getRequestHeaderParameterList() {
        return requestHeaderParameterList;
    }

    public void setRequestHeaderParameterList(List<ApiRequestParameterVo> requestHeaderParameterList) {
        this.requestHeaderParameterList = requestHeaderParameterList;
    }

    public List<ApiRequestExampleVo> getRequestExampleList() {
        return requestExampleList;
    }

    public void setRequestExampleList(List<ApiRequestExampleVo> requestExampleList) {
        this.requestExampleList = requestExampleList;
    }

    public String getResponseExample() {
        return responseExample;
    }

    public void setResponseExample(String responseExample) {
        this.responseExample = responseExample;
    }

    public List<ApiResponseParameterVo> getResponseParameterList() {
        return responseParameterList;
    }

    public void setResponseParameterList(List<ApiResponseParameterVo> responseParameterList) {
        this.responseParameterList = responseParameterList;
    }
}
