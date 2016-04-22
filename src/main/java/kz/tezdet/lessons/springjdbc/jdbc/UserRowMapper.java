package kz.tezdet.lessons.springjdbc.jdbc;

import kz.tezdet.lessons.springjdbc.domains.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        UserExtractor userExtractor = new UserExtractor() ;
        User user = userExtractor.extractData(resultSet) ;

        return user;
    }
}
