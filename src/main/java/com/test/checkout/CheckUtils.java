package com.test.checkout;

public class CheckUtils {

    public static<T> T checkNotNull(T obj) {
        if(obj == null) {
            throw new IllegalArgumentException("Validation: Null is not a valid argument");
        }
        return obj;
    }

    public static String checkNotNullOrEmpty(String s){
        checkNotNull(s);
        if(s.isEmpty()){
            throw new IllegalArgumentException();
        }
        return s;
    }
}
