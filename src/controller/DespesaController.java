package src.controller;

import src.model.Despesa;
import src.model.TipoDespesa;
import src.utils.ArquivoUtil;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para gerenciar despesas.
 */
public class DespesaController {
    private List<Despesa> despesas = new ArrayList<>();
    private static final String ARQUIVO_DESPESAS = "despesas.txt";

    public void adicionarDespesa(Despesa despesa) {
        despesas.add(despesa);
        ArquivoUtil.salvarDespesas(despesas, ARQUIVO_DESPESAS);
    }

    public void listarDespesas(String status, LocalDate inicio, LocalDate fim) {
        despesas = ArquivoUtil.carregarDespesas(ARQUIVO_DESPESAS);
        for (Despesa despesa : despesas) {
            if (despesa.isPaga() == "pago".equals(status) && despesa.getDataVencimento().isAfter(inicio.minusDays(1)) && despesa.getDataVencimento().isBefore(fim.plusDays(1))) {
                System.out.println(despesa.getDescricao() + " - " + despesa.getValor() + " - " + despesa.getDataVencimento() + " - " + (despesa.isPaga() ? "Pago" : "Em Aberto"));
            }
        }
    }

    public void anotarPagamento(String descricao, double valorPagamento, LocalDate dataPagamento) {
        despesas = ArquivoUtil.carregarDespesas(ARQUIVO_DESPESAS);
        for (Despesa despesa : despesas) {
            if (despesa.getDescricao().equals(descricao) && !despesa.isPaga()) {
                despesa.setPaga(true); // Marcar a despesa como paga
                // Aqui poderia ser adicionado o valor do pagamento, mas como simplificação, estamos apenas marcando como paga.
                ArquivoUtil.salvarDespesas(despesas, ARQUIVO_DESPESAS);
                System.out.println("Pagamento anotado com sucesso.");
                return;
            }
        }
        System.out.println("Despesa não encontrada ou já paga.");
    }
}
