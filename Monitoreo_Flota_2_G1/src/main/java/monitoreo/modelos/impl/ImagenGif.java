package monitoreo.modelos.impl;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import monitoreo.modelos.Icono;

public class ImagenGif extends Icono {

  public ImagenGif(String ruta) {
    Image img = new Image(ruta);
    ImageView view = new ImageView(img);
    view.setFitHeight(50);
    view.setPreserveRatio(true);

    this.imageView = view;
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
