package com.emporiumsystem.model;

import lombok.Data;

/**
 * 统计类
 *
 * @author QingLife-剑漫羽游
 */
@Data
public class Stat {

    private String name;
    private String counts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }
}
