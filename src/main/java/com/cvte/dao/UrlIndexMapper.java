package com.cvte.dao;

import java.util.List;

/**
 * @author linxiaoyi
 * @date 2019/5/29
 */
public interface UrlIndexMapper {

    List<Integer> getUrlIndex();

    void updateIndex(Integer index);

}
