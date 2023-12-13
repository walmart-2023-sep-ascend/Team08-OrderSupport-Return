package com.capstone.order.support.service;

import com.capstone.order.support.model.TicketBean;
import com.capstone.order.support.repository.TicketDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.constraints.Null;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class SupportServiceImplTest {


    @Mock
     TicketDetails repo;

    @InjectMocks
    SupportServiceImpl supportService;




    @Test
    void createTicket() {
        Assertions.assertThrows(NullPointerException.class,()->supportService.createTicket(null));
        TicketBean bean = new TicketBean();
        bean.setDescription("abc");
        Assertions.assertDoesNotThrow(()->supportService.createTicket(bean));


    }

    @Test
    void findAll() {

    }

    @Test
    void findByNumber() {
    }
}