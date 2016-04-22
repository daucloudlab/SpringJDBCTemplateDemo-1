package kz.tezdet.lessons.springjdbc.services;

import kz.tezdet.lessons.springjdbc.dao.UserDAO;
import kz.tezdet.lessons.springjdbc.domains.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO ;

    @Override
    public void insertData(User user) {
        userDAO.insertData(user);
    }

    @Override
    public List<User> getUserList() {
        return userDAO.getUserList();
    }

    @Override
    public void deleteData(String id) {
        userDAO.deleteData(id);
    }

    @Override
    public User getUser(String id) {
        return userDAO.getUser(id);
    }

    @Override
    public void updateData(User user) {
        userDAO.updateData(user);
    }
}
