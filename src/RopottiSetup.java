
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
public class RopottiSetup {
    static int statusCheck = 0;
    public static JDA ropotti;  
    public static String tokenRopotti = "tokenhere";
    public static String prefix = "+";
    public static String msgRopotti = "DefaultRopotti";
    public static String[] quotet = new String[10000];
    public static int quoteCounter;
    public static String ropottiStatus;
    public static Paint ropottiStatusColor;
    
    //Botin "luonti"
    public static void botSetup() throws LoginException{
        ropotti = new JDABuilder(AccountType.BOT).setToken(tokenRopotti).build();
        ropotti.addEventListener(new CommandsRopotti());
        ropotti.getPresence().setStatus(OnlineStatus.OFFLINE);
        quoteCounter = 0;
    }
    
    //STATUKSEN VAIHTO ONLINE/OFFLINE + LBL TEKSTIN JA VÄRIN VAIHTO
    public static void botStatus(){
        if(statusCheck == 0){
            ropotti.getPresence().setStatus(OnlineStatus.ONLINE);
            ropottiStatus = "ONLINE";
            ropottiStatusColor = Color.GREEN;
            statusCheck = 1;
            System.out.println(statusCheck + "ONLINE");
        }
        else {
            ropotti.getPresence().setStatus(OnlineStatus.OFFLINE);
            ropottiStatus = "OFFLINE";
            ropottiStatusColor = Color.RED;
            statusCheck = 0;
            System.out.println(statusCheck + "OFFLINE");
        }                
    }  
}
