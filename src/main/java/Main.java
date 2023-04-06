import komendy.Witaj;
import komendy.Test;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class Main {

    private static final String TOKEN = "OTQ1NjIyMTExNzQ4MjM5MzYw.GRXVPF.2RRGR0ugeCp5LhELJtLkdeLT4jnQRsnAqXOO2U";

    public static void main(String[] args) {
        JDA jda = JDABuilder.createDefault(TOKEN).build();
        jda.addEventListener(new Witaj());

        if (jda.getStatus() == JDA.Status.CONNECTED) {
            System.out.println("Bot connected!");
        } else {
            System.out.println("Bot failed to connect");
        }
        jda.addEventListener(new Test());

    }
}

