package com.buba.sysfun.controller;

import com.alibaba.fastjson.JSON;
import com.buba.login.pojo.UserInfo;
import com.buba.sysfun.pojo.SysFun;

import com.buba.sysfun.pojo.SysFunS;
import com.buba.sysfun.service.Impl.SysFunServiceImpl;
import com.buba.sysfun.service.SysFunService;
import com.buba.utils.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/SysFunServlet")
public class SysFunServlet extends BaseServlet {
    SysFunService sysfunService = new SysFunServiceImpl();
    @Override
    public void doRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String flag =req.getParameter("flag");
        //查询
        if("selSysfun".equals(flag)){
            this.selSysfun(req,resp);;
        }
        if ("selectAll".equals(flag)){
            this.selectAll(req,resp);
        }
        if ("selectRole".equals(flag)){
            this.selectRole(req,resp);
        }
    }

    /**
     * 默认分配权限
     * @param req
     * @param resp
     * @throws IOException
     */
    private void selectRole(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, String> param = getParam(req);
        List<SysFun> list = sysfunService.selectRole(param);
        resp.getWriter().write(JSON.toJSONString(list));
    }

    /**
     * 查询所有的菜单信息
     * @param req
     * @param resp
     * @throws IOException
     */
    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<SysFunS>list = sysfunService.selectAll();
        resp.getWriter().write(JSON.toJSONString(list));
    }

    /**
     * 查询菜单
     * @param req
     * @param resp
     * @throws IOException
     */
    private void selSysfun(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        UserInfo user = (UserInfo) session.getAttribute("login");
        List<SysFun> list = sysfunService.selSysfun(user);
        resp.getWriter().write(JSON.toJSONString(list));
    }

}
