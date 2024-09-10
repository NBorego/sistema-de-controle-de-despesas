package src.utils;

import src.model.Despesa;
import src.model.TipoDespesa;
import src.model.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Utilitário para operações de arquivo.
 */
public class ArquivoUtil {

    public static void salvarDespesas(List<Despesa> despesas, String caminho) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(despesas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Despesa> carregarDespesas(String caminho) {
        List<Despesa> despesas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            despesas = (List<Despesa>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return despesas;
    }

    public static void salvarTiposDespesa(List<TipoDespesa> tipos, String caminho) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(tipos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<TipoDespesa> carregarTiposDespesa(String caminho) {
        List<TipoDespesa> tipos = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            tipos = (List<TipoDespesa>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tipos;
    }

    public static void salvarUsuarios(List<Usuario> usuarios, String caminho) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Usuario> carregarUsuarios(String caminho) {
        List<Usuario> usuarios = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            usuarios = (List<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
