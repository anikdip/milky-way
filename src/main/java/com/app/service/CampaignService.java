package com.app.service;

import com.app.model.Campaign;

import java.util.List;

public interface CampaignService {
    List<Campaign> getAllCampaign();

    Campaign getCampaignById(int id);

    void saveCampaign(Campaign campaign);

    void deleteCampaign(int id);
}
