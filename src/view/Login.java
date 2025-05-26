package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Login extends Application {

    private boolean senhaVisivel = false;

    @Override
    public void start(Stage janela) {

        Image HotelLogin = new Image(getClass().getResourceAsStream("/view/resources/img/hotelLogin.png"));
        Image olhoAberto = new Image(getClass().getResourceAsStream("/view/resources/img/olhoAberto.png"));
        Image olhoFechado = new Image(getClass().getResourceAsStream("/view/resources/img/olhoFechado.png"));

        ImageView viewHotelLogin = new ImageView(HotelLogin);
        viewHotelLogin.setFitWidth(400);
        viewHotelLogin.setFitHeight(600);

        StackPane imagemPane = new StackPane(viewHotelLogin);
        imagemPane.setPrefWidth(400);
        imagemPane.setPrefHeight(600);

        Label lblTitulo = new Label("Seja Bem-Vindo ao Ibis Hotel");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");

        TextField txtEmail = new TextField();
        txtEmail.setPromptText("Digite seu email");

        PasswordField senha = new PasswordField();
        senha.setPromptText("Digite sua senha");

        TextField txtSenha = new TextField();
        txtSenha.setPromptText("Digite sua senha");
        txtSenha.setVisible(false);
        txtSenha.setManaged(false);

        ImageView viewOlhoAberto = new ImageView(olhoAberto);
        viewOlhoAberto.setFitWidth(20);
        viewOlhoAberto.setFitHeight(20);

        ImageView viewOlhoFechado = new ImageView(olhoFechado);
        viewOlhoFechado.setFitWidth(20);
        viewOlhoFechado.setFitHeight(20);

        Button toggleBtn = new Button();
        toggleBtn.setGraphic(viewOlhoFechado);
        toggleBtn.setStyle("-fx-background-color: transparent;");
        toggleBtn.setPrefSize(30, 30);
        toggleBtn.setFocusTraversable(false); // Evita foco ao tabular

        // StackPane para sobrepor botão dentro da TextField
        StackPane senhaStack = new StackPane();
        senhaStack.setAlignment(Pos.CENTER_RIGHT);
        senhaStack.setPadding(new Insets(0, 5, 0, 0)); // margem interna à direita

        // Pane que empilha os campos de senha
        StackPane campoSenha = new StackPane(senha, txtSenha);
        campoSenha.setPrefWidth(200);

        senhaStack.getChildren().addAll(campoSenha, toggleBtn);

        GridPane formGrid = new GridPane();
        formGrid.add(new Label("Email:"), 0, 0);
        formGrid.add(txtEmail, 1, 0);
        formGrid.add(new Label("Senha:"), 0, 1);
        formGrid.add(senhaStack, 1, 1);

        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setAlignment(Pos.CENTER);

        VBox loginPane = new VBox(20, lblTitulo, formGrid);
        loginPane.setAlignment(Pos.CENTER);
        loginPane.setPrefWidth(400);
        loginPane.setPrefHeight(600);
        loginPane.setStyle("-fx-padding: 40;");

        HBox root = new HBox(imagemPane, loginPane);
        root.setPrefSize(800, 600);

        Scene scene = new Scene(root);
        janela.setScene(scene);
        janela.setTitle("Ibis Hotel");
        janela.show();

        toggleBtn.setOnAction(evento -> {
            if (senhaVisivel) {
                senha.setText(txtSenha.getText());
                senha.setVisible(true);
                senha.setManaged(true);
                txtSenha.setVisible(false);
                txtSenha.setManaged(false);
                toggleBtn.setGraphic(viewOlhoFechado);
                senhaVisivel = false;
            } else {
                txtSenha.setText(senha.getText());
                txtSenha.setVisible(true);
                txtSenha.setManaged(true);
                senha.setVisible(false);
                senha.setManaged(false);
                toggleBtn.setGraphic(viewOlhoAberto);
                senhaVisivel = true;
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}