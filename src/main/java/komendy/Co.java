package komendy;

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;
import net.dv8tion.jda.api.entities.*;

public class Co extends ListenerAdapter {


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {


        String message = event.getMessage().getContentRaw();

        if (message.equalsIgnoreCase("co")) {
            System.out.println("dostałem wiadomość");
            event.getChannel().sendMessage("Jajco🥚").queue();

        }
    }

}
