package com.hhuc.wechat.x.Service;
/**
 * @program: pt
 * @description: openid
 * @author: LYX
 * @create: 2019-02-22 17:10
 * 修改个人信息
 *
 * 接受修改后的信息，写入数据库
 **/

import com.hhuc.wechat.x.DAO.Userexer;
import com.hhuc.wechat.x.Models.User;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Service/Adduser")
public class AddUser extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(AddUser.class);


    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        System.out.println("v000000000000000000000000000000000000000000000000000000000000000000000000");
        BasicConfigurator.configure ();

        //Todo 修改为外部配置文件

        // TODO Auto-generated constructor stub
    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置响应内容类型
        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        // 处理中文
        String openid = new String(request.getParameter("openid").getBytes("ISO8859-1"), "UTF-8");
        String avatarUrl = new String(request.getParameter("avatarUrl").getBytes("ISO8859-1"), "UTF-8");
        String nickname  = new String(request.getParameter("nickname").getBytes("ISO8859-1"), "UTF-8");
        String country  = new String(request.getParameter("country").getBytes("ISO8859-1"), "UTF-8");
        String phone = new String(request.getParameter("phone").getBytes("ISO8859-1"), "UTF-8");
        String city = new String(request.getParameter("city").getBytes("ISO8859-1"), "UTF-8");
        String province = new String(request.getParameter("province").getBytes("ISO8859-1"), "UTF-8");
        String language = new String(request.getParameter("language").getBytes("ISO8859-1"), "UTF-8");


        User user = new User(openid, phone, city, province, country, avatarUrl, language, nickname);


        Userexer userexer = new Userexer(user);
        String res = userexer.addUser();
        out.println(res);
    }
    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}