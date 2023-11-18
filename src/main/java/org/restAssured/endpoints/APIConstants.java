package org.restAssured.endpoints;

import org.restAssured.utils.PropertyReaderUtil;

public class APIConstants {
    public static final String BASE_URL = PropertyReaderUtil.readKey("baseURL");
    public static final String CREATE_BOOKING = "/booking";
    public static final String UPDATE_BOOKING = "/booking";
    public static final String AUTH = "/auth";
    public static final String DELETE_BOOKING = "/booking/";
}
