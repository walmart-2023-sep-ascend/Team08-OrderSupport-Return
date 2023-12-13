package com.capstone.order.support.service;

import com.capstone.order.support.model.TicketBean;

import java.util.List;

public interface SupportService {

    public String createTicket(TicketBean ticket);

    public List<TicketBean> findAll();

    public TicketBean findByNumber(String number);

}
