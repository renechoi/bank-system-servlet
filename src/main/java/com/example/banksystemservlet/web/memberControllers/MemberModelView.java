package com.example.banksystemservlet.web.memberControllers;

import java.util.HashMap;
import java.util.Map;

public class MemberModelView {

    private String viewName;
    private Map<String, Object> model = new HashMap<>();

    public MemberModelView(String viewName, Map<String, Object> model) {
        this.viewName = viewName;
        this.model = model;
    }

    public MemberModelView(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
