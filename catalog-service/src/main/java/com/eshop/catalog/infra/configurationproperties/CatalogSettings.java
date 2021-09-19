package com.eshop.catalog.infra.configurationproperties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConfigurationProperties
@Configuration
public class CatalogSettings {

    private String picBaseUrl;

    private String eventBusConnection;

    private boolean useCustomizationData;

    private boolean azureStorageEnabled;

}
