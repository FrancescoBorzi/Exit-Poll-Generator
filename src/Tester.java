// just to test

public class Tester
{
    public static void main(String args[]) throws CloneNotSupportedException
    {
        // reale schema elettorale
        VotesHandler realVotingScheme = VotesHandler.makeRealPopulation();
        
        // popolazione reale
        Population realPop = new Population(realVotingScheme);
        
        // campione della popolazione reale
        Sample s = new Sample(realPop, 100000);
        
        System.out.println("***** STAMPO LO SCHEMA ELETTORALE REALE: *****\n");
        realPop.printVotingScheme();
        System.out.println("***** FINE SCHEMA ELETTORALE REALE *****\n");
                
        System.out.println("***** STAMPO EXIT POLL: *****\n");
        realPop.printVotingScheme();
        System.out.println("***** FINE EXIT POLL *****\n");
    }
}