package komendy;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Witaj extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String wiadomosc = event.getMessage().getContentRaw();
        String autor = event.getAuthor().getName();
        if (wiadomosc.equalsIgnoreCase("Witaj")) {
            event.getChannel().sendMessage(autor + " spłuczka nie działa").queue();
        }
    }

}
