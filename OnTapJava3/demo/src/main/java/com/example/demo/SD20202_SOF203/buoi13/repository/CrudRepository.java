package com.example.demo.SD20202_SOF203.buoi13.repository;

import com.example.demo.SD20202_SOF203.buoi13.model.Sach;

import java.util.ArrayList;


public interface CrudRepository <T, ID>{
    Boolean create(T entity);

    Boolean update(T entity);

    Boolean deleteByID(ID id);

    T getByID(ID id);

    ArrayList<T> getAll();

}
