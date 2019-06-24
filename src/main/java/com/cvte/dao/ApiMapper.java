package com.cvte.dao;

import com.cvte.po.Api;

import java.util.List;

/**
 * @author pinnuli
 * @date 2019/6/24
 */
public interface ApiMapper {

    List<Api> selectApiList();
}
