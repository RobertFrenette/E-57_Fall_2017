package edu.hes.e57.demo.crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.jdbc.object.MappingSqlQuery;

import edu.hes.e57.demo.domain.Auto;

/**
 * This Class selects all Autos from the DB. 
 */
public class SelectAllAutos  extends MappingSqlQuery<Auto> {
    private static final String SQL_SELECT_ALL_AUTO = "select id, manufacturer_id, model, year, msrp from auto";

    public SelectAllAutos(DataSource dataSource) {
        super(dataSource, SQL_SELECT_ALL_AUTO);
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