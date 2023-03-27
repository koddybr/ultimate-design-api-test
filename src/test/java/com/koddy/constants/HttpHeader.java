package com.koddy.constants;

public enum HttpHeader {
    AUTHORIZATION("Authorization");

    public final String name;
    private HttpHeader(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
