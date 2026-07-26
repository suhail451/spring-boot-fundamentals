package com.filterPractice.filterPractice.GlobalException;

public class DuplicateUpdate extends RuntimeException {

    public DuplicateUpdate(String msg){
        super(msg);
    }
}
