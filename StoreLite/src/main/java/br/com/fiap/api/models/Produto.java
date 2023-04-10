package br.com.fiap.api.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String fabricante;

    @NotNull
    private double peso;

    private double volume;

    @NotNull
    private double preco;

    private double frete;

    @NotNull
    private int quantidade;

    @NotNull
    private LocalDateTime vencimento;

    @ManyToOne
    private Mercado mercado;

}