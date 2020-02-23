package com.app.controller;

import com.app.model.Campaign;
import com.app.model.Recipient;
import com.app.model.RecipientCampaign;
import com.app.service.CampaignService;
import com.app.service.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RecipientController {
    @Autowired
    CampaignService campaignService;
    @Autowired
    RecipientService recipientService;

    @GetMapping("/recipientList")
    public ModelAndView recipientList(){

        ModelAndView model =new ModelAndView();
        List<RecipientCampaign> recipientCampaigns = recipientService.getAllRecipientCampaign();
        model.addObject("recipientLists",recipientCampaigns);
        model.setViewName("recipient_list");
        return model;
    }


    @GetMapping("/addRecipientPage")
    public ModelAndView addCampaignPage(){

        Recipient recipient = new Recipient();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recipientForm",recipient);
        modelAndView.setViewName("recipient-form");
        return modelAndView;
    }


    @PostMapping("/addRecipient")
    public ModelAndView addCourse(@ModelAttribute("recipientForm") Recipient recipient){

        recipientService.saveRecipient(recipient);
        return new ModelAndView("redirect:/recipientList");
    }


    @GetMapping("/deleteRecipient/{r_id}")
    public ModelAndView deleteRecipient(@PathVariable("r_id") int id){

        recipientService.deleteRecipient(id);
        return new ModelAndView("redirect:/recipientList");
    }


    @GetMapping("/updateRecipient/{r_id}")
    public ModelAndView updateRecipient(@PathVariable("r_id") int id){

        ModelAndView model =new ModelAndView();
        Recipient recipient = recipientService.getRecipientById(id);
        model.addObject("recipientForm", recipient);
        model.setViewName("recipient-form");

        return model;
    }
}
