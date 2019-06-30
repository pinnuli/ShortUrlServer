package com.cvte.po;

import java.io.Serializable;

/**
 * @author pinnuli
 * @date 2019/6/24
 */
public class ApiResponseParameter implements Serializable{

    private static final long serialVersionUID = 2533840015904321119L;

    private Integer parameterId;

    private String name;

    private String type;

    private String illustration;

    private Integer apiId;

    public Integer getParameterId() {
        return parameterId;
    }

    public void setParameterId(Integer parameterId) {
        this.parameterId = parameterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIllustration() {
        return illustration;
    }

    public void setIllustration(String illustration) {
        this.illustration = illustration;
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }
}
