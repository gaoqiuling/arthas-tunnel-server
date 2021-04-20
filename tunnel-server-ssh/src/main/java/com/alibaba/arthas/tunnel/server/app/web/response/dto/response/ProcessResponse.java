package com.alibaba.arthas.tunnel.server.app.web.response.dto.response;

import lombok.Data;

@Data
public class ProcessResponse implements BaseResponse {
    private Integer id;
    private Integer pid;
    private String name;
}
