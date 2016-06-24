package com.walmart.ticket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring configuration file loading application properties
 */
@Configuration
@PropertySource({ "classpath:database/sql-query.properties" })
public class PropertyConfiguration {

}
