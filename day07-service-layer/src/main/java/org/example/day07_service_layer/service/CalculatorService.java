package org.example.day07_service_layer.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double add(double a,double b){
        return a+b;
    }

    public double sub(double a,double b){
        return a-b;
    }

    public double mul(double a,double b){
        return a*b;
    }

    public double div(double a,double b){

        if(b==0){
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
        return a/b;
    }

}