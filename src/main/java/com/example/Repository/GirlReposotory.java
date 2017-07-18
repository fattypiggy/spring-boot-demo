package com.example.Repository;

import com.example.Entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by William Jing on 7/18/2017.
 */
public interface GirlReposotory extends JpaRepository<Girl, Integer> {
}
