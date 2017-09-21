package edu.hes.e57.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import edu.hes.e57.demo.crud.SelectAllAutos;
import edu.hes.e57.demo.crud.SelectAllManufacturers;
import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.Manufacturer;

@Repository("autoManufacturerDao")
public class AutoManufacturerDaoImpl implements AutoManufacturerDao {
	private DataSource dataSource;
	private SelectAllManufacturers selectAllManufacturers; 
	private SelectAllAutos selectAllAutos;
	
	@Override
	public List<Manufacturer> findAllManufacturers() {
		return selectAllManufacturers.execute();
	}

	@Override
	public List<Auto> findAllAutos() {
		return selectAllAutos.execute();
	}

    @Resource(name="dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllManufacturers = new SelectAllManufacturers(dataSource);
        this.selectAllAutos = new SelectAllAutos(dataSource);
    }
    
    public DataSource getDataSource() {
        return dataSource;
    }
}
