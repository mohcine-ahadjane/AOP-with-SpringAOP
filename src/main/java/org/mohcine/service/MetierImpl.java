package org.mohcine.service;

import org.mohcine.aspects.Log;
import org.mohcine.aspects.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier{
    @Override
    @Log
    @SecuredByAspect(roles = {"USER", "ADMIN"})
    public void process() {
        System.out.println("Business Process ....");
    }

    @Override
    @SecuredByAspect(roles = {"ADMIN"})
    public double compute() {
        double data=88;
        System.out.println("Business Computing and returning");
        return data;
    }
}
