package com.huy.spring_study.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties("app")
@Component
@Getter
@Setter
public class AppProperties {
    @JsonProperty("cors")
    private Cors cors;

    @Getter
    @Setter
    public static class Cors {
        private List<String> origins;
    }
}
