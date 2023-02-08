package com.example.banksystemservlet;

import com.example.banksystemservlet.domain.board.BoardManager;
import com.example.banksystemservlet.domain.board.BoardResult;
import com.example.banksystemservlet.web.boardController.BoardView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "homeServlet", urlPatterns = "")
public class HomeServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BoardManager boardManager = new BoardManager();
        BoardResult boardResult = boardManager.readWithPageLimit(3, 1);

        Map<String, Object> model = new HashMap<>();
        model.put("boardResult", boardResult);

        BoardView boardView = viewResolver("home");
        boardView.render(model, request, response);
    }


    private BoardView viewResolver(String viewName) {
        return new BoardView("/WEB-INF/" + viewName + ".jsp");
    }


}
