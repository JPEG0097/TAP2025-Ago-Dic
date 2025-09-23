public class MainSandwich {
    public static void main(String[] args) {
        SandwichBuilder builder = new SimpleSandwichBuilder();
        SandwichDirector director = new SandwichDirector(builder);
        director.construirSandwich();
        Sandwich sandwich = director.getSandwich();
        System.out.println("Sandwich construido: " + sandwich);
    }
}
