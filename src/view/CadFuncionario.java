package view;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.components.Sidebar;
import view.components.painelBotoes;

public class CadFuncionario extends Application {

    public void start(Stage janela) throws Exception {
        Sidebar menu = new Sidebar();
        painelBotoes painelBtn = new painelBotoes();

        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/logoHotel.png"));
        Image imgUserBlack = new Image(getClass().getResourceAsStream("/view/resources/img/imgUserBlack.png"));
        Image imgUserBlue = new Image(getClass().getResourceAsStream("/view/resources/img/imgUserBlue.png"));

        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu);

        ImageView viewImgUserBlack = new ImageView(imgUserBlack);
        viewImgUserBlack.setFitWidth(21);
        viewImgUserBlack.setFitHeight(21);

        Label lblTitulo = new Label("Cadastro de Funcionario");
        //lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox tituloBox = new HBox(viewImgUserBlack, lblTitulo);
        // tituloBox.setPadding(new Insets(20, 20, 20, 20));
        tituloBox.setAlignment(Pos.CENTER);
        tituloBox.setSpacing(5);

        Label lblNome = new Label("Nome:");
        TextField txtNome = new TextField();

        Label lblEmail = new Label("Email:");
        TextField txtEmail = new TextField();
        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@hotmail.com", "@icloud.com");
        boxEmail.setPromptText("Selecione:");

        Label lblSenha = new Label("Senha: ");
        TextField txtSenha = new TextField();

        Label lblRole = new Label("Cargo:");
        TextField txtRole = new TextField();
        ComboBox<String> boxRole = new ComboBox<>();
        boxRole.getItems().addAll("Usuário", "Admnistrador");
        boxRole.setPromptText("Selecione:");

        GridPane formGrid = new GridPane();
        formGrid.add(tituloBox, 1, 0);
        formGrid.add(lblNome, 0, 1);
        formGrid.add(txtNome, 1, 1);
        formGrid.add(lblEmail, 0, 2);
        formGrid.add(txtEmail, 1, 2);
        formGrid.add(boxEmail, 2, 2);
        formGrid.add(lblSenha, 0, 3);
        formGrid.add(txtSenha, 1, 3);
        formGrid.add(lblRole, 0, 4);
        formGrid.add(txtRole, 1, 4);
        formGrid.add(boxRole, 2, 4);
        formGrid.add(painelBtn, 1, 5);

        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setAlignment(Pos.CENTER);

        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setAlignment(Pos.CENTER);


        VBox layout = new VBox(10, formGrid);
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);

        Scene scene = new Scene(mainPane, 750, 600);
        janela.setTitle("Hotel Ibis");

        janela.getIcons().add(imgIcon);
        janela.setScene(scene);
        janela.show();
    }
    public static void main(String[] args) {
        launch(args); //Inicializa o JAVAFX (aplicação)
    }
}