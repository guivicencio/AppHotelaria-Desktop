package view; //Package view (classes que, quando executadas, interagem com o usuário)
import javafx.application.Application; //Ciclo de vida da aplicação (init(), start(), stop() --> launch())
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; //Classe Scene: container que contém os layouts
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox; //Classe VBox: é um dos tipos de layouts
import javafx.stage.Stage; //Classe Stage é a própria janela (incluso barra de opções: minimizar, maximizar, fechar)
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import view.components.Sidebar;
import view.components.painelBotoes;

public class CadCliente extends Application {

    public void start(Stage janela) throws Exception {
        Sidebar menu = new Sidebar();
        painelBotoes painelBtn = new painelBotoes();

        //Carregar imagens
        Image imgIcon = new Image(getClass().getResourceAsStream("/view/resources/img/logoHotel.png"));
        Image imgUserBlack = new Image(getClass().getResourceAsStream("/view/resources/img/imgUserBlack.png"));
        Image imgUserBlue = new Image(getClass().getResourceAsStream("/view/resources/img/imgUserBlue.png"));

        //Criação de um container principal chamado mainPane
        BorderPane mainPane = new BorderPane();
        mainPane.setLeft(menu);

        //Parâmetros para definir como a imagem será visualizada
        ImageView viewImgUserBlack = new ImageView(imgUserBlack);
        viewImgUserBlack.setFitWidth(21);
        viewImgUserBlack.setFitHeight(21);

        //Título
        Label lblTitulo = new Label("Cadastro de Cliente");
        //lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox tituloBox = new HBox(viewImgUserBlack, lblTitulo);
        // tituloBox.setPadding(new Insets(20, 20, 20, 20));
        tituloBox.setAlignment(Pos.CENTER);
        tituloBox.setSpacing(5);

        Label lblNome = new Label("Nome:");
        TextField txtNome = new TextField();

        Label lblCPF = new Label("CPF:");
        TextField txtCPF = criarMascaraCampo("###.###.###-##");

        Label lblEmail = new Label("E-mail:");
        TextField txtEmail = new TextField();

        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@hotmail.com", "@icloud.com");
        boxEmail.setPromptText("Selecione:");

        Label lblTel = new Label("Telefone:");
        TextField txtTel = criarMascaraCampo("(##) #####-####");

        GridPane formGrid = new GridPane();
        formGrid.add(tituloBox, 1, 0);
        formGrid.add(lblNome, 0, 1);
        formGrid.add(txtNome, 1, 1);
        formGrid.add(lblCPF, 0, 2);
        formGrid.add(txtCPF, 1, 2);
        formGrid.add(lblEmail, 0, 3);
        formGrid.add(txtEmail, 1, 3);
        formGrid.add(boxEmail, 2, 3);
        formGrid.add(lblTel, 0, 4);
        formGrid.add(txtTel, 1, 4);
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

        //Colocar um ícone na janela (stage) -> ícone da empresa/marca
        janela.getIcons().add(imgIcon);
        janela.setScene(scene);
        janela.show();
    }

    private TextField criarMascaraCampo(String mascara) {
        TextField txtMascara = new TextField();
        txtMascara.textProperty().addListener((observable, oldValue, newValue) ->
        {
            String value = newValue.replaceAll("[^0-9]", "");
            StringBuilder formatacaoCampo = new StringBuilder();
            int index = 0;
            for (char caracter: mascara.toCharArray()) {
                if (caracter == '#') {
                    if (index < value.length()) {
                        formatacaoCampo.append(value.charAt(index));
                        index++;
                    }
                    else {
                        break;
                    }
                }
                else {
                    formatacaoCampo.append(caracter);
                }
            }
            txtMascara.setText(formatacaoCampo.toString());
        });
        return txtMascara;
    }
    public static void main(String[] args) {
       launch(args); //Inicializa o JAVAFX (aplicação)
    }
}