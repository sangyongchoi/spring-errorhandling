package com.example.errorhandling.service;

import com.example.errorhandling.exception.CoreExceptionONE;
import com.example.errorhandling.exception.CoreExceptionTWO;
import com.example.errorhandling.exception.InternalServerException;
import com.example.errorhandling.exception.code.ErrorCode;
import org.springframework.stereotype.Service;

@Service
public class serviceMethod {
    public void testMethod1(){
        throw new CoreExceptionONE(ErrorCode.ERROR_ONE);
    }
    public void testMethod2(){
        throw new CoreExceptionTWO(ErrorCode.ERROR_TWO);
    }
    public void defaultError(){
        try{
            int[] arr = new int[4];
            int a = arr[10];
        }catch (Exception e){
            throw e;
        }
    }
}
