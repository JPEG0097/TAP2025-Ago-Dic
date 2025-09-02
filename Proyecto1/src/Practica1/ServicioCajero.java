package Practica1;

import java.util.ArrayList;
import java.util.List;

public class ServicioCajero {
    private List<Usuario> usuarios;
    private Usuario usuarioActual;

    public ServicioCajero() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("1234", "Juan", 1000.0));
        usuarios.add(new Usuario("5678", "Maria", 2500.0));
        usuarioActual = null;
    }

    public boolean autenticar(String pin) {
        for (Usuario usuario : usuarios) {
            if (usuario.getPin().equals(pin)) {
                usuarioActual = usuario;
                return true;
            }
        }
        return false;
    }

    public String getNombreUsuarioActual() {
        return (usuarioActual != null) ? usuarioActual.getNombre() : null;
    }

    public double consultarSaldo() {
        if (usuarioActual == null) throw new IllegalStateException("Usuario no autenticado");
        return usuarioActual.getSaldo();
    }

    public boolean retirar(double cantidad) {
        if (usuarioActual == null) throw new IllegalStateException("Usuario no autenticado");
        if (cantidad <= usuarioActual.getSaldo()) {
            usuarioActual.setSaldo(usuarioActual.getSaldo() - cantidad);
            return true;
        } else {
            return false;
        }
    }

    public void depositar(double cantidad) {
        if (usuarioActual == null) throw new IllegalStateException("Usuario no autenticado");
        usuarioActual.setSaldo(usuarioActual.getSaldo() + cantidad);
    }

    public void cerrarSesion() {
        usuarioActual = null;
    }
}
