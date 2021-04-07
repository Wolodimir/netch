package com.team.netch.progress;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TT - Technical task
    private Boolean brief;
    private Boolean customerTt;
    private Boolean commandTt;
    private Boolean technicalTask;
    private Boolean siteStructure;
    private Boolean designPrototype;
    private Boolean prototype;
    private Boolean completeSiteModel;
    private Boolean siteModel;
    private Boolean layout;
    private Boolean backend;




}
