public class Party
{
    private int id, coalition, votes;
    private String name;
    private String logo;
    private VotingScheme handler;
    
    public Party(VotingScheme handler, Coalition coalition, String name, String logo, int votes)
    {
        this.handler = handler;
        this.id = handler.regParty(this);
        this.coalition = coalition.getId();
        this.name = name;
        this.logo = logo;
        this.votes = votes;
        coalition.addParty(this);
    }
    
    public int getId()              { return id; }
    public int getCoalition()       { return coalition; }
    public int getVotes()           { return votes; }
    public String getName()         { return name; }
    public String getLogo()         { return logo; }
    public double getPercentage()    { return handler.getPercentage(this); }
    
    public void setVotes(int votes) { this.votes = votes; }
    public void incrVotes()         { votes++; }
}