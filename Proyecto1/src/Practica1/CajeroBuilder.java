package Practica1;

public class CajeroBuilder {
    private final String nombre;
    private final double saldoInicial;
    private final boolean aceptaDepositos;
    private final boolean aceptaRetiros;

    private CajeroBuilder(Builder builder) {
        this.nombre = builder.nombre;
        this.saldoInicial = builder.saldoInicial;
        this.aceptaDepositos = builder.aceptaDepositos;
        this.aceptaRetiros = builder.aceptaRetiros;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public boolean isAceptaDepositos() {
        return aceptaDepositos;
    }

    public boolean isAceptaRetiros() {
        return aceptaRetiros;
    }

    public static class Builder {
        private String nombre;
        private double saldoInicial;
        private boolean aceptaDepositos;
        private boolean aceptaRetiros;

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setSaldoInicial(double saldoInicial) {
            this.saldoInicial = saldoInicial;
            return this;
        }

        public Builder aceptarDepositos(boolean acepta) {
            this.aceptaDepositos = acepta;
            return this;
        }

        public Builder aceptarRetiros(boolean acepta) {
            this.aceptaRetiros = acepta;
            return this;
        }

        public CajeroBuilder build() {
            return new CajeroBuilder(this);
        }
    }
}
