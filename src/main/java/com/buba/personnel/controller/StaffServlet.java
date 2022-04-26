package com.buba.personnel.controller;

import com.alibaba.fastjson.JSON;
import com.buba.personnel.pojo.Departinfo;
import com.buba.personnel.pojo.Pagination;
import com.buba.personnel.pojo.Staff;
import com.buba.personnel.service.DepartinfoService;
import com.buba.personnel.service.Impl.DepartinfoServiceImpl;
import com.buba.personnel.service.Impl.StaffServiceImpl;
import com.buba.personnel.service.StaffService;
import com.buba.utils.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/StaffServlet")
public class StaffServlet extends BaseServlet {
    StaffService staffService = new StaffServiceImpl();
    DepartinfoService departinfoService = new DepartinfoServiceImpl();
    @Override
    public void doRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String flag = req.getParameter("flag");
        if ("select".equals(flag)){//查询
            this.selStaff(req,resp);
        }
        if("insert".equals(flag)){//添加
            this.addStaff(req,resp);
        }
        if ("delete".equals(flag)){//删除
            this.delStaff(req,resp);
        }
        if ("update".equals(flag)){//修改
            this.upStaff(req,resp);
        }
    }

    /**
     * 修改
     * @param req
     * @param resp
     */
    private void upStaff(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取要修改的数据
        Map<String, String> param = getParam(req);
        int count = staffService.upStaff(param);
        //将获取的数据返会浏览器
        resp.getWriter().write(count+"");
    }

    /**
     * 删除
     * @param req
     * @param resp
     */
    private void delStaff(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ids = req.getParameter("ids");
        int count = staffService.delStaff(ids);
        resp.getWriter().write(JSON.toJSONString(count+""));
    }

    /**
     * 添加
     * @param req
     * @param resp
     */
    private void addStaff(HttpServletRequest req, HttpServletResponse resp) {
        //获取表单数据，
        Map<String, String> param = getParam(req);
        //将获取的数据传入到业务层
        staffService.addStaff(param);
    }

    /**
     * 查询员工
     * @param req
     * @param resp
     */
    private void selStaff(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取查询携带的参数，分页参数 查询添加参数
        Map<String, String> param = getParam(req);
        Map<String, Object> map = new HashMap<>();
        //分页工具类
        Pagination<Staff> pagination = new Pagination<>(Integer.parseInt(param.get("page")));
        pagination.setParam(param);
        //1、查询员工总条数
        pagination.setCount(staffService.selCount(pagination));
        //2、查询当前页的员工信息
        pagination.setList(staffService.selStaff(pagination));
        map.put("pagination",pagination);
        List<Departinfo> list = departinfoService.selDp();
        map.put("departList",list);
        //最后返回浏览器
        resp.getWriter().write(JSON.toJSONString(map));
    }
}
