package edu.hes.e57.demo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

import com.google.common.collect.Lists;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.validation.Valid;

import edu.hes.e57.demo.domain.Auto;
import edu.hes.e57.demo.form.AutoGrid;
import edu.hes.e57.demo.service.AutoService;
import edu.hes.e57.demo.web.util.Message;
import edu.hes.e57.demo.web.util.UrlUtil;

@RequestMapping("/autos")
@Controller
public class AutoController {
    private final Logger logger = LoggerFactory.getLogger(AutoController.class);

    private AutoService autoService;
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel) {
        logger.info("Listing autos");

        List<Auto> autos = autoService.findAll();
        uiModel.addAttribute("autos", autos);

        logger.info("No. of autos: " + autos.size());

        return "autos/list";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model uiModel) {
        Auto auto = autoService.findById(id);
        uiModel.addAttribute("auto", auto);

        return "autos/show";
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.POST)
    public String update(@Valid Auto auto, BindingResult bindingResult, Model uiModel,
                         HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes,
                         Locale locale) {
        logger.info("Updating auto");
        
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("message", new Message("error",
                    messageSource.getMessage("auto_save_fail", new Object[]{}, locale)));
            uiModel.addAttribute("auto", auto);
            return "autos/update";
        }
        
        uiModel.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("success",
                messageSource.getMessage("auto_save_success", new Object[]{}, locale)));
        autoService.save(auto);
        
        return "redirect:/autos/" + UrlUtil.encodeUrlPathSegment(auto.getId().toString(),
                httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("auto", autoService.findById(id));
        return "autos/update";
    }
    
    @RequestMapping(params = "form", method = RequestMethod.POST)
    public String create(@Valid Auto auto, BindingResult bindingResult, Model uiModel, 
        HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, 
        Locale locale, @RequestParam(value="file", required=false) Part file) {
        logger.info("Creating auto");
        
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("message", new Message("error",
                    messageSource.getMessage("auto_save_fail", new Object[]{}, locale)));
            uiModel.addAttribute("auto", auto);
            return "autos/create";
        }
        
        uiModel.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("success",
                messageSource.getMessage("auto_save_success", new Object[]{}, locale)));

        logger.info("Auto id: " + auto.getId());

        // Process upload file
        if (file != null) {
            logger.info("File name: " + file.getName());
            logger.info("File size: " + file.getSize());
            logger.info("File content type: " + file.getContentType());
            byte[] fileContent = null;
            try {
                InputStream inputStream = file.getInputStream();
                if (inputStream == null) logger.info("File inputstream is null");
                fileContent = IOUtils.toByteArray(inputStream);
                auto.setPhoto(fileContent);
            } catch (IOException ex) {
                logger.error("Error saving uploaded file");
            }
            auto.setPhoto(fileContent);
        }
        
        autoService.save(auto);
        
        return "redirect:/autos/";
    }
    
    @RequestMapping(value = "/photo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public byte[] downloadPhoto(@PathVariable("id") Long id) {
        Auto auto = autoService.findById(id);

        if (auto.getPhoto() != null) {
            logger.info("Downloading photo for id: {} with size: {}", auto.getId(),
                    auto.getPhoto().length);
        }

        return auto.getPhoto();
    }

    //Protect createForm allowing access to it only to authenticated users. 
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model uiModel) {
        Auto auto = new Auto();
        uiModel.addAttribute("auto", auto);

        return "autos/create";
    }
    
    @ResponseBody
    @RequestMapping(value = "/listgrid", method = RequestMethod.GET, produces="application/json")
    public AutoGrid listGrid(@RequestParam(value = "page", required = false) Integer page,
                                @RequestParam(value = "rows", required = false) Integer rows,
                                @RequestParam(value = "sidx", required = false) String sortBy,
                                @RequestParam(value = "sord", required = false) String order) {

        logger.info("Listing autos for grid with page: {}, rows: {}", page, rows);
        logger.info("Listing autos for grid with sort: {}, order: {}", sortBy, order);

        // Order by
        Sort sort = null;
        String orderBy = sortBy;
        if (orderBy != null && orderBy.equals("model")) {
            orderBy = "model";
        }

        if (orderBy != null && order != null) {
            if (order.equals("desc")) {
                sort = new Sort(Sort.Direction.DESC, orderBy);
            } else
                sort = new Sort(Sort.Direction.ASC, orderBy);
        }

        PageRequest pageRequest = null;

        if (sort != null) {
            pageRequest = new PageRequest(page - 1, rows, sort);
        } else {
            pageRequest = new PageRequest(page - 1, rows);
        }

        Page<Auto> autoPage = autoService.findAllByPage(pageRequest);

        // Grid data returned as JSON
        AutoGrid autoGrid = new AutoGrid();

        autoGrid.setCurrentPage(autoPage.getNumber() + 1);
        autoGrid.setTotalPages(autoPage.getTotalPages());
        autoGrid.setTotalRecords(autoPage.getTotalElements());

        autoGrid.setAutoData(Lists.newArrayList(autoPage.iterator()));

        return autoGrid;
    }
   
    @Autowired
    public void setAutoService(AutoService autoService) {
        this.autoService = autoService;
    }
    
    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
