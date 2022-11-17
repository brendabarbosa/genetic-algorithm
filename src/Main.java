public class Main {
    public static void main(String[] args) {

        int totalGenerations = 20;
        Population population = new Population();
        population.initiate();
        population.evaluate();
        System.out.println("Initial population");
        population.showPopulation();
        population.removeMembers();

        for(int contGeneration = 1; contGeneration <= totalGenerations; contGeneration++){
            Population newPopulation = new Population();
            newPopulation.generateNewPopulation(population);
            System.out.println("New population");
            newPopulation.showPopulation();

            newPopulation.mutate();
            System.out.println("Mutation");
            newPopulation.showPopulation();

            newPopulation.decode();
            newPopulation.evaluate();

            System.out.println("Population result - generation "+contGeneration);
            newPopulation.showPopulation();

            newPopulation.removeMembers();
            population = newPopulation;
       }
        population.showResult();
    }
}