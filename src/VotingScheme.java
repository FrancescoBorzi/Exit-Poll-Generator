/*
 *  Utilizzo:
 *  1) Viene creato passando due int: (numero di coalizioni, numero partiti)
 *  2) Partiti e coalizioni vengono aggiunti con i metodi regParty() e regCoalition()
 *  3) Una volta aggiunti tutte le coalizioni e i partite, makePopulation() genera la popolazione
 *  4) Con makeSample(n) viene generato un campione di n elementi
 */

import java.util.Random;

public class VotingScheme
{
    private Coalition[] coalitions_db;
    private Party[] parties_db;
    private int pIndex, cIndex, cAmount, pAmount, samplesCoalitionAverage, samplesCoalitionAveragePercentage, samplesCoalitionDevSt;
    private int population[];
    private Sample samples[];
    
    public VotingScheme(int cAmount, int pAmount)
    {
        this.cAmount = cAmount;
        this.pAmount = pAmount;
        
        coalitions_db = new Coalition[cAmount];
        parties_db = new Party[pAmount];
        
        pIndex = cIndex = 0;
    }
    
    /* GET Methods */
    
    public int getCoalitionsAmount()        { return cAmount; }
    public int getPartiesAmount()           { return pAmount; }
    public Party getParty(int id)           { return parties_db[id]; }
    public Coalition getCoalition(int id)   { return coalitions_db[id]; }
    
    public int getTotVotes()
    {
        int tot = 0;
        
        for (int i = 0; i < cAmount; i ++)
            tot += coalitions_db[i].getVotes();
        
        return tot;
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
    
    public float getPercentage(int a[], int x)
    {
        float tot = 0;
        float percentage;
        
        for (int i = 0; i < cIndex; i++)
            tot += a[i];
        
        percentage = a[x] * 100f / tot;
        
        return percentage;
    }
    
    public int[] getCoalitionVotes()
    {
        int cVotes[] = new int[coalitions_db.length];
        
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
    
    /* Initialization methods */
    
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
    
    // Genera la popolazione, da utilizzare dopo aver inserito tutte le coalizioni e i partiti
    public void makePopulation()
    {
        population = new int[getTotVotes()];
        int pVotes[] = getPartyVotes();
        int k = 0, max = 0;
        
        for (int i = 0; i < pVotes.length; i++)
        {
            max += pVotes[i];
            for(; k < max; k++)
                population[k] = i;
        }
    }
    
    // Crea un campione di dimensione size
    public Sample makeSample(int size)
    {
        Sample newsample = new Sample(size);
        Random rand = new Random();
        
        for (int i = 0; i < size; i ++)
            newsample.sample[i] = population[rand.nextInt(population.length)];
        
        newsample.sample_cdb = new int[coalitions_db.length];
        newsample.sample_pdb = new int[parties_db.length];
                
        for (int i = 0; i < size; i++)
        {
            newsample.sample_pdb[newsample.sample[i]]++;
            newsample.sample_cdb[parties_db[newsample.sample[i]].getCoalition()]++;
        }
        
        return newsample;
    }
    
    // Crea un array contenente n campioni, ciascuno di dimensione size
    public void makeSamplesArray(int n, int size)
    {
        samples = new Sample[n];
        
        for (int i = 0; i < n; i++)
            samples[i] = makeSample(size);
    }
    
    // Calcola media dei voti per la Coalizione id dei Campioni
    public void samplesCoalitionAverage(int id)
    {
        if (samples == null)
        {
            samplesCoalitionAverage = 0;
            samplesCoalitionAveragePercentage = 0;
            return;
        }
        
        for (int i = 0; i < samples.length; i++)
        {
            samplesCoalitionAverage += samples[i].sample_cdb[id];
            samplesCoalitionAveragePercentage += getPercentage(samples[i].sample_cdb, id);
        }
        
        samplesCoalitionAverage /= samples.length;
        samplesCoalitionAveragePercentage /= samples.length;
    }
    
    // aggiorna i voti delle coalizioni in base ai voti dei partiti che le compongono
    public void updateCoalitionVotes()
    {
        for (int i = 0; i < coalitions_db.length; i++)
            coalitions_db[i].updateVotes();
    }
    
    // Crea un risultato elettorale reale, riferendosi alle elezioni siciliane 2012
    public static VotingScheme makeRealVotingScheme()
    {
        VotingScheme realPopulation = new VotingScheme(10, 20);
        
        /* Crocetta */
        Coalition Crocetta = new Coalition(realPopulation, "Crocetta", "img", 4);
        Party CrocettaPresidente = new Party(realPopulation, Crocetta, "Crocetta Presidente", "img", 257274);
        Party PD = new Party(realPopulation, Crocetta, "Partito Democratico", "img", 207827);
        Party UDC = new Party(realPopulation, Crocetta, "Unione Di Centro", "img", 118346);
        Party UnioneConsumatori = new Party(realPopulation, Crocetta, "Unione Consumatori", "img", 100);
        
        /* Musumeci */
        Coalition Musumeci = new Coalition(realPopulation, "Musumeci", "img", 4);
        Party PDL = new Party(realPopulation, Musumeci, "Popolo Della Liberta'", "img", 247351);
        Party CantierePopolare = new Party(realPopulation, Musumeci, "Cantiere Popolare", "img", 112169);
        Party MusumeciPresidente = new Party(realPopulation, Musumeci, "Musumeci Presidente", "img", 107379);
        Party AlleanzaDiCentro = new Party(realPopulation, Musumeci, "Alleanza Di Centro", "img", 5017);
        
        /* M5S */
        Coalition MovimentoCinqueStelle = new Coalition(realPopulation, "Movimento 5 Stelle", "img", 1);
        Party M5S = new Party(realPopulation, MovimentoCinqueStelle, "Movimento 5 Stelle", "img", 285202);
        
        /* Micciche' */
        Coalition Micciche = new Coalition(realPopulation, "Micciche", "img", 4);
        Party MPA = new Party(realPopulation, Micciche, "Movimento Per le Autonomie", "img", 182737);
        Party GrandeSud = new Party(realPopulation, Micciche, "Grande Sud", "img", 115444);
        Party FLI = new Party(realPopulation, Micciche, "Futuro e Libertà", "img", 83891);
        Party PPA = new Party(realPopulation, Micciche, "Piazza Pulita", "img", 959);
        
        /* Libera Sicilia */
        Coalition Marano = new Coalition(realPopulation, "Marano", "img", 2);
        Party SinistraUnita = new Party(realPopulation, Marano, "FdS-SEL-Verdi", "img", 67738);
        Party IdV = new Party(realPopulation, Marano, "Italia Dei Valori", "img", 58753);
        
        /* Forconi */
        Coalition MarianoFerro = new Coalition(realPopulation, "Popolo dei Forconi", "img", 1);
        Party Forconi = new Party(realPopulation, MarianoFerro, "Popolo dei Forconi", "img", 23965);
        
        /* Cateno De Luca */
        Coalition CatenoDeLuca = new Coalition(realPopulation, "Cateno De Luca", "img", 1);
        Party RivoluzioneSiciliana = new Party(realPopulation, CatenoDeLuca, "RivoluzioneSiciliana", "img", 22422);
        
        /* Sturzo */
        Coalition Sturzo = new Coalition(realPopulation, "Sturzo", "img", 1);
        Party SturzoPresidente = new Party(realPopulation, Sturzo, "Sturzo Presidente", "img", 14929);
        
        /* PCL */
        Coalition PartitoComunistaDeiLavoratori = new Coalition(realPopulation, "Partito Comunista Dei Lavoratori", "img", 1);
        Party PCL = new Party(realPopulation, PartitoComunistaDeiLavoratori, "PartitoComunistaDeiLavoratori", "img", 2031);
        
        /* Pinsone */
        Coalition Pinsone = new Coalition(realPopulation, "Pinsone", "img", 1);
        Party Voi = new Party(realPopulation, Pinsone, "Voi", "img", 2278);
        
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
    
    // stampa la Coalizione id e confronta tutti i campioni
    public void printCoalitionByID(int id)
    {
        if (samples == null)
            return;
        
        System.out.println("\nCoalizione: \""+coalitions_db[id].getName()+"\" | VOTI REALI: "+coalitions_db[id].getVotes()+"| PERCENTUALE REALE -> "+coalitions_db[id].getPercentage()+"%\n\n");
        
        for (int i = 0; i < samples.length; i++)
        {
            System.out.println("Campione["+i+"]: VOTI = "+samples[i].sample_cdb[id]+" PERCENTUALE = "+(int)getPercentage(samples[i].sample_cdb, id)+"%");
        }
        
        samplesCoalitionAverage(id);
        
        System.out.println("\nMedia: VOTI = "+samplesCoalitionAverage+" PERCENTUALE = "+samplesCoalitionAveragePercentage+"%");
        
        System.out.println("\n");
    }
    
    // stampa le Coalizioni e i Partiti dello schema elettorale, con i loro relativi voti e percentuali
    /*public void print()
    {
        for (int i = 0; i < cAmount; i++)
        {
            System.out.println("\nCoalizione: \""+coalitions_db[i].getName()+"\" |VOTI: "+coalitions_db[i].getVotes()+"| REALE -> "+coalitions_db[i].getPercentage()+"% |EXIT POLL -> "+getPercentage(sample_cdb, i)+"% (voti campione: "+sample_cdb[i]+" | dim campione: "+sample.length+")\n");
            Party parties[] = coalitions_db[i].getParties();
            System.out.println("Liste:");
            for (int j = 0; j < parties.length; j++)
                System.out.println("Partito: "+parties[j].getName()+" |VOTI: "+parties[j].getVotes()+"| REALE -> "+parties[j].getPercentage()+"% |EXIT POLL: -> "+getPercentage(sample_pdb, j)+"% (voti campione: "+sample_pdb[i]+" | dim campione: "+sample.length+")");
            
            System.out.println("-------------------------------------------------");
        }
    }*/
}
