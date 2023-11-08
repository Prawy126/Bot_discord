package komendy;

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;
import net.dv8tion.jda.api.entities.*;

public class Witaj extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {


        String message = event.getMessage().getContentRaw();
        String autor = event.getAuthor().getName();
        if (message.equalsIgnoreCase("!witaj")) {
            System.out.println("dostałem wiadomość");
            event.getChannel().sendMessage("Cześć " + autor).queue();

        }
    }

}
