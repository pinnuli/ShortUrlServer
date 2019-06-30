package com.cvte.po;

import java.io.Serializable;

/**
 * @date 2019/6/24
 * @author pinnuli
 */
public class ApiRequestExample implements Serializable {

    private static final long serialVersionUID = -1815692180979787564L;

    private Integer exampleId;

    private Integer apiId;

    private String language;

    private String content;

    public Integer getExampleId() {
        return exampleId;
    }

    public void setExampleId(Integer exampleId) {
        this.exampleId = exampleId;
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
