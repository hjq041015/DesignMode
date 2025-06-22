package insight;

import java.util.ArrayList;
import java.util.List;

public class Province implements PopulationNode {

    private final String name;
    List<PopulationNode> cities = new ArrayList<>();

    public Province(String name) {
        this.name = name;
    }

    public void addCity(City city) {
        this.cities.add(city);
    }

    @Override
    public int computePopulation() {
        return cities.stream().mapToInt(PopulationNode::computePopulation).sum();
    }
}