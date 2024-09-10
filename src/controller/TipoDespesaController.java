package src.controller;

import src.model.TipoDespesa;
import src.utils.ArquivoUtil;
import java.util.List;
import java.util.ArrayList;

/**
 * Controlador para gerenciar tipos de despesa.
 */
public class TipoDespesaController {
    private List<TipoDespesa> tiposDespesa = new ArrayList<>();
    private static final String ARQUIVO_TIPOS_DESPESA = "tipos_despesa.txt";

    public void adicionarTipoDespesa(TipoDespesa tipoDespesa) {
        tiposDespesa.add(tipoDespesa);
        ArquivoUtil.salvarTiposDespesa(tiposDespesa, ARQUIVO_TIPOS_DESPESA);
    }

    public void listarTiposDespesa() {
        tiposDespesa = ArquivoUtil.carregarTiposDespesa(ARQUIVO_TIPOS_DESPESA);
        for (TipoDespesa tipo : tiposDespesa) {
            System.out.println(tipo.getNome());
        }
    }
}
