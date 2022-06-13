package com.fmi.demo.exposition.ICommand;

import com.fmi.demo.exposition.exceptions.CustomErrorHandler;


public interface ICommand <T> {
    String save(T body);
    String update(T body, String id);
    void delete(String id);
}
