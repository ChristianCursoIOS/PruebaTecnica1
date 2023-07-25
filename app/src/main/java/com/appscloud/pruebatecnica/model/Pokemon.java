package com.appscloud.pruebatecnica.model;

public class Pokemon {

    private final String name;
    private final String url;

    public Pokemon(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
