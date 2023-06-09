import komendy.Witaj;
import komendy.Test;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

public class Main {

    private static final String TOKEN = "OTQ1NjIyMTExNzQ4MjM5MzYw.GiCs1E.eAb4Js46WA3Wp7N2ACxWsIUVmpMSomjvxGBQy8";

    public static void main(String[] args) {
        JDA jda = JDABuilder.createDefault(TOKEN).build();


        if (jda.getStatus() == JDA.Status.CONNECTED) {
            System.out.println("Bot connected!");
        } else {
            System.out.println("Bot failed to connect");
        }
        jda.addEventListener(new Test());
        //IDLE - zaraz wracam, ONLINE - online,
        jda.getPresence().setStatus(OnlineStatus.IDLE);

        try {
            jda.addEventListener(new Witaj());
            jda.addEventListener(new Test());
        } catch (Exception e) {
            System.out.println("Failed to add event listener: " + e.getMessage());
        }




    }
}

