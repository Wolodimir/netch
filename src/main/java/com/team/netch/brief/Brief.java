package com.team.netch.brief;

import javax.persistence.*;

@Entity
public class Brief {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;

    @Column(columnDefinition = "text")
    private String goals;
    @Column(columnDefinition = "text")
    private String requirements;
    @Column(columnDefinition = "text")
    private String results;
    @Column(columnDefinition = "text")
    private String limitations;
    @Column(columnDefinition = "text")
    private String assumptions;
    private String kindOfActivity;
    private String design;
    private String site;
    private String products;
    private String services;
    private String logo;
    private String content;
    @Column(columnDefinition = "text")
    private String sections;
    private String createdAt;
    private Boolean status = true;

    public Brief(String name, String email, String phone, String goals, String requirements,
                 String results, String limitations, String assumptions, String kindOfActivity,
                 String design, String site, String products, String services, String logo,
                 String content, String sections, String createdAt) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.goals = goals;
        this.requirements = requirements;
        this.results = results;
        this.limitations = limitations;
        this.assumptions = assumptions;
        this.kindOfActivity = kindOfActivity;
        this.design = design;
        this.site = site;
        this.products = products;
        this.services = services;
        this.logo = logo;
        this.content = content;
        this.sections = sections;
        this.createdAt = createdAt;
    }

    public Brief(String name, String email, String phone, String goals, String requirements,
                 String results, String limitations, String assumptions, String kindOfActivity,
                 String design, String site, String products, String services, String logo,
                 String content, String sections, String createdAt, Boolean status) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.goals = goals;
        this.requirements = requirements;
        this.results = results;
        this.limitations = limitations;
        this.assumptions = assumptions;
        this.kindOfActivity = kindOfActivity;
        this.design = design;
        this.site = site;
        this.products = products;
        this.services = services;
        this.logo = logo;
        this.content = content;
        this.sections = sections;
        this.createdAt = createdAt;
        this.status = status;
    }

    public Brief(Long id, String name, String email, String phone, String goals,
                 String requirements, String results, String limitations, String assumptions,
                 String kindOfActivity, String design, String site, String products, String services,
                 String logo, String content, String sections, String createdAt, Boolean status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.goals = goals;
        this.requirements = requirements;
        this.results = results;
        this.limitations = limitations;
        this.assumptions = assumptions;
        this.kindOfActivity = kindOfActivity;
        this.design = design;
        this.site = site;
        this.products = products;
        this.services = services;
        this.logo = logo;
        this.content = content;
        this.sections = sections;
        this.createdAt = createdAt;
        this.status = status;
    }

    public Brief() {
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getLimitations() {
        return limitations;
    }

    public void setLimitations(String limitations) {
        this.limitations = limitations;
    }

    public String getAssumptions() {
        return assumptions;
    }

    public void setAssumptions(String assumptions) {
        this.assumptions = assumptions;
    }

    public String getKindOfActivity() {
        return kindOfActivity;
    }

    public void setKindOfActivity(String kindOfActivity) {
        this.kindOfActivity = kindOfActivity;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSections() {
        return sections;
    }

    public void setSections(String sections) {
        this.sections = sections;
    }
}
