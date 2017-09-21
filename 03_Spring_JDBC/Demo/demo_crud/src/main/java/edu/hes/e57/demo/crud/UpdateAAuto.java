package edu.hes.e57.demo.crud;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

/**
 * This Class updates an existing Auto in the DB
 * by Auto Id.  
 */
public class UpdateAAuto extends SqlUpdate {
    private static final String SQL_UPDATE_AUTO = 
            "update auto set manufacturer_id=:manufacturer_id, model=:model, year=:year, msrp=:msrp where id=:id";

    public UpdateAAuto(DataSource dataSource) {
        super(dataSource, SQL_UPDATE_AUTO);
        super.declareParameter(new SqlParameter("manufacturer_id", Types.INTEGER));
        super.declareParameter(new SqlParameter("model", Types.VARCHAR));
        super.declareParameter(new SqlParameter("year", Types.VARCHAR));
        super.declareParameter(new SqlParameter("msrp", Types.VARCHAR));
        super.declareParameter(new SqlParameter("id", Types.INTEGER));
    }
}