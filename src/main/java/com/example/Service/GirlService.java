package com.example.Service;

import com.example.Entity.Girl;
import com.example.Exception.GirlException;
import com.example.Repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by William Jing on 7/19/2017.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();

        if (age < 10) {
            throw new GirlException(100, "你还是小学生吧");
        } else if (age >= 10 && age <= 16) {
            throw new GirlException(101, "你应该是初中生吧");
        }

//        else 加钱
    }
}
