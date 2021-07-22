package com.basis.campina.xdocumentos.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

    private String url;
    private String accessKey;
    private String secretKey;
    private String bucket;
}
