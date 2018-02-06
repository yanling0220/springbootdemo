package com.aceyan.framework.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author yanling
 * @time 2018-01-24-18:40
 */
@ConfigurationProperties(prefix = "wisely")
public class WiselySettings {
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
