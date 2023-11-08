import komendy.Co;
import komendy.Spam;
import komendy.Witaj;
import komendy.Test;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {

    private static final String TOKEN = "";

    public static void main(String[] args) {
        JDA jda = JDABuilder.createDefault(TOKEN).setActivity(Activity.playing("Jak wkurzyć Eresona")).enableIntents(GatewayIntent.MESSAGE_CONTENT).build();


        if (jda.getStatus() == JDA.Status.CONNECTED) {
            System.out.println("Bot connected!");
        } else {
            System.out.println("Bot failed to connect");
        }
        //jda.addEventListener(new Test());
        //IDLE - zaraz wracam, ONLINE - online,
        jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);

        try {
            jda.addEventListener(new Witaj());
            //jda.addEventListener(new Test());
            //lepiej tego nie odkomentowywać chyba że chcesz dostać spam po pierwszej wiadmości
            //jda.addEventListener(new Spam());
        } catch (Exception e) {
            System.out.println("Failed to add event listener: " + e.getMessage());
        }
        jda.addEventListener(new Co());




    }
}

