package com.example.demo.aop_example;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class Boundary implements Handler {

    private List<Before> befores = new ArrayList<>();
    private List<After> afters = new ArrayList<>();

    private Handler handler;

    @Override
    public void handler() {
        executeBefore();
        try {
            handler.handler();
        } catch (Exception ex) {
            // handle exception
        }

        executeAfter();
    }

    private void executeBefore() {
        if (CollectionUtils.isEmpty(befores)) {
            return;
        }
        befores.stream().forEach(Before::execute);
    }


    private void executeAfter() {
        if (CollectionUtils.isEmpty(afters)) {
            return;
        }
        afters.stream().forEach(After::execute);
    }
}
