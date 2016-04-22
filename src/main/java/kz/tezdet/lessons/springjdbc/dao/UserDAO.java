package kz.tezdet.lessons.springjdbc.dao;


import kz.tezdet.lessons.springjdbc.domains.User;

import java.util.List;

public interface UserDAO {
    public void insertData(User user);
    public List<User> getUserList();
    public void updateData(User user);
    public void deleteData(String id);
    public User getUser(String id);
}
