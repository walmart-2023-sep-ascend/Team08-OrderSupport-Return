package com.capstone.order.support.controller;


import com.capstone.order.support.entity.Ticket;
import com.capstone.order.support.model.TicketBean;
import com.capstone.order.support.repository.TicketDetails;
import com.capstone.order.support.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    SupportService supportService;

    @Autowired
    TicketDetails repo;



    @PostMapping("/create")
    public String createTicket(@RequestBody TicketBean ticket) {
        //repo.save(ticket);
        try {
            return "Ticket # " + supportService.createTicket(ticket) + " successfully Created ";
        }
        catch(Exception e )
        {
            return "exception occured while creating ticket "+e;
        }
    }

    @GetMapping("/find")
    public List<TicketBean> getAllTickets() {
        //return repo.findAll();
        return supportService.findAll();
    }

   @GetMapping("/find/{Number}")
   public TicketBean findTicket(@PathVariable("Number") String number){
        return supportService.findByNumber(number);
    }


}
