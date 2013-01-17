import java.util.Random;

class Sample
{
    int people[];
    
    Sample(int[] population, int size)
    {
        people = new int[size];
        Random rand = new Random();
        
        for (int i = 0; i < size; i ++)
            people[i] = population[rand.nextInt(population.length)];
    }
}