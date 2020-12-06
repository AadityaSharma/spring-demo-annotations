package com.aadi.learn.services;

public class SadFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Today is never a sad day! Live life in an awesome way!";
    }
}
