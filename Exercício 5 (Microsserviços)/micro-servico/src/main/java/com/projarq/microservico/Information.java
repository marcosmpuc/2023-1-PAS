package com.projarq.microservico;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Information {
    private String moeda;
    private BigDecimal quantidade;
    private BigDecimal valor;
    private LocalDateTime dataHora;

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Information moeda(String moeda) {
        this.moeda = moeda;
        return this;
    }

    public Information quantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public Information valor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public Information dataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
        return this;
    }
}
