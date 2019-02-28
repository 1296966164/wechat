package com.hhuc.wechat.x.Service;

import com.hhuc.wechat.x.DAO.Login_request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: Wechat_1
 * @description:
 * @author: LYX
 * @create: 2019-02-22 21:40
 **/

@WebServlet("/Service/LoginWx")
public class LoginWx extends HttpServlet{


    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginWx() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        // 处理中文
        String code = new String(request.getParameter("code").getBytes("ISO8859-1"), "UTF-8");
        System.out.println(code);
        Login_request req=new Login_request(code);
        String res = req.Code2Session();

        out.println(res);
    }

    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}

