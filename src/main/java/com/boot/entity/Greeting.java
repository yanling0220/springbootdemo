package com.boot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Greeting Entity
 *
 * @author yanling
 * @time 2017-09-07-14:57
 */
@Entity
public class Greeting implements Serializable{
    private static final long serialVersionUID = -8722114203921143186L;
    @Id
    @GeneratedValue
    private final long id;
    private final String content;

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }
}
