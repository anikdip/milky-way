package com.app.controller;

import com.app.model.Campaign;
import com.app.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CampaignController {
    @Autowired
    CampaignService campaignService;


    @GetMapping("/")
    public ModelAndView welcomePage(){

        return new ModelAndView("wc");
    }

    // Course List

    @GetMapping("/list")
    public ModelAndView courseList(){

        ModelAndView model =new ModelAndView();
        List<Campaign> campaignList = campaignService.getAllCampaign();
        model.addObject("campaignLists",campaignList);
        model.setViewName("campaign_list");
        return model;
    }


    // add course Page

    @GetMapping("/addCampaignPage")
    public ModelAndView addCampaignPage(){

        Campaign campaign = new Campaign();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("campaignForm",campaign);
        modelAndView.setViewName("campaign-form");
        return modelAndView;
    }


    // add Course

    @PostMapping("/addCampaign")
    public ModelAndView addCourse(@ModelAttribute("campaignForm") Campaign campaign){

        campaignService.saveCampaign(campaign);
        return new ModelAndView("redirect:/list");
    }

    // Delete List

    @GetMapping("/deleteCampaign/{c_id}")
    public ModelAndView deleteCampaign(@PathVariable("c_id") int id){

        campaignService.deleteCampaign(id);
        return new ModelAndView("redirect:/list");
    }

    // Update List

    @GetMapping("/updateCampaign/{c_id}")
    public ModelAndView updateCampaign(@PathVariable("c_id") int id){

        ModelAndView model =new ModelAndView();
        Campaign campaign = campaignService.getCampaignById(id);
        System.out.println(campaign.getCampaign_title());
        model.addObject("campaignForm", campaign);
        model.setViewName("campaign-form");

        return model;
    }
}
