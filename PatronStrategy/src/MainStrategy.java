public class MainStrategy {
    public static void main(String[] args) {
        Personaje heroe = new Personaje();

        heroe.setEstrategia(new AtaqueEspada());
        heroe.atacar();

        heroe.setEstrategia(new AtaqueArco());
        heroe.atacar();

        heroe.setEstrategia(new AtaqueMagia());
        heroe.atacar();
    }
}
