package com.zxr.medicalaid;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table LINK.
 */
public class Link {

    private Long id;
    private Integer uId;
    private String status;
    private String time;

    public Link() {
    }

    public Link(Long id) {
        this.id = id;
    }

    public Link(Long id, Integer uId, String status, String time) {
        this.id = id;
        this.uId = uId;
        this.status = status;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
