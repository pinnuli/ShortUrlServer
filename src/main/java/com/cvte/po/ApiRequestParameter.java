package com.cvte.po;

import java.io.Serializable;

/**
 * @author pinnuli
 * @date 2019/6/24
 */
public class ApiRequestParameter implements Serializable{

    private static final long serialVersionUID = 3203073634646726152L;

    private Integer parameterId;

    private Integer category;

    private String name;

    private String type;

    private String illustration;

    private String example;

    public Integer getParameterId() {
        return parameterId;
    }

    public void setParameterId(Integer parameterId) {
        this.parameterId = parameterId;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
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
