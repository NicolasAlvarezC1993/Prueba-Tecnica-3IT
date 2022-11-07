package com.example.poll.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "poll")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("Model Poll")
public class Poll implements Serializable{

    @Id
    @Column(name = "email")
    @ApiModelProperty(value = "Corresponde al email de la encuesta", required = true)
    private String email;

    @Column(name = "type_music")
    @ApiModelProperty(value = "Corresponde al tipo de musica de la encuesta", required = true)
    private Long typeMusic;
    
}
