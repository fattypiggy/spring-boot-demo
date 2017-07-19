package com.example.Util;

import com.example.Entity.Result;
import com.example.Repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by William Jing on 7/19/2017.
 */
public class GirlUtils {

    @Autowired
    private GirlRepository girlRepository;

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(1);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
