public class SimpleSandwichBuilder implements SandwichBuilder {
    private Sandwich sandwich;

    public SimpleSandwichBuilder() {
        this.sandwich = new Sandwich();
    }

    @Override
    public void buildBread() {
        sandwich.setBread("Integral");
    }

    @Override
    public void buildMeat() {
        sandwich.setMeat("Pollo");
    }

    @Override
    public void buildCheese() {
        sandwich.setCheese("Queso Manchego");
    }

    @Override
    public void buildVegetables() {
        sandwich.setVegetables("Lechuga, Tomate");
    }

    @Override
    public Sandwich getSandwich() {
        return this.sandwich;
    }
}
