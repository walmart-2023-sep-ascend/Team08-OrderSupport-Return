package com.capstone.order.support.repository;

import com.capstone.order.support.entity.Ticket;
import com.capstone.order.support.model.TicketBean;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface TicketDetails extends MongoRepository<Ticket, String> {

    @Query("{Number:?0}")
    Ticket findByNumber(String Number);
}
