package com.baizhi.controller;

import com.baizhi.entity.Category;
import com.baizhi.entity.Person;
import com.baizhi.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by gjp06 on 17.5.22.
 */
@Controller("personController")
@RequestMapping("/person")
public class PersonController {
    @Resource(name = "personService")
    private PersonService service;

    @RequestMapping("queryAll")
    public String queryAll(Model model, HttpSession session) {
        List<Person> people = service.queryAllPerson();
        model.addAttribute("people", people);
        List<Category> categories = service.queryCate();
        session.setAttribute("cates", categories);
        return "list";
    }

    @RequestMapping("getDetail")
    public String getDetail(Person person, Model model) {
        Person p = service.queryPerson(person);
        model.addAttribute("person", p);
        return "detail";
    }

    @RequestMapping("toEdit")
    public String toEdit(Person person, Model model) {
        Person p = service.queryPerson(person);
        model.addAttribute("person", p);
        return "edit";
    }

    @RequestMapping("editPerson")
    public String editPerson(Person person) {
        System.out.println(person);
        int i = service.modifyPerson(person);
        return "redirect:/person/queryAll.do";
    }

    @RequestMapping("addPerson")
    public String addPerson(Person person) {
        int i = service.addPerson(person);
        return "redirect:/person/queryAll.do";
    }

    @RequestMapping("removePerson")
    public String removePerson(Person person) {
        int i = service.removePerson(person);
        return "redirect:/person/queryAll.do";
    }
}
