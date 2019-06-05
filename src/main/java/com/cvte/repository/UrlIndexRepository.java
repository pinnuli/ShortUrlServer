package com.cvte.repository;

import com.cvte.dao.UrlIndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author linxiaoyi
 * @date 2019/5/29
 */
@Component
public class UrlIndexRepository {

    @Autowired
    private UrlIndexMapper urlIndexMapper;

    public List<Integer> getUrlIndex() {
        return urlIndexMapper.getUrlIndex();
    }

    public void updateUrlIndex(int index) {
        urlIndexMapper.updateIndex(index);
    }
}
