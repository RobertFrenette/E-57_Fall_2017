package edu.hes.e57.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.service.AutoService;

@RequestMapping("/autos")
@Controller
public class AutoController {
    private final Logger logger = LoggerFactory.getLogger(AutoController.class);

    private AutoService autoService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel) {
        logger.info("Listing autos");

        List<Auto> autos = autoService.findAll();
        uiModel.addAttribute("autos", autos);

        logger.info("No. of autos: " + autos.size());

        return "autos/list";
    }
   
    @Autowired
    public void setAutotService(AutoService autoService) {
        this.autoService = autoService;
    }
}
