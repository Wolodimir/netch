package com.team.netch.progress;

import com.team.netch.brief.Brief;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private Brief userBrief;

    private Boolean brief = false;
    private Boolean technicalTask = false;
    private Boolean prototype = false;
    private Boolean siteModel = false;
    private Boolean frontBack = false;
    private Boolean testing = false;
    private Boolean payment = false;
    private Boolean result = false;


    public Progress(Brief userBrief, Boolean brief, Boolean technicalTask,
                    Boolean prototype, Boolean siteModel, Boolean frontBack,
                    Boolean testing, Boolean payment, Boolean result) {
        this.userBrief = userBrief;
        this.brief = brief;
        this.technicalTask = technicalTask;
        this.prototype = prototype;
        this.siteModel = siteModel;
        this.frontBack = frontBack;
        this.testing = testing;
        this.payment = payment;
        this.result = result;
    }

    public Progress(Long id, Brief userBrief, Boolean brief, Boolean technicalTask,
                    Boolean prototype, Boolean siteModel, Boolean frontBack,
                    Boolean testing, Boolean payment, Boolean result) {
        this.id = id;
        this.userBrief = userBrief;
        this.brief = brief;
        this.technicalTask = technicalTask;
        this.prototype = prototype;
        this.siteModel = siteModel;
        this.frontBack = frontBack;
        this.testing = testing;
        this.payment = payment;
        this.result = result;
    }

    public Progress() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brief getUserBrief() {
        return userBrief;
    }

    public void setUserBrief(Brief userBrief) {
        this.userBrief = userBrief;
    }

    public Boolean getBrief() {
        return brief;
    }

    public void setBrief(Boolean brief) {
        this.brief = brief;
    }

    public Boolean getTechnicalTask() {
        return technicalTask;
    }

    public void setTechnicalTask(Boolean technicalTask) {
        this.technicalTask = technicalTask;
    }

    public Boolean getPrototype() {
        return prototype;
    }

    public void setPrototype(Boolean prototype) {
        this.prototype = prototype;
    }

    public Boolean getSiteModel() {
        return siteModel;
    }

    public void setSiteModel(Boolean siteModel) {
        this.siteModel = siteModel;
    }

    public Boolean getFrontBack() {
        return frontBack;
    }

    public void setFrontBack(Boolean frontBack) {
        this.frontBack = frontBack;
    }

    public Boolean getTesting() {
        return testing;
    }

    public void setTesting(Boolean testing) {
        this.testing = testing;
    }

    public Boolean getPayment() {
        return payment;
    }

    public void setPayment(Boolean payment) {
        this.payment = payment;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
