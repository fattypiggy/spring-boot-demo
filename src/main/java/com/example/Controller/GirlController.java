package com.example.Controller;

import com.example.Entity.Girl;
import com.example.Entity.Result;
import com.example.Repository.GirlRepository;
import com.example.Service.GirlService;
import com.example.Util.GirlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private GirlRepository girlRepository;


    @Autowired
    private GirlService girlService;

    private static final Logger logger = LoggerFactory.getLogger(GirlController.class);

    /**
     * Get ALL girls
     *
     * @return
     */
    @GetMapping("/girls")
    public List<Girl> getList() {
        return girlRepository.findAll();
    }

    /**
     * Add a new girl
     *
     * @return
     */
    @PostMapping("/girls")
    public Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.err.println(bindingResult.getFieldError().getDefaultMessage());
            return GirlUtils.error(-1,bindingResult.getFieldError().getDefaultMessage());
//            return null;
        }
        return GirlUtils.success(girlRepository.save(girl));
    }

    @PutMapping("/girl/{id}")
    public Girl updateGirl(@PathVariable Integer id,
                           @RequestParam Integer age,
                           @RequestParam String cupSize) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlRepository.save(girl);
    }

    @GetMapping("/girl/{id}")
    public Girl getGirl(@PathVariable Integer id) {
        return girlRepository.findOne(id);
    }

    @GetMapping("/girls/age/{age}")
    public List<Girl> getListByAge(@PathVariable Integer age) {
        return girlRepository.findByAge(age);
    }

    @DeleteMapping("/girl/{id}")
    public void deleteGirl(@PathVariable Integer id) {
        girlRepository.delete(id);
    }

    @GetMapping("/girl/{id}/age")
    public void getAge(@PathVariable Integer id) throws Exception {
        girlService.getAge(id);
    }
}
