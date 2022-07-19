package com.sapient.xyz.bookingapp.theatre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theatre {
    //TODO: Try auto number
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;
}
