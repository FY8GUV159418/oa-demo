package com.buba.system.controller;

import com.alibaba.fastjson.JSON;
import com.buba.system.pojo.LoginLog;
import com.buba.system.service.Impl.LoginLogServiceImpl;
import com.buba.system.service.LoginLogService;
import com.buba.utils.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/LoginLogServlet")
public class LoginLogServlet extends BaseServlet {
    LoginLogService loginLogService = new LoginLogServiceImpl();
    @Override
    public void doRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String flag = req.getParameter("flag");
        if ("select".equals(flag)){
            this.selLog(req,resp);
        }
    }

    //查询登录日志
    private void selLog(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, String> param = getParam(req);
        List<LoginLog> list =  loginLogService.selLog(param);
        resp.getWriter().write(JSON.toJSONString(list));
    }
}
