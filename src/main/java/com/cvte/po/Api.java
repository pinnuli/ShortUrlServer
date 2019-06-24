package com.cvte.po;

import java.io.Serializable;
import java.util.List;

/**
 * @author pinnuli
 * @date 2019/6/24
 */
public class Api implements Serializable {

    private static final long serialVersionUID = 2734578572097927244L;

    private Integer apiId;

    private String illustration;

    private String requestAddress;

    private String requestMethod;

    private String contentType;

    private List<ApiRequestParameter> requestParameterList;

    private List<ApiRequestExample> requestExampleList;

    private String responseExample;

    private List<ApiResponseParameter> responseParameterList;

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

    public List<ApiRequestParameter> getRequestParameterList() {
        return requestParameterList;
    }

    public void setRequestParameterList(List<ApiRequestParameter> requestParameterList) {
        this.requestParameterList = requestParameterList;
    }

    public List<ApiRequestExample> getRequestExampleList() {
        return requestExampleList;
    }

    public void setRequestExampleList(List<ApiRequestExample> requestExampleList) {
        this.requestExampleList = requestExampleList;
    }

    public String getResponseExample() {
        return responseExample;
    }

    public void setResponseExample(String responseExample) {
        this.responseExample = responseExample;
    }

    public List<ApiResponseParameter> getResponseParameterList() {
        return responseParameterList;
    }

    public void setResponseParameterList(List<ApiResponseParameter> responseParameterList) {
        this.responseParameterList = responseParameterList;
    }
}
