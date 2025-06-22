package insight;

public class District implements PopulationNode{

    private String name;
    private  int population;

    public District(String name, int population) {
        this.name = name;
        this.population = population;
    }


    @Override
    public int computePopulation() {
        return population;
    }
}