package com.example.banksystemservlet.web.frontcontroller;

import com.example.banksystemservlet.domain.member.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class BankView {
    private String viewPath;

    public BankView(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        requestDispatcher.forward(request, response);
    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        modelToRequestAttribute(model, request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        requestDispatcher.forward(request,response);
    }
//
    private static void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        model.forEach( (key, value) -> session.setAttribute(key, value));
//        checkModelInside(model);
    }

    private static void checkModelInside(Map<String, Object> model) {
        model.forEach( (key, value)-> {
            System.out.println("key = " + key);
            System.out.println("value = " + value);

            if (Objects.equals(key, "member")){
                Member member = (Member) value;
                System.out.println("member.getMemberId() = " + member.getMemberId());
                System.out.println("member.getMemberId() = " + member.getName());
            }
                }
        );
    }
}
