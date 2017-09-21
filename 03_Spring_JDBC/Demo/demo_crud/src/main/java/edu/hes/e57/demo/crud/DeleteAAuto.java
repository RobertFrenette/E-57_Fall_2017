package edu.hes.e57.demo.crud;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

/**
 * This Class deletes a specific Auto from the DB. 
 */
public class DeleteAAuto extends SqlUpdate {
    private static final String SQL_DELETE_AUTO = 
            "delete from auto where id=:id";

    public DeleteAAuto(DataSource dataSource) {
        super(dataSource, SQL_DELETE_AUTO);
        super.declareParameter(new SqlParameter("id", Types.INTEGER));
    }
}