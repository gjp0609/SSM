package com.baizhi.dao;

import com.baizhi.entity.Category;
import com.baizhi.entity.Person;

import java.util.List;

/**
 * Created by gjp06 on 17.5.21.
 */
public interface PersonDao {
    public List<Person> selectPerson(Person person);

    public int insertPerson(Person person);

    public int deletePerson(Person person);

    public int updatePerson(Person person);

    public List<Category> selectCate();
}
