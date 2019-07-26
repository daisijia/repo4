package com.xuecheng.manage_cms.service;

import com.xuecheng.api.cms.CmsPageControllerApi;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import org.springframework.web.bind.annotation.PathVariable;

public interface CmsPageService {
    /**
     * 分页查询所有
     * @param page 页码从1计数
     * @param size 每页记录条数
     * @param queryPageRequest 查询条件
     * @return
     */
    public QueryResponseResult findList(@PathVariable(value = "page") int page, @PathVariable(value = "size") int size, QueryPageRequest queryPageRequest);
}
