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
public class OutlineApiVo implements Serializable{

    private static final long serialVersionUID = -8813883619650408687L;

    private Integer apiId;

    private String illustration;

    private String requestAddress;

    private String requestMethod;

    private String contentType;

    public OutlineApiVo(Api api) {
        this.apiId = api.getApiId();
        this.contentType = api.getContentType();
        this.illustration = api.getIllustration();
        this.requestAddress = api.getRequestAddress();
        this.requestMethod = api.getRequestMethod();
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
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
}
