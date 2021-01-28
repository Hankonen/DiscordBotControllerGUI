import java.io.File;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;



/**
 *
 * @author Hankonen
 */
public class KuvatusSetup {
    static int statusCheck = 0;
    public static JDA kuvatus;  
    public static String tokenKuvatus = "tokenhere";
    public static String prefix = "!";
    public static String msgKuvatus = "DefaultKuvatus";
    public static String kuvatusStatus;
    public static Paint kuvatusStatusColor;
    
    //Määritellään polku kuville ja talletetaan niiden nimet listOfFilesiin
    public static final File folder = new File("F:\\pathtodirectory");
    public static File[] listOfFiles = folder.listFiles();
    
    //Botin "luonti"
    public static void botSetup() throws LoginException{
        kuvatus = new JDABuilder(AccountType.BOT).setToken(tokenKuvatus).build();
        kuvatus.addEventListener(new CommandsKuvatus());
        kuvatus.getPresence().setStatus(OnlineStatus.OFFLINE);
                            
    }
    
    //STATUKSEN VAIHTO ONLINE/OFFLINE + LBL TEKSTIN JA VÄRIN VAIHTO
    public static void botStatus(){
        if(statusCheck == 0){
            kuvatus.getPresence().setStatus(OnlineStatus.ONLINE);
            statusCheck = 1;
            kuvatusStatus = "ONLINE";
            kuvatusStatusColor =  Color.GREEN;
            System.out.println(statusCheck + "ONLINE");
            
        }
        else if (statusCheck == 1){
            kuvatus.getPresence().setStatus(OnlineStatus.OFFLINE);
            statusCheck = 0;
            kuvatusStatus = "OFFLINE";
            kuvatusStatusColor =  Color.RED;
            System.out.println(statusCheck + "OFFLINE");
        }                
    }  
}