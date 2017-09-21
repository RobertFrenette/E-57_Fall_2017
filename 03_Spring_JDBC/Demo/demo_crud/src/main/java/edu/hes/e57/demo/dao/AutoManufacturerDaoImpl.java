package edu.hes.e57.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import edu.hes.e57.demo.crud.InsertAAuto;
import edu.hes.e57.demo.crud.UpdateAAuto;
import edu.hes.e57.demo.crud.DeleteAAuto;
import edu.hes.e57.demo.crud.SelectAutoById;
import edu.hes.e57.demo.crud.SelectAllAutosByManufacturerId;
import edu.hes.e57.demo.crud.SelectAllAutosByManufacturerName;
import edu.hes.e57.demo.crud.SelectAllManufacturers;
import edu.hes.e57.demo.crud.SelectAutoByModel;
import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.Manufacturer;

@Repository("autoManufacturerDao")
public class AutoManufacturerDaoImpl implements AutoManufacturerDao {
	private DataSource dataSource;
	private SelectAllManufacturers selectAllManufacturers; 
	private SelectAllAutosByManufacturerId selectAllAutosByManufacturerId;
	private SelectAllAutosByManufacturerName selectAllAutosByManufacturerName;
	private SelectAutoByModel selectAutoByModel;
	private SelectAutoById selectAutoById;
	private InsertAAuto insertAAuto;
	private UpdateAAuto updateAAuto;
	private DeleteAAuto deleteAAuto;
	
	@Override
	public List<Manufacturer> findAllManufacturers() {
		return selectAllManufacturers.execute();
	}
	
    @Override
    public List<Auto> findAllAutosByManufacturerId(Long manufacturerId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("manufacturer_id", manufacturerId);
        
        return selectAllAutosByManufacturerId.executeByNamedParam(paramMap);
    }    
    
    @Override
    public List<Auto> findAllAutosByManufacturerName(String manufacturerName) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("manufacturer_name", manufacturerName);
        
        return selectAllAutosByManufacturerName.executeByNamedParam(paramMap);
    }
    
    @Override
    public List<Auto> findAutoByModel(String model) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("model", model);
        
        return selectAutoByModel.executeByNamedParam(paramMap);
    }
    
    @Override
    public List<Auto> findAutoById(Long id) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);
        
        return selectAutoById.executeByNamedParam(paramMap);
    } 
	
    @Override
    public void insertAuto(Auto auto) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("manufacturer_id", auto.getManufacturerId());
        paramMap.put("model", auto.getModel());
        paramMap.put("year", auto.getYear());
        paramMap.put("msrp", auto.getMsrp());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        insertAAuto.updateByNamedParam(paramMap, keyHolder);

        auto.setId(keyHolder.getKey().longValue());
    }   
    
    @Override
    public void updateAuto(Auto auto) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("manufacturer_id", auto.getManufacturerId());
        paramMap.put("model", auto.getModel());
        paramMap.put("year", auto.getYear());
        paramMap.put("msrp", auto.getMsrp());
        paramMap.put("id", auto.getId());

        updateAAuto.updateByNamedParam(paramMap);
    }   
    
    @Override
    public void deleteAuto(Long id) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", id);

        deleteAAuto.updateByNamedParam(paramMap);
    }   
    
    @Resource(name="dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllManufacturers = new SelectAllManufacturers(dataSource);
        this.selectAllAutosByManufacturerId = new SelectAllAutosByManufacturerId(dataSource);
        this.selectAllAutosByManufacturerName = new SelectAllAutosByManufacturerName(dataSource);
        this.selectAutoByModel = new SelectAutoByModel(dataSource);
        this.selectAutoById = new SelectAutoById(dataSource);
        this.insertAAuto = new InsertAAuto(dataSource);
        this.updateAAuto = new UpdateAAuto(dataSource);
        this.deleteAAuto = new DeleteAAuto(dataSource);
    }
    
    public DataSource getDataSource() {
        return dataSource;
    }
}
