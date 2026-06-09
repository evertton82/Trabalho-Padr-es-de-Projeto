package padroesestruturais.adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReprodutorAudioTest {

    ILeitorMidia player;

    @BeforeEach
    void setUp() {
        player = new ReprodutorAudio();
    }

    @Test
    void deveTocarMp3Nativamente() {
        assertEquals("Tocando MP3: musica.mp3", player.tocar("mp3", "musica.mp3"));
    }

    @Test
    void deveTocarMp4ViaAdaptador() {
        assertEquals("Tocando MP4: filme.mp4", player.tocar("mp4", "filme.mp4"));
    }

    @Test
    void deveTocarVlcViaAdaptador() {
        assertEquals("Tocando VLC: video.vlc", player.tocar("vlc", "video.vlc"));
    }

    @Test
    void deveRecusarFormatoNaoSuportado() {
        try {
            player.tocar("avi", "clipe.avi");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Formato não suportado: avi", e.getMessage());
        }
    }
}
