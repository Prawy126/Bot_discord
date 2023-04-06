package komendy;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Test extends ListenerAdapter {
@Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().equals("!hello")) {
            event.getChannel().sendMessage("Hello, World!").queue();
        }
    }
}
