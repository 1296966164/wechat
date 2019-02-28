package com.hhuc.wechat.x.Service;
/**
 * @program: pt
 * @description: openid
 * @author: LYX
 * @create: 2019-02-22 17:10
 **/
import com.hhuc.wechat.x.DAO.Userexer;
import com.hhuc.wechat.x.Models.User;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Service/Qubi")
public class Qubi  extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(Qubi.class);


    /**
     * @see HttpServlet#HttpServlet()
     */
    public Qubi  () {
        super();
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

        User user =new User();
        user.setOpenid(openid);
//        Query q = new Query(data);
//
//        String res = q.query_openid();
        Userexer userexer = new Userexer(user);
        String res = userexer.queryOpenid();

        logger.info(res);
        // 记录error级别的信息
        out.println("查询结果");
        out.println(res);
    }
    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}