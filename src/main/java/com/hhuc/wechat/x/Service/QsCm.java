package com.hhuc.wechat.x.Service;
/**
 * @program: pt
 * @description: openid
 * @author: LYX
 * @create: 2019-02-22 17:10
 **/

import com.hhuc.wechat.x.DAO.Suggexer;
import com.hhuc.wechat.x.DAO.Userexer;
import com.hhuc.wechat.x.Models.Suggestion;
import com.hhuc.wechat.x.Models.User;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Service/QsCm")
public class QsCm extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(QsCm.class);


    /**
     * @see HttpServlet#HttpServlet()
     */
    public QsCm() {
        super();
        BasicConfigurator.configure();

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
        String towho = new String(request.getParameter("towho").getBytes("ISO8859-1"), "UTF-8");

        Suggestion suggestion = new Suggestion();

        suggestion.setTowho(towho);
        Suggexer suggexer = new Suggexer(suggestion);

        String res = suggexer.queryCm();

        logger.info(res);
        // 记录error级别的信息
        out.println("查询结果");
        out.println(res);
    }

    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);


//        response.setHeader("content-type", "text/html;charset=UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        BufferedReader res = request.getReader();
//        PrintWriter out = response.getWriter();
//
//        out.println(res.read());


    }
}