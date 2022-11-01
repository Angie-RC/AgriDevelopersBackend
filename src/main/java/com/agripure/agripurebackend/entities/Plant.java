package com.agripure.agripurebackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="plants")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="image", nullable = false)
    private String image;
    @Column(name="saved", nullable = false)
    private Boolean saved;
}
