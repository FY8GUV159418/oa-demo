package com.buba.personnel.controller;

import com.alibaba.fastjson.JSON;
import com.buba.personnel.pojo.Departinfo;
import com.buba.personnel.service.DepartinfoService;
import com.buba.personnel.service.Impl.DepartinfoServiceImpl;
import com.buba.utils.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/DepartinfoServlet")
public class DepartinfoServlet extends BaseServlet {

    DepartinfoService departinfoService = new DepartinfoServiceImpl();

    @Override
    public void doRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String flag = req.getParameter("flag");
        if("insert".equals(flag)){//添加
            this.addDepartinfo(req,resp);
        }
        if ("select".equals(flag)){//查询
            this.selDp(req, resp);
        }
        if ("delete".equals(flag)){//删除
            this.delDp(req,resp);
        }
        if ("update".equals(flag)){//修改
            this.upDp(req,resp);
        }
    }

    /**
     * 修改
     * @param req
     * @param resp
     */
    private void upDp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取要修改的数据
        Map<String,String> param = getParam(req);
        int count = departinfoService.upDp(param);
        //返回浏览器页面
        resp.getWriter().write(count+"");
    }

    /**
     * 删除
     * @param req
     * @param resp
     */
    private void delDp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ids = req.getParameter("ids");
        int count = departinfoService.delup(ids);
        resp.getWriter().write(JSON.toJSONString(count+""));
    }

    /**
     * 查询方法
     * @param req
     * @param resp
     */
    private void selDp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Departinfo> list = departinfoService.selDp();
        resp.getWriter().write(JSON.toJSONString(list));
    }

    /**
     * 添加部门信息
     * @param req
     * @param resp
     */
    private void addDepartinfo(HttpServletRequest req, HttpServletResponse resp) {
        //获取添加表单数据 使用工具类 BaseServlet中的方法
        Map<String, String> param =getParam(req);
        //将要添加的部门信息传入业务层
        departinfoService.addDepartinfo(param);
    }
}
