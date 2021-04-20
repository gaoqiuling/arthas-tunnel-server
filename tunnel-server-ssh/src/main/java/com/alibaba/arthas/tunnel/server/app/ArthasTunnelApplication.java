package com.alibaba.arthas.tunnel.server.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.io.Console;
import java.io.IOException;

@SpringBootApplication(scanBasePackages = {"com.alibaba.arthas.tunnel.server.app",
        "com.alibaba.arthas.tunnel.server.endpoint"})
@EnableCaching
public class ArthasTunnelApplication {
    private static final Console con = System.console();

    public static void main(String[] args) throws IOException {
        SpringApplication.run(ArthasTunnelApplication.class, args);
    }
}
