package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebServlet(name = "logoutController", urlPatterns = "/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("log out...............");

        HttpSession session = req.getSession();
        session.removeAttribute("loginInfo"); // HttpSession 객체에서 "loginInfo" 속성 제거
        session.invalidate(); // HttpSession 개체를 무효화 세션에 저장된 모든 속성이 제거

        resp.sendRedirect("/");
    }
}
