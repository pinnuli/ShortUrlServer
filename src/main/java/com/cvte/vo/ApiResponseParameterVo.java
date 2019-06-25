package com.cvte.vo;

import com.cvte.po.ApiResponseParameter;

import java.io.Serializable;

/**
 * @author pinnuli
 * @date 2019/6/25
 */
public class ApiResponseParameterVo implements Serializable {

    private static final long serialVersionUID = -8997958286156196856L;

    private String name;

    private String type;

    private String illustration;

    public ApiResponseParameterVo(ApiResponseParameter apiResponseParameter) {
        this.name = apiResponseParameter.getName();
        this.type = apiResponseParameter.getType();
        this.illustration = apiResponseParameter.getIllustration();
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
}
