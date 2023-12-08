package VideoPanel;

import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import java.awt.event.ActionListener;

public class VideoLogeo extends JPanel {
    private List<Name>names;
    private int index = 0;
    private Superposicion superposicion;
    private MediaPlayerFactory factory;
    private EmbeddedMediaPlayer mediaPlayer;
    private Timer timer;


    public VideoLogeo(){
        init();
        testData();
    }

    public void init(){
        factory = new MediaPlayerFactory();
        mediaPlayer = factory.mediaPlayers().newEmbeddedMediaPlayer();
        Canvas canvas = new Canvas();
        mediaPlayer.videoSurface().set(factory.videoSurfaces().newVideoSurface(canvas));

        setLayout(new BorderLayout());
        add(canvas);

        mediaPlayer.events().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
            @Override
            public void finished(MediaPlayer mediaPlayer) {
                // Cuando el video llega al final, no se hace nada aquí, el temporizador se encargará de reiniciar la reproducción.
            }
        });

        // Configura un temporizador para verificar el estado del video periódicamente
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!mediaPlayer.status().isPlaying()) {
                    // Si el video no está reproduciéndose, inicia la reproducción
                    mediaPlayer.controls().play();
                }
            }
        });
        timer.start(); // Inicia el temporizador
    }

    private void testData(){
        names = new ArrayList<>();
        names.add(new Name("eTravelEasy","Video/logeo-video.mp4"));
    }

    public void initSuperpos(JFrame frame){
        superposicion = new Superposicion(frame, names);
        mediaPlayer.overlay().set(superposicion);
        mediaPlayer.overlay().enable(true);

    }
    public void play(int index) {
        this.index = index;
        Name name = names.get(index);

        if (mediaPlayer.media().isValid()) {

            mediaPlayer.controls().stop();
        }

        mediaPlayer.media().start(name.getRutaVideo());
        mediaPlayer.controls().play();

        superposicion.getEncima().setIndex(index);
    }

    public void stop() {
        mediaPlayer.controls().stop();
        mediaPlayer.release();
        factory.release();
        timer.stop(); // Detiene el temporizador cuando la reproducción se detiene
    }

}
