package io.exploretheweb.cloudfoundryapp.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ConfigurationSettings {

    @Value("${config.app.name}")
    private String name;

    @Value("${greeting}")
    private String greeting;

}
