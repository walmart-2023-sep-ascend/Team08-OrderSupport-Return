package com.capstone.order.support.controller;


import com.capstone.order.support.entity.Ticket;
import com.capstone.order.support.model.ResponseBean;
import com.capstone.order.support.model.TicketBean;
import com.capstone.order.support.repository.TicketDetails;
import com.capstone.order.support.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    SupportService supportService;

    @Autowired
    TicketDetails repo;


    @PostMapping(value="/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseBean createTicket(@RequestBody TicketBean ticket) {

        ResponseBean response = new ResponseBean();
        String ticketNumber = null;
        try {
            ticketNumber = supportService.createTicket(ticket);
            if(ticketNumber.isEmpty())
            {
                response.setTicketId("Could not create the ticket");
                response.setMessage("Please try again after sometime");


            }
            else
            {
                response.setTicketId(ticketNumber);
                response.setMessage("Ticket has been created Successfully!!");

            }

        }
        catch(Exception e )
        {
            response.setTicketId("Could not create the ticket");
            response.setMessage(e.toString());
        }
        return response;
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
