package com.baizhi.service;

import com.baizhi.entity.Category;
import com.baizhi.entity.Person;

import java.util.List;

/**
 * Created by gjp06 on 17.5.21.
 */
public interface PersonService {

    public List<Person> queryAllPerson();

    public Person queryPerson(Person person);

    public int modifyPerson(Person person);

    public int addPerson(Person person);

    public int removePerson(Person person);

    public List<Category> queryCate();

}
