package com.otoil.ot_118_rest.data.mapper.datasource;

import com.otoil.ot_118_rest.data.entity.datasource.Type;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ageev Evgeny on 02.02.2018.
 */
public class DataSourceTypeMapper implements RowMapper<Type> {

    @Override
    public Type mapRow(ResultSet resultSet, int i) throws SQLException {
        Type type = new Type();
        type.setId(resultSet.getString("id"));
        type.setTypeId(resultSet.getString("identifier"));
        type.setName(resultSet.getString("name"));
        type.setDescription(resultSet.getString("description"));
        return type;
    }
}
