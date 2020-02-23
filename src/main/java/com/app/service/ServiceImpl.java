package com.app.service;

import com.app.model.Campaign;
import com.app.repo.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceImpl implements CampaignService {

    @Autowired
    CampaignRepository campaignRepository;

    @Override
    public List<Campaign> getAllCampaign() {
        return (List<Campaign>) campaignRepository.findAll();
    }


    @Override
    public Campaign getCampaignById(int id) {
        return campaignRepository.findById(id).get();
    }

    @Override
    public void saveCampaign(Campaign campaign) {

        campaignRepository.save(campaign);
    }

    @Override
    public void deleteCampaign(int id) {

        campaignRepository.deleteById(id);
    }

}
