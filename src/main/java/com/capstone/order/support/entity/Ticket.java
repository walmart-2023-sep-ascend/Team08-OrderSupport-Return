package com.capstone.order.support.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Table;

@Document(collection ="tickets")
@AllArgsConstructor
@Data
public class Ticket {


    @Id
    private String id;

    private String number;

    private String description;
    private String order_number;
    private String photo_url;
    private String user_id;

    public Ticket() {
    }

}
