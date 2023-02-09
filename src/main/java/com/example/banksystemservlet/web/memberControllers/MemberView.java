package com.example.banksystemservlet.web.memberControllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class MemberView {

    private String viewPath;

    public MemberView(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        modelToRequestAttribute(model, request);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        requestDispatcher.forward(request,response);
    }
    //reuslt를 전달해준다 => memberResult - result
    private static void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        model.forEach(session::setAttribute);
    }

}
