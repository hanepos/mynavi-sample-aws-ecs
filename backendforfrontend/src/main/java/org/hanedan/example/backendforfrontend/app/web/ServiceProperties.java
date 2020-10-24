package org.hanedan.example.backendforfrontend.app.web;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "service")
public class ServiceProperties {

    @Getter
    @Setter
    private String dns;
}
