package com.alibaba.arthas.tunnel.server.app.web.response.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class PidRequest implements Serializable {
    private String ip;
    private Integer pid;
}
