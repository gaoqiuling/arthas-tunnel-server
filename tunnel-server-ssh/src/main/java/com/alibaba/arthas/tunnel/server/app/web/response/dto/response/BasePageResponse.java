package com.alibaba.arthas.tunnel.server.app.web.response.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public abstract class BasePageResponse<T extends Serializable> implements BaseResponse {

    /**
     * 记录总数
     */
    private Integer total;

    /**
     * 当前页数据集合
     */
    private List<T> items;

    /**
     * 请求页码
     */
    private Integer pageNo;

    /**
     * 请求页面大小
     */
    private Integer limit;

    /**
     * 是否有下一页
     */
    private Boolean morePage;

    /**
     * 请求起始索引
     */
    private Integer start;
}
