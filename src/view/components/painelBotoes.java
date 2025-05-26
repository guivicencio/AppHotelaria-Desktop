package view.components;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class painelBotoes extends HBox {

    public painelBotoes() {

        Image imgBtnCad = new Image(getClass().getResourceAsStream
                ("/view/resources/img/Adicionar.png"));
        Image imgBtnUp = new Image(getClass().getResourceAsStream
                ("/view/resources/img/Atual" +
                        "izar.png"));
        Image imgBtnDel = new Image(getClass().getResourceAsStream
                ("/view/resources/img/excluir.png"));

        ImageView viewImgBtnCad = new ImageView(imgBtnCad);
        viewImgBtnCad.setFitWidth(21);
        viewImgBtnCad.setFitHeight(21);

        ImageView viewImgBtnUp = new ImageView(imgBtnUp);
        viewImgBtnUp.setFitWidth(21);
        viewImgBtnUp.setFitHeight(21);

        ImageView viewImgBtnDel = new ImageView(imgBtnDel);
        viewImgBtnDel.setFitWidth(21);
        viewImgBtnDel.setFitHeight(21);

        Button btnCad = new Button("Cadastrar", viewImgBtnCad);
        Button btnUp = new Button("Atualizar", viewImgBtnUp);
        Button btnDel = new Button("Excluir", viewImgBtnDel);

        HBox buttonBox = new HBox(btnCad, btnUp, btnDel);

        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(5);

        this.getChildren().addAll(buttonBox);
    }

}