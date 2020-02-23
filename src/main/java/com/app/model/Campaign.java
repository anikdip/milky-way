package com.app.model;

import javax.persistence.*;

@Entity
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String campaign_title;

    private String message_body;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCampaign_title() {
        return campaign_title;
    }

    public void setCampaign_title(String campaign_title) {
        this.campaign_title = campaign_title;
    }

    public String getMessage_body() {
        return message_body;
    }

    public void setMessage_body(String message_body) {
        this.message_body = message_body;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CampaignEntity{" +
                "id=" + id +
                ", campaign_title='" + campaign_title + '\'' +
                ", message_body='" + message_body + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
