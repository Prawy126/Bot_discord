package muzyka;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.exceptions.RateLimitedException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;
import javax.security.auth.login.LoginException;
import java.util.List;

public class MusicBot extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (!event.isFromGuild() || event.getAuthor().isBot()) return;

        String[] messageParts = event.getMessage().getContentRaw().split("\\s+", 2);
        if (messageParts.length < 1 || !messageParts[0].equalsIgnoreCase("!play")) return;

        Guild guild = event.getGuild();
        List<VoiceChannel> channels = guild.getVoiceChannelsByName("|\uD83C\uDFBC| Muzyka", true);

        if (channels.isEmpty()) {
            event.getChannel().sendMessage("Niestaty na tym serwerze nie istnieje idealne miejsce gdzie można spuszczać wodę!").queue();
            return;
        }

        VoiceChannel channel = channels.get(0); // Pobiera pierwszy kanał pasujący do nazwy "music"
        AudioManager manager = guild.getAudioManager();

        // Sprawdza, czy bot jest już połączony z kanałem głosowym
        if (!manager.isConnected() && manager.isAutoReconnect()) {
            manager.setSendingHandler(new MyAudioSendHandler());
            try {
                manager.openAudioConnection(channel);
                event.getChannel().sendMessage("Spoko już odpalam spłuczkę!").queue();
            } catch (Exception e) {
                event.getChannel().sendMessage("Niestety coś poszło nie tak spłuczka się zacieła: " + e.getMessage()).queue();
            }
        }
    }

    // Metoda do rozłączenia bota
    public void disconnectFromVoiceChannel(Guild guild) {
        AudioManager manager = guild.getAudioManager();
        if (manager.isConnected()) {
            manager.closeAudioConnection();
        }
    }
}
