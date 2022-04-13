package com.buba.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet工具类：将get请求和post请求整合到一起
 */
public abstract class BaseServlet extends HttpServlet {
    /**
     * 自定义方法，doGet和doPost都将调用该方法,方法内容由子类去实现
     * @param req
     * @param resp
     */
    public abstract void doRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setHeader("Content-type","text/html;charset=UTF-8");
        doRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setHeader("Content-type","text/html;charset=UTF-8");
        doRequest(req, resp);
    }

    /**
     * 统一获取参数
     * @return
     */
    public Map<String,String> getParam(HttpServletRequest request){
        //获取浏览器传递的参数
        Map<String, String[]> map= request.getParameterMap();
        //创建一个新的容器
        Map<String, String> paramMap = new HashMap<>();
        //遍历将原本map的key，value导入到paramMap中，并将value的数组转为String
        map.forEach((key,value)->{
            paramMap.put(key,value[0]);
        });
        return paramMap;
    }
}

