package com.team.netch.regLogAdminSecurity.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {

    @Override
    public boolean test(String s) {
        //Regex to validate email
        return true;
    }
}
