package com.baizhi.service.impl;

import com.baizhi.dao.PersonDao;
import com.baizhi.entity.Category;
import com.baizhi.entity.Person;
import com.baizhi.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gjp06 on 17.5.21.
 */
@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {


    @Resource(name = "personDao")
    private PersonDao dao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Person> queryAllPerson() {
        return dao.selectPerson(new Person());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Person queryPerson(Person person) {
        List<Person> people = dao.selectPerson(person);
        if (people == null || people.size() < 1) return null;
        return people.get(0);
    }

    @Override
    public int modifyPerson(Person person) {
        return dao.updatePerson(person);
    }

    @Override
    public int addPerson(Person person) {
        return dao.insertPerson(person);
    }

    @Override
    public int removePerson(Person person) {
        return dao.deletePerson(person);
    }

    @Override
    public List<Category> queryCate() {
        return dao.selectCate();
    }
}
