package src.model;

import java.time.LocalDate;

/**
 * Representa uma despesa no sistema.
 */
public class Despesa {
    private String descricao;
    private double valor;
    private LocalDate dataVencimento;
    private TipoDespesa tipoDespesa;
    private boolean paga;

    // Construtor padrão
    public Despesa() {}

    // Construtor sobrecarregado
    public Despesa(String descricao, double valor, LocalDate dataVencimento, TipoDespesa tipoDespesa) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.tipoDespesa = tipoDespesa;
        this.paga = false;
    }

    // Getters e Setters
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public LocalDate getDataVencimento() { return dataVencimento; }
    public void setDataVencimento(LocalDate dataVencimento) { this.dataVencimento = dataVencimento; }

    public TipoDespesa getTipoDespesa() { return tipoDespesa; }
    public void setTipoDespesa(TipoDespesa tipoDespesa) { this.tipoDespesa = tipoDespesa; }

    public boolean isPaga() { return paga; }
    public void setPaga(boolean paga) { this.paga = paga; }
}
