package com.buba.personnel.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 关于分页的封装类
 * @param <T>
 */
@Data
public class Pagination<T> {

    private int page; //当前页
    private int limit; //每页条数
    private long total; //总页数
    private long count; //总条数
    private int index; //sql语句中limit 的第一个参数
    //查询条件
    private Map<String, String> param;
    //当前页的数据
    private List<T> list;

    public Pagination(){
        this(1);
    }

    public Pagination(int page) {
        this(page,5);
    }

    public Pagination(int page, int limit) {
        this.page = page;
        this.limit = limit;
        this.index = (page - 1) * limit;
    }

    /**
     * 添加总条数
     * @param count
     */
    public void setCount(long count){
        this.count = count;
        if (count % limit == 0 ){
            this.total = count / limit;
        }else {
            this.total = (count / limit) + 1;
        }
    }
}
