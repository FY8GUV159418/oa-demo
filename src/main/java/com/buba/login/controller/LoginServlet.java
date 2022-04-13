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
import java.util.Map;

/**
 * 登录
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends BaseServlet {
    LoginService loginService = new LoginServiceImpl();
    //查询
    @Override
    public void doRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Map<String, String> param = getParam(req);
        UserInfo userInfo = loginService.login(param);
        if (userInfo==null){
            resp.getWriter().write("2");
        }else {
            resp.getWriter().write("3");
            HttpSession session =req.getSession();
            session.setAttribute("login",userInfo);
        }

//
//        //验证码输入是否正确
//        String code = req.getParameter("code");
//        //与正确的验证码进行比较
//        HttpSession session = req.getSession();
//        String checkedCode = (String) session.getAttribute("code");
//        //equalsIgnoreCase 忽略大小写进行比较
//        if(!checkedCode.equalsIgnoreCase(code)){
//            //终止程序，返回页面
//            resp.getWriter().write(JSON.toJSONString(new Message(0,"验证码输入错误")));
//           return;
//        }
//        //比较账号
    }
}
