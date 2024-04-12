package br.edu.utfpr.todoapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity //Entidade gerenciada pelo JPA (pode ser persistida)
@Table(name = "tb_medicao") // Define o noma da tabel
@Data
public class Medicao {
    @ManyToOne
    private Sensor sensor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 
    
    @Column(nullable = false)
    private Float valor;

    @Column(nullable = false)
    private String data;

}
