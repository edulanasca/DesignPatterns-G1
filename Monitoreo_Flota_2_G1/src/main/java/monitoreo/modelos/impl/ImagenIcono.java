package monitoreo.modelos.impl;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import monitoreo.modelos.Icono;

public class ImagenIcono extends Icono {

    public ImagenIcono(String ruta) {

        Image img = new Image(ruta);
        ImageView view = new ImageView(img);
        view.setFitHeight(40);
        view.setPreserveRatio(true);

        this.imageView = view;
        //this.imageView = null;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public ImageView getImageView() {
        return imageView;
    }
}
