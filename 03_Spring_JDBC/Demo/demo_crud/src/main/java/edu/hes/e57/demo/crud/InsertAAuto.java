package edu.hes.e57.demo.crud;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

/**
 * This Class inserts a new Auto into the DB. 
 */
public class InsertAAuto extends SqlUpdate {
    private static final String SQL_INSERT_AUTO = 
            "insert into auto (manufacturer_id, model, year, msrp) values (:manufacturer_id, :model, :year, :msrp)";

    public InsertAAuto(DataSource dataSource) {
        super(dataSource, SQL_INSERT_AUTO);
        super.declareParameter(new SqlParameter("manufacturer_id", Types.INTEGER));
        super.declareParameter(new SqlParameter("model", Types.VARCHAR));
        super.declareParameter(new SqlParameter("year", Types.VARCHAR));
        super.declareParameter(new SqlParameter("msrp", Types.VARCHAR));
        super.setGeneratedKeysColumnNames(new String[] {"id"});
        super.setReturnGeneratedKeys(true);
    }
}
