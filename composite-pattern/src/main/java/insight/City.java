package insight;

import java.util.ArrayList;
import java.util.List;

public class City implements PopulationNode{

    private final String name;

    List<PopulationNode> districts = new ArrayList<>();

    public City(String name) {
        this.name = name;
    }

    public void addDistrict(District district) {
        this.districts.add(district);
    }

    @Override
    public int computePopulation() {
        return districts.stream().mapToInt(PopulationNode::computePopulation).sum();
    }
}