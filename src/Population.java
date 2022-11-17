import java.util.*;

public class Population {
    public Population() { }

    List<Member> members = new ArrayList<>();

    public void initiate(){
        members.add(new Member(3, 6));
        members.add(new Member(6, 4));
        members.add(new Member(3, 5));
        members.add(new Member(7, 0));
        members.add(new Member(3, 7));
        members.add(new Member(1, 6));
        members.add(new Member(1, 2));
        members.add(new Member(5, 4));
        members.add(new Member(6, 1));
        members.add(new Member(4, 2));
    }

    public void evaluate(){
        for (Member member: this.members) {
            member.calculateFitnessValue();
        }
        orderByFitnessValue();
    }

    public void removeMembers(){
        this.members = this.members.subList(0,Constants.POPULATIONCUTOFF);
    }

    public void  generateNewPopulation(Population population){
        Random rand = new Random();

        for(int contParentA = 0; contParentA < Constants.POPULATIONCUTOFF; contParentA++ ){
            for(int contParentB = contParentA; contParentB < Constants.POPULATIONCUTOFF; contParentB++){
                Member parentA = population.members.get(contParentA);
                Member parentB = population.members.get( rand.nextInt(4));
                members.add(crossover(parentA, parentB));
            }
        }
    }

    public void mutate(){
        Random rand = new Random();

        for(int i = 0; i < 5; i++){
            Member randomMember = members.get(rand.nextInt(10));
            randomMember.mutate();
        }
    }

    public void decode(){
        for (Member member: this.members) {
            member.decode();
        }
    }
    public void showResult(){
        System.out.println("X = "+this.members.get(0).getX());
        System.out.println("Y = "+this.members.get(0).getY());
        System.out.println("Fitness = "+this.members.get(0).getFitnessValue());
        System.out.println("Chromosome = "+this.members.get(0).getChromosome());
    }

    public void showPopulation(){
        for (Member member: this.members) {
            System.out.print("X = "+member.getX());
            System.out.print("\t\tY = "+member.getY());
            System.out.print("\t\tChromosome = "+member.getChromosome());
            System.out.println("\t\tFitness = "+member.getFitnessValue());
        }
        System.out.println();
    }


    private void orderByFitnessValue() {
        this.members.sort((value1, value2) -> Integer.compare(value2.getFitnessValue(), value1.getFitnessValue()));
    }
    private Member crossover(Member parentA, Member parentB){
        String geneA = parentA.getChromosome().substring(0,Constants.GENECUTOFF);
        String geneB = parentB.getChromosome().substring(Constants.GENECUTOFF);
        String newChromosome = geneA+geneB;
        return new Member(newChromosome);
    }
}
