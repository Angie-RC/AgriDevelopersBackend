package com.agripure.agripurebackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "plots_weather")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlotsWeather implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "wind", nullable = false)
    private Integer wind;
    @Column(name = "humidity", nullable = false)
    private Integer humidity;
    @Column(name = "pressure", nullable = false)
    private Long pressure;
    @Column(name = "thermal", nullable = false)
    private Integer thermal;
    @Column(name = "visibility", nullable = false)
    private Integer visibility;
    @Column(name = "dew_point", nullable = false)
    private Integer dewPoint;
}
