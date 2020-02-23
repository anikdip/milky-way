package com.app.repo;

import com.app.model.Campaign;
import org.springframework.data.repository.CrudRepository;

public interface CampaignRepository extends CrudRepository<Campaign,Integer> {
}
