package kz.tezdet.lessons.springjdbc.dao;

import kz.tezdet.lessons.springjdbc.domains.User;
import kz.tezdet.lessons.springjdbc.jdbc.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insertData(User user) {

        String sql = "INSERT INTO user (first_name, last_name, gender, city) VALUES(?,?,?,?)" ;
        jdbcTemplate.update(sql, new Object[]{user.getFirstName(),user.getLastName(),
        user.getGender(), user.getCity()});
    }

    @Override
    public List<User> getUserList() {
        List<User> userList = new ArrayList<User>() ;

        String sql = "SELECT * FROM user" ;
        userList = jdbcTemplate.query(sql, new UserRowMapper()) ;
        return userList;
    }

    @Override
    public void updateData(User user) {
        String sql = "UPDATE user set first_name=?, last_name=?, gender=?, city=? WHERE user_id=?" ;
        jdbcTemplate.update(sql, new Object[]{user.getFirstName(), user.getLastName(),
        user.getGender(), user.getCity(), user.getUserId()}) ;
    }

    @Override
    public void deleteData(String id) {
        String sql = "DELETE FROM user WHERE user_id = " + id ;
        jdbcTemplate.update(sql) ;
    }

    @Override
    public User getUser(String id) {
        List<User> userList = new ArrayList<User>();

        String sql = "SELECT * FROM user WHERE user_id = " + id ;
        userList = jdbcTemplate.query(sql, new UserRowMapper()) ;
        User user = userList.get(0) ;

        return user ;
    }
}
