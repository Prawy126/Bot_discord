import komendy.Co;
import komendy.Spam;
import komendy.Witaj;
import komendy.Test;
import muzyka.MusicBot;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;

public class Main {

    private static final String TOKEN = "";

    public static void main(String[] args) {
        try {
            // Utwórz JDA i włącz intencje w jednym wywołaniu
            JDA jda = JDABuilder.createDefault(TOKEN)
                    .enableIntents(EnumSet.of(GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.MESSAGE_CONTENT))
                    .setActivity(Activity.competing("Najlpeszy kibel na tym serwerze"))
                    .build();

            // Czekaj na gotowość JDA przed dodaniem słuchaczy
            jda.awaitReady(); // Czekaj, aż JDA będzie gotowe. To jest wywołanie blokujące.

            // Dodaj ListenerAdapter'y po inicjalizacji JDA
            jda.addEventListener(new Witaj(), new Co(), new MusicBot());
            jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB); // Ustaw status na DND po dodaniu słuchaczy

            System.out.println("Bot connected!");
        } catch (Exception e) {
            e.printStackTrace(); // Wydrukuj pełny stack trace w przypadku wyjątku
        }
    }
}

