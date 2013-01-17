import java.util.Random;

public class Sample
{
    private int people[];
    private VotesHandler voting_scheme;
    
    Sample(Population p, int size) throws CloneNotSupportedException
    {
        people = new int[size];
        int population[] = p.getPeopleVotes();
        Random rand = new Random();
        
        for (int i = 0; i < size; i ++)
            people[i] = population[rand.nextInt(population.length)];
        
        voting_scheme = VotesHandler.getCleanCopy(p.getVotingScheme());
        
        for (int i = 0; i < size; i++)
            voting_scheme.getParty(people[i]).incrVotes();
        
        voting_scheme.updateCoalitionVotes();
    }
    
    public VotesHandler getVotingScheme()   { return voting_scheme; }
    
    /* Strumenti DEBUG */
    
    public void printVotingScheme()
    {
        voting_scheme.print();
    }
}