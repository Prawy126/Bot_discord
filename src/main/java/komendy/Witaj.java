package komendy;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;
import net.dv8tion.jda.api.entities.*;

public class Witaj extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String wiadomosc = event.getMessage().getContentRaw();
        String autor = event.getAuthor().getName();
        if (wiadomosc.equalsIgnoreCase("witaj")) {
            event.getChannel().sendMessage(autor + " spłuczka nie działa. Czekam aż Prawy_126 to naprawi.").queue();


        }
    }

}
