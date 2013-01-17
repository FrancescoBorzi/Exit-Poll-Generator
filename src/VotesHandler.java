/* 
 * Contiene tutte le Coalizioni e i Partiti con i loro relativi voti e genera le percentuali.
 */

public class VotesHandler implements Cloneable
{
    private Coalition[] coalitions_db;
    private Party[] parties_db;
    private int pIndex, cIndex;
    private int cAmount;
    private int pAmount;
    
    public VotesHandler(int cAmount, int pAmount)
    {
        this.cAmount = cAmount;
        this.pAmount = pAmount;
        
        coalitions_db = new Coalition[cAmount];
        parties_db = new Party[pAmount];
        
        pIndex = cIndex = 0; 
    }
    
    public int getCoalitionsAmount()    { return cAmount; }
    public int getPartiesAmount()       { return pAmount; }
    public Party getParty(int id)       { return parties_db[id]; }
    
    public int getTotVotes()
    {
        int tot = 0;
        
        for (int i = 0; i < cAmount; i ++)
            tot += coalitions_db[i].getVotes();
        
        return tot;
    }
    
    public int regCoalition(Coalition c)
    {
        if (cIndex >= coalitions_db.length)
            return -1;
        
        int index = cIndex;
        
        coalitions_db[index] = c;
        cIndex++;
        
        return index;
    }
    
    public int regParty(Party p)
    {
        if (pIndex >= parties_db.length)
            return -1;
        
        int index = pIndex;
        
        parties_db[index] = p;
        pIndex++;
        
        return index;
    }
    
    public float getPercentage(Coalition c)
    {
        float tot = 0;
        float percentage;
        
        for (int i = 0; i < cIndex; i++)
            tot += coalitions_db[i].getVotes();
        
        percentage = c.getVotes() * 100 / tot;
        
        return percentage;
    }
    
    public float getPercentage(Party p)
    {
        float tot = 0;
        float percentage;
        
        for (int i = 0; i < pIndex; i++)
            tot += parties_db[i].getVotes();
        
        percentage = p.getVotes() * 100 / tot;
        
        return percentage;
    }
    
    public int[] getCoalitionVotes()
    {
        int cVotes[] = new int[parties_db.length];
        
        for (int i = 0; i < cVotes.length; i++)
            cVotes[i] = coalitions_db[i].getVotes();
        
        return cVotes;
    }
    
    public int[] getPartyVotes()
    {
        int pVotes[] = new int[parties_db.length];
        
        for (int i = 0; i < pVotes.length; i++)
            pVotes[i] = parties_db[i].getVotes();
        
        return pVotes;
    }
    
    // aggiorna i voti delle coalizioni in base ai voti dei partiti che le compongono
    public void updateCoalitionVotes()
    {
        for (int i = 0; i < coalitions_db.length; i++)
            coalitions_db[i].updateVotes();
    }
    
    // Restituisce uno schema elettorale, privo di voti (che verranno riempiti dagli exit poll)
    public static VotesHandler getCleanCopy(VotesHandler v) throws CloneNotSupportedException
    {
        VotesHandler clean = (VotesHandler)(v.clone());
        
        // cleaning
        for (int i = 0; i < clean.pAmount; i++)
            clean.parties_db[i].setVotes(0);
        
        for (int i = 0; i < clean.cAmount; i++)
            clean.coalitions_db[i].setVotes(0);
        
        return clean;
    }
    
    // Crea un risultato elettorale reale, riferendosi alle elezioni siciliane 2012
    public static VotesHandler makeRealPopulation()
    {
        VotesHandler realPopulation = new VotesHandler(10, 20);
        
        /* Crocetta */
        Coalition Crocetta = new Coalition(realPopulation, "Crocetta", "img", 4);
        Party CrocettaPresidente = new Party(realPopulation, Crocetta, "Crocetta Presidente", "img", 257274);
        Party PD = new Party(realPopulation, Crocetta, "Partito Democratico", "img", 207827);
        Party UDC = new Party(realPopulation, Crocetta, "Unione Di Centro", "img", 118346);
        Party UnioneConsumatori = new Party(realPopulation, Crocetta, "Unione Consumatori", "img", 100);
        Crocetta.addParty(CrocettaPresidente);
        Crocetta.addParty(PD);
        Crocetta.addParty(UDC);
        Crocetta.addParty(UnioneConsumatori);
        
        /* Musumeci */
        Coalition Musumeci = new Coalition(realPopulation, "Musumeci", "img", 4);
        Party PDL = new Party(realPopulation, Musumeci, "Popolo Della Liberta'", "img", 247351);
        Party CantierePopolare = new Party(realPopulation, Musumeci, "Cantiere Popolare", "img", 112169);
        Party MusumeciPresidente = new Party(realPopulation, Musumeci, "Musumeci Presidente", "img", 107379);
        Party AlleanzaDiCentro = new Party(realPopulation, Musumeci, "Alleanza Di Centro", "img", 5017);
        Musumeci.addParty(PDL);
        Musumeci.addParty(CantierePopolare);
        Musumeci.addParty(MusumeciPresidente);
        Musumeci.addParty(AlleanzaDiCentro);
        
        /* M5S */
        Coalition MovimentoCinqueStelle = new Coalition(realPopulation, "Movimento 5 Stelle", "img", 1);
        Party M5S = new Party(realPopulation, MovimentoCinqueStelle, "Movimento 5 Stelle", "img", 285202);
        MovimentoCinqueStelle.addParty(M5S);
        
        /* Micciche' */
        Coalition Micciche = new Coalition(realPopulation, "Micciche", "img", 4);
        Party MPA = new Party(realPopulation, Micciche, "Movimento Per le Autonomie", "img", 182737);
        Party GrandeSud = new Party(realPopulation, Micciche, "Grande Sud", "img", 115444);
        Party FLI = new Party(realPopulation, Micciche, "Futuro e Libertà", "img", 83891);
        Party PPA = new Party(realPopulation, Micciche, "Piazza Pulita", "img", 959);
        Micciche.addParty(MPA);
        Micciche.addParty(GrandeSud);
        Micciche.addParty(FLI);
        Micciche.addParty(PPA);
        
        /* Libera Sicilia */
        Coalition Marano = new Coalition(realPopulation, "Marano", "img", 2);
        Party SinistraUnita = new Party(realPopulation, Marano, "FdS-SEL-Verdi", "img", 67738);
        Party IdV = new Party(realPopulation, Marano, "Italia Dei Valori", "img", 58753);
        Marano.addParty(SinistraUnita);
        Marano.addParty(IdV);
        
        /* Forconi */
        Coalition MarianoFerro = new Coalition(realPopulation, "Popolo dei Forconi", "img", 1);
        Party Forconi = new Party(realPopulation, MarianoFerro, "Popolo dei Forconi", "img", 23965);
        MarianoFerro.addParty(Forconi);
        
        /* Cateno De Luca */
        Coalition CatenoDeLuca = new Coalition(realPopulation, "Cateno De Luca", "img", 1);
        Party RivoluzioneSiciliana = new Party(realPopulation, CatenoDeLuca, "RivoluzioneSiciliana", "img", 22422);
        CatenoDeLuca.addParty(RivoluzioneSiciliana);
        
        /* Sturzo */
        Coalition Sturzo = new Coalition(realPopulation, "Sturzo", "img", 1);
        Party SturzoPresidente = new Party(realPopulation, Sturzo, "Sturzo Presidente", "img", 14929);
        Sturzo.addParty(SturzoPresidente);
        
        /* PCL */
        Coalition PartitoComunistaDeiLavoratori = new Coalition(realPopulation, "Partito Comunista Dei Lavoratori", "img", 1);
        Party PCL = new Party(realPopulation, PartitoComunistaDeiLavoratori, "PartitoComunistaDeiLavoratori", "img", 2031);
        PartitoComunistaDeiLavoratori.addParty(PCL);
        
        /* Pinsone */
        Coalition Pinsone = new Coalition(realPopulation, "Pinsone", "img", 1);
        Party Voi = new Party(realPopulation, Pinsone, "Voi", "img", 2278);
        Pinsone.addParty(Voi);
        
        return realPopulation;
    }
    
    /* Strumenti DEBUG */
    
    // resetta lo schema elettorale
    public void reset()
    {
        coalitions_db = new Coalition[cAmount];
        parties_db = new Party[pAmount];
        pIndex = cIndex = 0;
    }
    
    // stampa le Coalizioni e i Partiti dello schema elettorale, con i loro relativi voti e percentuali
    public void print()
    {
        for (int i = 0; i < cAmount; i++)
        {
            System.out.println("\nCoalizione: \""+coalitions_db[i].getName()+"\" Voti: "+coalitions_db[i].getVotes()+" -> "+coalitions_db[i].getPercentage()+"%\n");
            Party parties[] = coalitions_db[i].getParties();
            System.out.println("Liste:");
            for (int j = 0; j < parties.length; j++)
                System.out.println("Partito: "+parties[j].getName()+" Voti: "+parties[j].getVotes()+" -> "+parties[j].getPercentage()+"%");
            
            System.out.println("-------------------------------------------------");
        }
    }
}
