package com.example.cowmanager.util;

public class CowManagerConstants {
    /**
     *
     */
    public static final int COW_MANAGER_SUCCESS = 0;
    /**
     *
     */
    public static final int COW_MANAGER_FAIL = COW_MANAGER_SUCCESS + 1;
    /**
     *
     */
    public static final int ROLE_MANAGER = 0;
    /**
     *
     */
    public static final int ROLE_EMPLOYEE = ROLE_MANAGER + 1;
    /**
     *
     */
    public static final int DEVICE_STATUS_GOOD = 0;
    /**
     *
     */
    public static final int DEVICE_STATUS_BAD = DEVICE_STATUS_GOOD + 1;
    /**
     *
     */
    public static final int DEVICE_STATUS_OFF = DEVICE_STATUS_BAD + 1;
    /**
     *
     */
    public static final int COW_HEALTH_GOOD = 0;
    /**
     *
     */
    public static final int COW_HEALTH_BAD = COW_HEALTH_GOOD + 1;
    /**
     *
     */
    public static final int EMPLOYEE_STATUS_ON = 0;
    /**
     *
     */
    public static final int EMPLOYEE_STATUS_OFF = EMPLOYEE_STATUS_ON + 1;
    /**
     *
     */
    public static final int CAGE_STATUS_ON = 0;
    /**
     *
     */
    public static final int CAGE_STATUS_OFF = CAGE_STATUS_ON + 1;
    /**
     *
     */
    public static final Integer COW_STATUS_ON = 0;
    /**
     *
     */
    public static final Integer COW_STATUS_IN_CASE = COW_STATUS_ON + 1;
    /**
     *
     */
    public static final Integer COW_STATUS_GETTING_MILK = COW_STATUS_IN_CASE + 1;
    /**
     *
     */
    public static final Integer COW_STATUS_OFF = COW_STATUS_GETTING_MILK + 1;

    /**
     *
     */
    private CowManagerConstants() {
    }
}
