package com.example.typemusic.model;

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
@Table(name = "type_music")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("Model TypeMusic")
public class TypeMusic implements Serializable{

    @Id
    @Column(name = "id")
    @ApiModelProperty(value = "Corresponde al identificador del tipo de musica", required = true)
    private Long id;

    @Column(name = "name")
    @ApiModelProperty(value = "Corresponde al nombre del tipo de musica", required = true)
    private String name;
    
}
