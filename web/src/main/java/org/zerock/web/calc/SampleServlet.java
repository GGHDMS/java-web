package org.zerock.web.calc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SampleServlet", urlPatterns = "/sample")
public class SampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet..." + this);
    }

    @Override
    public void destroy() { // 톰캣 종료시
        System.out.println("destroy............................");
    }

    @Override
    public void init(ServletConfig config) throws ServletException { //생성 최초 실행시만
        System.out.println("init(ServletConfig).......................");
    }
}
