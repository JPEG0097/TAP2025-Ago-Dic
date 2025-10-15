public class Personaje {
    private EstrategiaAtaque estrategia;

    public void setEstrategia(EstrategiaAtaque estrategia) {
        this.estrategia = estrategia;
    }

    public void atacar() {
        if (estrategia == null) {
            System.out.println("El personaje no tiene un método de ataque definido.");
        } else {
            estrategia.atacar();
        }
    }
}
