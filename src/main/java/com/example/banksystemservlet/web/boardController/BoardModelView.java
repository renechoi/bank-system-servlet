package com.example.banksystemservlet.web.boardController;

import java.util.HashMap;
import java.util.Map;

public class BoardModelView {
    private String viewName;
    private Map<String, Object> model = new HashMap<>();

    public BoardModelView(String viewName, Map<String, Object> model) {
        this.viewName = viewName;
        this.model = model;
    }

    public BoardModelView(String viewName) {
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
