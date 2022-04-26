package com.buba.login.controller;

import com.alibaba.fastjson.JSON;
import com.buba.login.pojo.UserInfo;
import com.buba.login.service.Impl.LoginServiceImpl;
import com.buba.login.service.LoginService;
import com.buba.utils.BaseServlet;
import com.google.protobuf.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 登录
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends BaseServlet {
    //声明业务层
    LoginService loginService = new LoginServiceImpl();

    //查询
    @Override
    public void doRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //获取IP地址
        InetAddress ip = InetAddress.getLocalHost();
        String hostName = ip.getHostName();
        String hostAddress = ip.getHostAddress();

        //获取时间
        SimpleDateFormat sdf = new SimpleDateFormat();//格式化时间
        sdf.applyPattern("yyyy-MM-dd :hh:mm:ss");//a为am/pm的标记
        Date date = new Date();//获取当前时间
        String time = sdf.format(date);

        Map<String, String> paramMap = getParam(req);
        UserInfo userinfo = loginService.login(paramMap);
        //判断验证码

        HttpSession session = req.getSession();
        boolean equals = paramMap.get("code").equals(session.getAttribute("code"));

        //获取时间和ip
        paramMap.put("LoginUserIp",hostAddress);
        paramMap.put("LoginTime",time);
        if (equals){
            UserInfo userinfo1 = loginService.login(paramMap);
            req.getSession().setAttribute("login",userinfo1);
            paramMap.put("userId", userinfo1.getUserId());
            if (userinfo == null){
                paramMap.put("IfSuccess","0");
                paramMap.put("LoginDesc","登录失败");
                resp.getWriter().write("账号或密码错误");
                System.out.println("账号或密码错误");
            }else {
                paramMap.put("IfSuccess","1");
                paramMap.put("LoginDesc","登录成功");
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("login ",userinfo);
                resp.getWriter().write("3");
            }
        }else {
            paramMap.put("IfSuccess","0");
            paramMap.put("LoginDesc","登录失败");
            System.out.println("验证码错误");
            resp.getWriter().write("1");
        }
        loginService.addlogin(paramMap);
    }
}
