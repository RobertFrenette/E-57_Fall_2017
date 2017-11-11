package edu.hes.e57.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.domain.Autos;
import edu.hes.e57.demo.service.AutoService;

@Controller
@RequestMapping(value="/auto")
public class AutoController {
    final Logger logger = LoggerFactory.getLogger(AutoController.class);

    @Autowired
    private AutoService autoService;

    @RequestMapping(value = "/listdata", method = RequestMethod.GET)
    @ResponseBody
    public Autos listData() {
        return new Autos(autoService.findAll());
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Auto findAutoById(@PathVariable Long id) {
        return autoService.findById(id);
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    @ResponseBody
    public Auto create(@RequestBody Auto auto) {
        logger.info("Creating auto: " + auto);
        autoService.save(auto);
        logger.info("Auto created successfully with info: " + auto);
        return auto;
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    @ResponseBody
    public void update(@RequestBody Auto auto,
                       @PathVariable Long id) {
        logger.info("Updating auto: " + auto);
        autoService.save(auto);
        logger.info("Auto updated successfully with info: " + auto);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        logger.info("Deleting auto with id: " + id);
        Auto auto = autoService.findById(id);
        autoService.delete(auto);
        logger.info("Auto deleted successfully");
    }
}
