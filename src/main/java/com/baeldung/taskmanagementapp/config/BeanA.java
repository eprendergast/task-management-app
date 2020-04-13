package com.baeldung.taskmanagementapp.config;

import javax.annotation.PostConstruct;

public class BeanA {

    @PostConstruct // Spring will run method annotated with PostContruct only once right after the bean is initialised
    public void post() {
        System.out.println("Hello");
    }

}
