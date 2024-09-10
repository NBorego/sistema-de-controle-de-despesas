package src.controller;

import src.model.Usuario;
import src.utils.ArquivoUtil;
import src.utils.CriptografiaUtil;
import java.util.List;
import java.util.ArrayList;

/**
 * Controlador para gerenciar usuários.
 */
public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();
    private static final String ARQUIVO_USUARIOS = "usuarios.txt";

    public void adicionarUsuario(Usuario usuario) {
        usuario.setSenha(CriptografiaUtil.criptografarSenha(usuario.getSenha()));
        usuarios.add(usuario);
        ArquivoUtil.salvarUsuarios(usuarios, ARQUIVO_USUARIOS);
    }

    public void listarUsuarios() {
        usuarios = ArquivoUtil.carregarUsuarios(ARQUIVO_USUARIOS);
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getLogin());
        }
    }
}
