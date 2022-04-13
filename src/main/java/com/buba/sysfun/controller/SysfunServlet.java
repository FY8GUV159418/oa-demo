package com.buba.sysfun.controller;

import com.alibaba.fastjson.JSON;
import com.buba.sysfun.pojo.Sysfun;
import com.buba.sysfun.service.Impl.SysfunServiceImpl;
import com.buba.sysfun.service.SysfunService;
import com.buba.utils.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SysfunServlet")
public class SysfunServlet extends BaseServlet {
    SysfunService sysfunService = new SysfunServiceImpl();
    @Override
    public void doRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String flag =req.getParameter("flag");
        //查询
        if("selsysfun".equals(flag)){
            this.selSysfun(req,resp);
        }
    }

    /**
     * 查询菜单
     * @param req
     * @param resp
     * @throws IOException
     */
    private void selSysfun(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //调用业务层查询菜单方法
        List<Sysfun> list = sysfunService.selSysfun();
//        for (Sysfun lst: list){
//            System.out.println(lst);
//        }
        //将结果集返回给浏览器
        resp.getWriter().write(JSON.toJSONString(list));
    }


}
