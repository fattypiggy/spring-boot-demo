package com.example.Controller;

import com.example.Entity.Girl;
import com.example.Repository.GirlReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by William Jing on 7/18/2017.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlReposotory girlReposotory;


    /**
     * Get ALL girls
     *
     * @return
     */
    @GetMapping("/girls")
    public List<Girl> getList() {
        return girlReposotory.findAll();
    }

    /**
     * Add a new girl
     *
     * @return
     */
    @PostMapping("/girls")
    public Girl addGirl(@Valid Girl girl, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.err.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return girlReposotory.save(girl);
    }

    @PutMapping("/girl/{id}")
    public Girl updateGirl(@PathVariable Integer id,
                           @RequestParam Integer age,
                           @RequestParam String cupSize) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlReposotory.save(girl);
    }

    @GetMapping("/girl/{id}")
    public Girl getGirl(@PathVariable Integer id) {
        return girlReposotory.findOne(id);
    }
}
