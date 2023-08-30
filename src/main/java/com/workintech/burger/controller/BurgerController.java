package com.workintech.burger.controller;

import com.workintech.burger.dao.BurgerDao;
import com.workintech.burger.entity.BreadType;
import com.workintech.burger.entity.Burger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {
    private BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @PostMapping("/")
    private Burger save(@RequestBody Burger burger) {
        return burgerDao.save(burger);

    }

    @GetMapping("/")
    List<Burger> findAll() {
        return burgerDao.findAll();
    }


    @GetMapping("/{id}")
    public Burger find(@PathVariable int id) {
        return burgerDao.findById(id);
    }
    @GetMapping("/findByPrice/{price}")
    public List<Burger>findByPrice(@PathVariable int price){
        return burgerDao.findByPrice(price);
    }
    @GetMapping("/findByBreadType/{breadType}")
    public List<Burger>findByBreadType(@PathVariable String breadType){
        return burgerDao.findByBreadType(breadType);
    }
    @GetMapping("/findByContent/{content}")
    public List<Burger>findByContent(@PathVariable String content){
        return burgerDao.findByContent(content);
    }
    @GetMapping("/")
    public Burger update(@RequestBody Burger burger){
        return burgerDao.update(burger);
    }
    @DeleteMapping("/{id}")
    public Burger update(@PathVariable int id){
        Burger burger = find(id);
        return burgerDao.delete(burger);
    }
}
