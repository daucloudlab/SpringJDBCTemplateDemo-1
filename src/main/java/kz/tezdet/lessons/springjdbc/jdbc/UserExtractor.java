package kz.tezdet.lessons.springjdbc.jdbc;


import kz.tezdet.lessons.springjdbc.domains.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserExtractor implements ResultSetExtractor<User>{
    @Override
    public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        User user = new User() ;
        user.setUserId(resultSet.getInt("user_id"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setGender(resultSet.getString("gender"));
        user.setCity(resultSet.getString("city"));

        return user ;
    }
}
