package komendy;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Test extends ListenerAdapter {

@Override
public void onMessageReceived(MessageReceivedEvent event) {
    Message message = event.getMessage();
    MessageChannel channel = event.getChannel();

    // Przykładowe działania na kanale
    //channel.sendMessage("Przykładowa wiadomość").queue();
}

}
