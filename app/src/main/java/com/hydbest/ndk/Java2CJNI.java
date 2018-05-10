package com.hydbest.ndk;

/**
 * Created by csz on 2018/5/4.
 */

public class Java2CJNI {

    static {
        System.loadLibrary("native");
    }

    public native String java2C();

}
