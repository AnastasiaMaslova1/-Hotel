package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product { //моя сущность

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "DateStart")
    private Date dateStart;

    @Column(name = "DateEnd")
    private Date DateEnd;

    @Column(name = "NumberRoom")
    private Double NumberRoom;

    @Column(name = "NameClient")
    private String NameClient;

    @Column(name = "Needs")
    private String Needs;

    @Column(name = "Status")
    private int Status;

    public Long getId() {
        return id;
    }

}
