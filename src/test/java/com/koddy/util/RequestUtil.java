package com.koddy.util;

import java.util.UUID;

public class RequestUtil {

    public static String generateCode(){
        return "TEST-CODE"+ UUID.randomUUID();
    }

    public static String generateDescription(){
        return "This is a description: "+ UUID.randomUUID();
    }
}
