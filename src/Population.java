/*
 *  Il costruttore prende in input uno schema elettorale (di tipo VotesHandler)
 *  crea un array di numerosità pari ai voti totali dei partiti che compongono lo schema elettorale
 *  ogni cella dell'array rappresenta una persona e il valore che contiene indica l'id del partito
 */

public class Population
{
    private int pop[];
    private VotesHandler voting_scheme;
    
    public Population(VotesHandler voting_scheme)
    {
        this.voting_scheme = voting_scheme;
        pop = new int[voting_scheme.getTotVotes()];
        int pVotes[] = voting_scheme.getPartyVotes();
        int k = 0, max = 0;
        
        for (int i = 0; i < pVotes.length; i++)
        {
            max += pVotes[i];
            for(; k < max; k++)
                pop[k] = i;
        }
    }
    
    public int[] getPeopleVotes()           { return pop; }
    public VotesHandler getVotingScheme()   { return voting_scheme; }
    
    /* Strumenti DEBUG */
    
    public void printVotingScheme()
    {
        voting_scheme.print();
    }  
}
