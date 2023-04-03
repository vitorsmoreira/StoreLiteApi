package br.com.fiap.api.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
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

    public Produto(Long id, String nome, String fabricante, double peso, double volume, double preco, double frete,
            int quantidade, LocalDateTime vencimento) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.peso = peso;
        this.volume = volume;
        this.preco = preco;
        this.frete = frete;
        this.quantidade = quantidade;
        this.vencimento = vencimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDateTime vencimento) {
        this.vencimento = vencimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", fabricante=" + fabricante + 
        ", peso=" + peso + ", volume=" + volume + 
        ", preco=" + preco + ", frete=" + frete + ", quantidade=" + quantidade + 
        ", vencimento=" + vencimento + "]";
    }

}