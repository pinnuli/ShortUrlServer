package com.cvte.vo;

import com.cvte.po.ApiRequestExample;

import java.io.Serializable;

/**
 * @author pinnuli
 * @date 2019/6/25
 */
public class ApiRequestExampleVo implements Serializable {

    private static final long serialVersionUID = -3177636070479961722L;

    private String language;

    private String content;

    public ApiRequestExampleVo(ApiRequestExample apiRequestExample) {
        this.content = apiRequestExample.getContent();
        this.language = apiRequestExample.getLanguage();
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
