public class Sandwich {
    private String bread;
    private String meat;
    private String cheese;
    private String vegetables;

    public void setBread(String bread) {
        this.bread = bread;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public void setVegetables(String vegetables) {
        this.vegetables = vegetables;
    }

    @Override
    public String toString() {
        return "Sandwich [bread=" + bread +
               ", meat=" + meat +
               ", cheese=" + cheese +
               ", vegetables=" + vegetables + "]";
    }
}
