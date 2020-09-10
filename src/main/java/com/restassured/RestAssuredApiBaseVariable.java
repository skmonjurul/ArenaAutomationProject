package com.restassured;

public interface RestAssuredApiBaseVariable {
    static final String JSON_CONTENT_TYPE = "";
    static final String XML_CONTENT_TYPE = "";


    static final int SC_CONTINUE = 100;
    static final int SC_SWITCHING_PROTOCOLS = 101;
    static final int SC_PROCESSING = 102;
    static final int SC_OK = 200;
    static final int SC_CREATED = 201;
    static final int SC_ACCEPTED = 202;
    static final int SC_NON_AUTHORITATIVE_INFORMATION = 203;
    static final int SC_NO_CONTENT = 204;
    static final int SC_RESET_CONTENT = 205;
    static final int SC_PARTIAL_CONTENT = 206;
    static final int SC_MULTI_STATUS = 207;
    static final int SC_MULTIPLE_CHOICES = 300;
    static final int SC_MOVED_PERMANENTLY = 301;
    static final int SC_MOVED_TEMPORARILY = 302;
    static final int SC_SEE_OTHER = 303;
    static final int SC_NOT_MODIFIED = 304;
    static final int SC_USE_PROXY = 305;
    static final int SC_TEMPORARY_REDIRECT = 307;
    static final int SC_BAD_REQUEST = 400;
    static final int SC_UNAUTHORIZED = 401;
    static final int SC_PAYMENT_REQUIRED = 402;
    static final int SC_FORBIDDEN = 403;
    static final int SC_NOT_FOUND = 404;
    static final int SC_METHOD_NOT_ALLOWED = 405;
    static final int SC_NOT_ACCEPTABLE = 406;
    static final int SC_PROXY_AUTHENTICATION_REQUIRED = 407;
    static final int SC_REQUEST_TIMEOUT = 408;
    static final int SC_CONFLICT = 409;
    static final int SC_GONE = 410;
    static final int SC_LENGTH_REQUIRED = 411;
    static final int SC_PRECONDITION_FAILED = 412;
    static final int SC_REQUEST_TOO_LONG = 413;
    static final int SC_REQUEST_URI_TOO_LONG = 414;
    static final int SC_UNSUPPORTED_MEDIA_TYPE = 415;
    static final int SC_REQUESTED_RANGE_NOT_SATISFIABLE = 416;
    static final int SC_EXPECTATION_FAILED = 417;
    static final int SC_INSUFFICIENT_SPACE_ON_RESOURCE = 419;
    static final int SC_METHOD_FAILURE = 420;
    static final int SC_UNPROCESSABLE_ENTITY = 422;
    static final int SC_LOCKED = 423;
    static final int SC_FAILED_DEPENDENCY = 424;
    static final int SC_INTERNAL_SERVER_ERROR = 500;
    static final int SC_NOT_IMPLEMENTED = 501;
    static final int SC_BAD_GATEWAY = 502;
    static final int SC_SERVICE_UNAVAILABLE = 503;
    static final int SC_GATEWAY_TIMEOUT = 504;
    static final int SC_HTTP_VERSION_NOT_SUPPORTED = 505;
    static final int SC_INSUFFICIENT_STORAGE = 507;
}
