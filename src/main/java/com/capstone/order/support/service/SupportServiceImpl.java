package com.capstone.order.support.service;

import com.capstone.order.support.entity.Ticket;
import com.capstone.order.support.model.TicketBean;
import com.capstone.order.support.repository.TicketDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class SupportServiceImpl implements SupportService {

    @Autowired
    private TicketDetails repo;
    Random random = new Random();


@Override
    public String createTicket(TicketBean ticketBean) {

        Ticket ticket = convertToTicketObj(ticketBean);
        ticket.setNumber("INC"+(10000+random.nextInt(9999)));
        repo.save(ticket);

        return ticket.getNumber();
    }


    private Ticket convertToTicketObj(TicketBean ticketBean) {
        Ticket ticket = new Ticket();
        ticket.setDescription(ticketBean.getDescription());
        ticket.setOrder_number(ticketBean.getOrder_number());
        ticket.setPhoto_url(ticketBean.getPhoto_url());
        //ticket.setUser_id(ticketBean.getUser_id());
        return ticket;
    }
    @Override
    public List<TicketBean> findAll() {
        List<Ticket> ticket = repo.findAll();
        List<TicketBean> resultObj = new ArrayList<>();
        if(ticket!=null && ticket.size()>0)
        {

            for(Ticket t : ticket) {
                resultObj.add( convertToTicketBean(t));
            }
        }
        return resultObj;


    }


 private TicketBean convertToTicketBean(Ticket ticket) {
         TicketBean tb = new TicketBean();
            tb.setTicketNum(ticket.getNumber());
            tb.setOrder_number(ticket.getOrder_number());
            tb.setPhoto_url(ticket.getPhoto_url());
            tb.setDescription(ticket.getDescription());
        return tb;

    }


    @Override
    public TicketBean findByNumber(String number) {
        Ticket ticket = repo.findByNumber(number);
        if(ticket!=null){
            return convertToTicketBean(ticket);
        }

        return null;
    }
}
