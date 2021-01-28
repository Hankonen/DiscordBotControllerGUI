
import java.io.File;
import java.util.Random;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


/**
 *
 * @author Hankonen
 */
public class CommandsKuvatus extends ListenerAdapter {
    
    //polku kuville
    public static String pathToFile = "F:\\pathtodirectory";
    
    //randomnumbergeneraattori
    Random rand = new Random();
    int randInt;
    
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent eventti){
        String[] args = eventti.getMessage().getContentRaw().split("\\s+");
        
        
        
        if (args[0].equalsIgnoreCase(KuvatusSetup.prefix + "kuva")){
            //arpoo kuvan indeksin
            randInt = rand.nextInt(KuvatusSetup.listOfFiles.length);
            System.out.println(randInt);
            eventti.getChannel().sendMessage(KuvatusSetup.msgKuvatus).addFile(new File(pathToFile + KuvatusSetup.listOfFiles[randInt].getName())).queue();
            System.out.println("EVENT TOIMI");
            
        }
    }
}
