// just to test

public class Tester
{
    public static void main(String args[])
    {
        // Dichiaro lo schema elettorale
        VotingScheme v;
        
        // Aggiungo coalizioni e partiti (in questo caso gia' pronti)
        v = VotingScheme.makeRealVotingScheme();

        // Genero la popolazione
        v.makePopulation();
        
        // Creo il campione per effettuare l'exit poll
        v.makeSample(10000);
        
        // Stampo i risultati
        v.print();
    }
}