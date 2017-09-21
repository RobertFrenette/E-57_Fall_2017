package edu.hes.e57.demo.crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import edu.hes.e57.demo.domain.Auto;

/**
 * This Class selects a specific Auto from the DB
 * by Auto Model.  
 */
public class SelectAutoByModel extends MappingSqlQuery<Auto> {
    private static final String SQL_SELECT_AUTO_BY_MODEL = 
            "select id, manufacturer_id, model, year, msrp from auto where model = :model";

    public SelectAutoByModel(DataSource dataSource) {
        super(dataSource, SQL_SELECT_AUTO_BY_MODEL);
        super.declareParameter(new SqlParameter("model", Types.VARCHAR));
    }

    protected Auto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Auto auto = new Auto();

        auto.setId(rs.getLong("id"));
        auto.setManufacturerId(rs.getLong("manufacturer_id"));
        auto.setModel(rs.getString("model"));
        auto.setYear(rs.getString("year"));
        auto.setMsrp(rs.getString("msrp"));
        
        return auto;
    }
}
