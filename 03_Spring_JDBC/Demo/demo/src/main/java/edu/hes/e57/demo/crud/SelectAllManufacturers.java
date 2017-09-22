package edu.hes.e57.demo.crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.jdbc.object.MappingSqlQuery;

import edu.hes.e57.demo.domain.Manufacturer;

/**
 * This Class selects all Manufacturers from the DB. 
 */
public class SelectAllManufacturers extends MappingSqlQuery<Manufacturer> {
    private static final String SQL_SELECT_ALL_MANUFACTURER = "select id, name from manufacturer";

    public SelectAllManufacturers(DataSource dataSource) {
        super(dataSource, SQL_SELECT_ALL_MANUFACTURER);
    }

    protected Manufacturer mapRow(ResultSet rs, int rowNum) throws SQLException {
    		Manufacturer manufacturer = new Manufacturer();

    		manufacturer.setId(rs.getLong("id"));
    		manufacturer.setName(rs.getString("name"));

        return manufacturer;
    }
}