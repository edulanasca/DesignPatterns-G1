package monitoreo.modelos;

import javafx.scene.image.ImageView;
import monitoreo.modelos.impl.IconoNulo;
import monitoreo.modelos.impl.ImagenGif;
import monitoreo.modelos.impl.ImagenIcono;

public abstract class Icono {

    protected ImageView imageView;

    public abstract boolean isNull();

    public abstract ImageView getImageView();

    public static Icono getIcono(String url) {
        if (url.contains("png")) {
            return new ImagenIcono(url);
        } else if (url.contains("gif")) {
            return new ImagenGif(url);
        } else {
            return new IconoNulo();
        }
    }

}
