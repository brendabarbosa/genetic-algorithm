import java.util.Random;

public class Member {
    private Integer x;
    private Integer y;
    private String chromosome;
    private Integer fitnessValue;
    public Integer getFitnessValue() {
        return fitnessValue;
    }

    public Member(Integer x, Integer y ) {
        this.x = x;
        this.y = y;
        this.chromosome = Constants.BINARYMAP.get(x) + Constants.BINARYMAP.get(y);
    }

    public Member(String chromosome) {
        this.chromosome = chromosome;
    }

    public Integer getX() {
        return this.x;
    }
    public Integer getY() {
        return this.y;
    }
    public String getChromosome() {
        return this.chromosome;
    }

    public void calculateFitnessValue(){
        Double result =  2 - Math.pow(x-2, 2) - Math.pow(y-3, 2);
        this.fitnessValue = result.intValue();
    }

    public void mutate(){
        Random rand = new Random();
        Integer randomGene = rand.nextInt(6);
        StringBuilder chromosome = new StringBuilder(this.chromosome);
        char newGene = chromosome.charAt(randomGene) == '0' ? '1' : '0';
        chromosome.setCharAt(randomGene, newGene);
        this.chromosome = chromosome.toString();
    }

    public void decode(){
        String alleleA = this.chromosome.substring(0,3);
        String alleleB = this.chromosome.substring(3);
        this.x = Integer.parseInt(alleleA,2);
        this.y = Integer.parseInt(alleleB,2);
    }
}
