public class Main {
    public static void main(String[] args) {

        int totalGenerations = 5;
        Population population = new Population();
        population.initiate();
        population.evaluate();
        population.removeMembers();

        for(int contGeneration = 0; contGeneration <= totalGenerations; contGeneration++){
           Population newPopulation = new Population();
           newPopulation.generateNewPopulation(population);
           newPopulation.mutate();

           newPopulation.decode();
           newPopulation.evaluate();
           newPopulation.removeMembers();
           population = newPopulation;
       }
        population.showResult();
    }
}