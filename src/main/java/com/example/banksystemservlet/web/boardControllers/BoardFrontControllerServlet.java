package com.example.banksystemservlet.web.boardControllers;

import com.example.banksystemservlet.Result;
import com.example.banksystemservlet.ResultRepository;
import com.example.banksystemservlet.domain.board.BoardManager;
import com.example.banksystemservlet.web.boardControllers.result.ArticleContentController;
import com.example.banksystemservlet.web.boardControllers.result.ArticleReadResultController;
import com.example.banksystemservlet.web.boardControllers.form.ArticleWriteFormController;
import com.example.banksystemservlet.web.boardControllers.result.ArticleSaveResultController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name ="boardFrontControllerServlet", urlPatterns = "/board/*")
public class BoardFrontControllerServlet extends HttpServlet {

    private final Map<String, BoardController> controllerMap = new HashMap<>();

    public BoardFrontControllerServlet() {
        controllerMap.put("/board/article-write-form", new ArticleWriteFormController());
        controllerMap.put("/board/article-save-result", new ArticleSaveResultController());
        controllerMap.put("/board/article-read-result", new ArticleReadResultController());
        controllerMap.put("/board/article-content", new ArticleContentController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        BoardController boardController = controllerMap.get(requestURI);
        if (boardController == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        BoardManager boardManager = new BoardManager();

        Result result = ResultRepository.result;

        Map<String, String> paramMap = createParamMap(request);
        BoardModelView BoardModelView = boardController.process(boardManager, paramMap, result);

        BoardView boardView = viewResolver(BoardModelView.getViewName());
        boardView.render(BoardModelView.getModel(), request, response);
    }

    private static BoardView viewResolver(String viewName) {
        return new BoardView("/WEB-INF/board/" + viewName + ".jsp");
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
