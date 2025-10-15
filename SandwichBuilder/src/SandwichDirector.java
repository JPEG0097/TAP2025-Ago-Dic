public class SandwichDirector {
    private SandwichBuilder builder;

    public SandwichDirector(SandwichBuilder builder) {
        this.builder = builder;
    }

    public void construirSandwich() {
        builder.buildBread();
        builder.buildMeat();
        builder.buildCheese();
        builder.buildVegetables();
    }

    public Sandwich getSandwich() {
        return builder.getSandwich();
    }
}
