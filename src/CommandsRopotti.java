
import java.util.Random;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;



/**
 *
 * @author Hankonen
 */
public class CommandsRopotti extends ListenerAdapter {
    
    public static String[] lastMsg = new String[10];
    public static int lastMsgCounter = 0;
    
    Random rand = new Random();
    int randInt;
    
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent eventti){
        
        String[] args = eventti.getMessage().getContentRaw().split("\\s+");
        
        //huono tyyli mutta tallennetaan aina viesti väliaikasesti lastMsg taulukkoon
        for(int i = 0; i < args.length; i++) {
            if (i == 0) lastMsg[lastMsgCounter] = args[i];
            else lastMsg[lastMsgCounter] = lastMsg[lastMsgCounter] + " " + args[i]; 
        }
        
        //tallennetaan edellinen viesti quotet taulukkoon 
        if (args[0].equalsIgnoreCase(RopottiSetup.prefix + "quotelast")){
            eventti.getChannel().sendMessage(RopottiSetup.msgRopotti).queue();
            RopottiSetup.quotet[RopottiSetup.quoteCounter] =  lastMsg[lastMsgCounter - 1];
            System.out.println(args[0]);
            //System.out.println(RopottiSetup.quotet[RopottiSetup.quoteCounter] + "hah");
            //System.out.println(lastMsg[lastMsgCounter - 1] + "huh");
            RopottiSetup.quoteCounter++;
        }
        
        //lähettää serverille viestin jossa random quote quotet taulukosta
        if (args[0].equalsIgnoreCase(RopottiSetup.prefix + "randQuote")){                      
            randInt = rand.nextInt(RopottiSetup.quoteCounter); //quoteCounter toimii raja-arvona
            
            if (RopottiSetup.quotet[randInt] != null)eventti.getChannel().sendMessage(RopottiSetup.quotet[randInt]).queue();
            else System.out.println("quotea ei oo olemassa");             
        }
        
        //päivitetään countteria
        if (lastMsgCounter == 9) lastMsgCounter = 0;
        else lastMsgCounter++;
    }
}
