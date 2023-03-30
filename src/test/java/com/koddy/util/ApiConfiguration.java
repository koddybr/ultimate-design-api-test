package com.koddy.util;

public class ApiConfiguration {

    public static final String API_AUTH = "/api/login";
    public static final String LOGIN =
            Enviroment.getInstance().getHost() +
            API_AUTH;
    public static final String API = "/api/auth";

    public static final String INVENTORY = API + "/inventory" ;
    public static final String INVENTORY_OBSERVATION = API + "/inventory_observations" ;

    public static final String INVENTORY_ALL =
        Enviroment.getInstance().getHost() +
        INVENTORY;
    public static final String INVENTORY_STORE =
            Enviroment.getInstance().getHost() +
                    INVENTORY;
    public static final String INVENTORY_GET =
            Enviroment.getInstance().getHost() +
                    INVENTORY + "/%s";
    public static final String INVENTORY_UPDATE =
            Enviroment.getInstance().getHost() +
                    INVENTORY + "/%s";

    // POST
    public static final String INVENTORY_MOVMENT =
            Enviroment.getInstance().getHost() +
                    API + "/area/transfer";

    // POST
    public static final String INVENTORY_TRANSFER =
            Enviroment.getInstance().getHost() +
                    API + "/area/transfer";

    // INVENTORY OBSERVATION
    public static final String INVENTORY_OBSERVATION_ALL =
            Enviroment.getInstance().getHost() +
                    INVENTORY_OBSERVATION;
    public static final String INVENTORY_OBSERVATION_STORE =
            Enviroment.getInstance().getHost() +
                    INVENTORY_OBSERVATION;
    public static final String INVENTORY_OBSERVATION_GET =
            Enviroment.getInstance().getHost() +
                    INVENTORY_OBSERVATION + "/%s";
    public static final String INVENTORY_OBSERVATION_UPDATE =
            Enviroment.getInstance().getHost() +
                    INVENTORY_OBSERVATION + "/%s";

    public static final String BUYOUT =
            Enviroment.getInstance().getHost() +
                    API + "/buyout/0";

    // CLIENT
    public static final String CLIENT = API + "/client" ;
    public static final String CLIENT_ALL =
            Enviroment.getInstance().getHost() +
                    CLIENT;
    public static final String CLIENT_STORE =
            Enviroment.getInstance().getHost() +
                    CLIENT;
    public static final String CLIENT_GET =
            Enviroment.getInstance().getHost() +
                    CLIENT + "/%s";
    public static final String CLIENT_UPDATE =
            Enviroment.getInstance().getHost() +
                    CLIENT + "/%s";

    // CLIENT
    public static final String CONSTRUCTION = API + "/construction" ;
    public static final String CONSTRUCTION_ALL =
            Enviroment.getInstance().getHost() +
                    CONSTRUCTION;
    public static final String CONSTRUCTION_STORE =
            Enviroment.getInstance().getHost() +
                    CONSTRUCTION;
    public static final String CONSTRUCTION_GET =
            Enviroment.getInstance().getHost() +
                    CONSTRUCTION + "/%s";
    public static final String CONSTRUCTION_UPDATE =
            Enviroment.getInstance().getHost() +
                    CONSTRUCTION;

    // CLIENT
    public static final String ORDER = API + "/order" ;
    public static final String ORDER_ALL =
            Enviroment.getInstance().getHost() +
                    ORDER;
    public static final String ORDER_STORE =
            Enviroment.getInstance().getHost() +
                    ORDER;
    public static final String ORDER_GET =
            Enviroment.getInstance().getHost() +
                    ORDER + "/%s";
    public static final String ORDER_UPDATE =
            Enviroment.getInstance().getHost() +
                    ORDER;

    // DISPATCH
    public static final String DISPATCH = API + "/dispatch" ;
    public static final String DISPATCH_ALL =
            Enviroment.getInstance().getHost() +
                    DISPATCH;
    public static final String DISPATCH_STORE =
            Enviroment.getInstance().getHost() +
                    DISPATCH;
    public static final String DISPATCH_GET =
            Enviroment.getInstance().getHost() +
                    DISPATCH + "/%s/edit";
    public static final String DISPATCH_UPDATE =
            Enviroment.getInstance().getHost() +
                    DISPATCH;

    // PRODUCT
    public static final String PRODUCT = API + "/product" ;
    public static final String PRODUCT_ALL =
            Enviroment.getInstance().getHost() +
                    PRODUCT;
    public static final String PRODUCT_STORE =
            Enviroment.getInstance().getHost() +
                    PRODUCT;
    public static final String PRODUCT_GET =
            Enviroment.getInstance().getHost() +
                    PRODUCT + "/%s";
    public static final String PRODUCT_UPDATE =
            Enviroment.getInstance().getHost() +
                    PRODUCT;

    // PRODUCT_TYPE
    public static final String PRODUCT_TYPE = API + "/product_type" ;
    public static final String PRODUCT_TYPE_ALL =
            Enviroment.getInstance().getHost() +
                    PRODUCT_TYPE;
    public static final String PRODUCT_TYPE_STORE =
            Enviroment.getInstance().getHost() +
                    PRODUCT_TYPE;
    public static final String PRODUCT_TYPE_GET =
            Enviroment.getInstance().getHost() +
                    PRODUCT_TYPE + "/%s/edit";
    public static final String PRODUCT_TYPE_UPDATE =
            Enviroment.getInstance().getHost() +
                    PRODUCT_TYPE;

}
