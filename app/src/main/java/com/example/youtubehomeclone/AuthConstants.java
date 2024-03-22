package com.example.youtubehomeclone;

public interface AuthConstants {

    // TODO Change it to your web domain
    public final static String WEB_DOMAIN = "zoom.us";

    /**
     * We recommend that, you can generate jwttoken on your own server instead of hardcore in the code.
     * We hardcore it here, just to run the demo.
     *
     * You can generate a jwttoken on the https://jwt.io/
     * with this payload:
     * {
     *
     *     "appKey": "string", // app key
     *     "iat": long, // access token issue timestamp
     *     "exp": long, // access token expire time
     *     "tokenExp": long // token expire time
     * }
     */
    public final static String SDK_JWTTOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhcHBLZXkiOiJuRGJwdlVmYm44cXVnbFpISlhOVHpVZnJjU2JMeFNRTiIsImlhdCI6MTcwOTU0MzU2OSwiZXhwIjoxNzA5NzE2MzY5LCJ0b2tlbkV4cCI6MTcwOTcxNjM2OX0.o7q9vri4UCzDW7HxqPRyckYtEJAB9x6_rwfwuvekPTo";

}
