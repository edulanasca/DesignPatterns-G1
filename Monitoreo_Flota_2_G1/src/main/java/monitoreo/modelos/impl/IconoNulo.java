package monitoreo.modelos.impl;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import monitoreo.modelos.Icono;

public class IconoNulo extends Icono {
    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public ImageView getImageView() {
        System.out.println("Alerta: Imagen no disponible para icono nulo");

        Image img = new Image("https://st.depositphotos.com/1477718/4577/v/950/depositphotos_45776985-stock-illustration-red-exclamation-mark-warning-road.jpg");
        ImageView view = new ImageView(img);
        view.setFitHeight(40);
        view.setPreserveRatio(true);

        return view;
    }
}
