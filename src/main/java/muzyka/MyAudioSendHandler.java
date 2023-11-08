package muzyka;

import net.dv8tion.jda.api.audio.AudioSendHandler;

import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyAudioSendHandler implements AudioSendHandler {
    private final Queue<byte[]> queue = new ConcurrentLinkedQueue<>();

    @Override
    public boolean canProvide() {
        return !queue.isEmpty();
    }

    @Override
    public ByteBuffer provide20MsAudio() {
        byte[] data = queue.poll();
        return data == null ? null : ByteBuffer.wrap(data);
    }

    @Override
    public boolean isOpus() {
        return true; // Jeśli twoje dane są już w formacie Opus.
    }

    // Metoda do dodawania danych do kolejki.
    public void addAudio(byte[] data) {
        queue.add(data);
    }
}
