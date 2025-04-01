package com.proyectoinregrador.bancosimpleecomarketteam3.model;

import jakarta.persistence.*;
import jdk.jfr.Description;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Audit_ticket")
public class Audit_ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "action", nullable = false)
    private String Action;

    @Column(name = "affected_record", nullable = false)
    private Integer affected_record;

    @Column(name = "details", nullable = false)
    private String details;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "ip", nullable = false)
    private String ip;

    public Audit_ticket() {
    }

    public Audit_ticket(Long id, String action, Integer affected_record, String details, Date date, String ip) {
        this.id = id;
        Action = action;
        this.affected_record = affected_record;
        this.details = details;
        this.date = date;
        this.ip = ip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }

    public Integer getAffected_record() {
        return affected_record;
    }

    public void setAffected_record(Integer affected_record) {
        this.affected_record = affected_record;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "Audit_ticket{" +
                "id=" + id +
                ", Action='" + Action + '\'' +
                ", affected_record=" + affected_record +
                ", details='" + details + '\'' +
                ", date=" + date +
                ", ip='" + ip + '\'' +
                '}';
    }
}