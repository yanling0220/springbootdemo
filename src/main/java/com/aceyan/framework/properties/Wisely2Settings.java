package com.aceyan.framework.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yanling
 * @time 2018-01-24-18:27
 */
@ConfigurationProperties(prefix = "wisely2")
public class Wisely2Settings  {
    private String name;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
