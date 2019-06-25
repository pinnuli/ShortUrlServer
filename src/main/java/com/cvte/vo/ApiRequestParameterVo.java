package com.cvte.vo;

import com.cvte.po.ApiRequestParameter;

import java.io.Serializable;

/**
 * @author pinnuli
 * @date 2019/6/25
 */
public class ApiRequestParameterVo implements Serializable {

    private static final long serialVersionUID = -2893524459964115083L;

    private String name;

    private String type;

    private String illustration;

    private String example;

    public ApiRequestParameterVo(ApiRequestParameter apiRequestParameter) {
        this.name = apiRequestParameter.getName();
        this.type = apiRequestParameter.getType();
        this.illustration = apiRequestParameter.getIllustration();
        this.example = apiRequestParameter.getExample();
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

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
