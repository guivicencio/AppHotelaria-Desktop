package view.components;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Sidebar extends VBox {
    public Button btnCliente = new Button("Clientes");
    public Button btnFuncionario = new Button("Funcionários");
    public Button btnQuarto = new Button("Quartos");
    public Button btnReserva = new Button("Reservas");
    public Button btnRelatorio = new Button("Relatórios");


    public Sidebar() {
        Image iconFuncionario = new Image(getClass().getResourceAsStream(
                "/view/resources/img/icon-funcionario.png"));
        Image iconQuarto = new Image(getClass().getResourceAsStream(
                "/view/resources/img/icon-quarto.png"));
        Image iconReserva = new Image(getClass().getResourceAsStream(
                "/view/resources/img/icon-reserva.png"));
        Image iconRelatorio = new Image(getClass().getResourceAsStream(
                "/view/resources/img/icon-relatorio.png"));
        Image iconCliente = new Image(getClass().getResourceAsStream(
                "/view/resources/img/icon-cliente.png"));

        //Carregamento das barras
        Font fonteRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" +
                "OpenSans_Condensed-Regular.ttf"), 14);

        Font fonteBold = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" +
                "OpenSans_Condensed-Bold.ttf"), 15);

        ImageView viewIconFuncionario = new ImageView(iconFuncionario);
        viewIconFuncionario.setFitHeight(20);
        viewIconFuncionario.setFitWidth(20);

        ImageView viewIconCliente = new ImageView(iconCliente);
        viewIconCliente.setFitHeight(20);
        viewIconCliente.setFitWidth(20);

        ImageView viewIconQuarto = new ImageView(iconQuarto);
        viewIconQuarto.setFitHeight(20);
        viewIconQuarto.setFitWidth(20);

        ImageView viewIconReserva = new ImageView(iconReserva);
        viewIconReserva.setFitHeight(20);
        viewIconReserva.setFitWidth(20);

        ImageView viewIconRelatorios = new ImageView(iconRelatorio);
        viewIconRelatorios.setFitHeight(20);
        viewIconRelatorios.setFitWidth(20);

        btnCliente.setGraphic(viewIconCliente);
        btnFuncionario.setGraphic(viewIconFuncionario);
        btnQuarto.setGraphic(viewIconQuarto);
        btnReserva.setGraphic(viewIconReserva);
        btnRelatorio.setGraphic(viewIconRelatorios);

        Label lblMenu = new Label("Grand Hotel");
        lblMenu.setStyle("-fx-text-fill: #a87e08;"     //Cor
        );
        lblMenu.setFont(Font.font(fonteBold.getFamily(), 25));

        //Estilização dos botões (fundo e borda = transparente)
        String styleButton = "-fx-background-color: transparent;" +
                             "-fx-border-color: transparent;" +
                             "-fx-graphic-text-gap: 10px;" +
                             "-fx-alignment: center;" +
                             "fx-cursor: hand;";     //Setar o cursor de mãozinha para o mouse
        btnCliente.setStyle(styleButton);
        btnFuncionario.setStyle(styleButton);
        btnQuarto.setStyle(styleButton);
        btnReserva.setStyle(styleButton);
        btnRelatorio.setStyle(styleButton);

        btnCliente.setOnMouseEntered (evento ->
                btnCliente.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnCliente.setOnMouseExited(evento -> btnCliente.setStyle(styleButton));

        btnReserva.setOnMouseEntered(evento ->
                btnReserva.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnReserva.setOnMouseExited(evento -> btnReserva.setStyle(styleButton));

        btnQuarto.setOnMouseEntered(evento ->
                btnQuarto.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnQuarto.setOnMouseExited(evento -> btnQuarto.setStyle(styleButton));

        btnFuncionario.setOnMouseEntered(evento ->
                btnFuncionario.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnFuncionario.setOnMouseExited(evento -> btnFuncionario.setStyle(styleButton));

        btnRelatorio.setOnMouseEntered(evento ->
                btnRelatorio.setStyle(styleButton.replace("transparent", "#D6C388FF")));
        btnRelatorio.setOnMouseExited(evento -> btnRelatorio.setStyle(styleButton));

        //Espaçamento extremo(margem) do componente label até o botão
        setMargin(lblMenu, new Insets(0,    0,   20,   0));
        //Margem:                     superior, direito, inferior, esquerdo

        setStyle("-fx-background-color: #ffffff; -fx-padding: 40px ");
        setSpacing(12);       //Metodo setSpacing
        getChildren().addAll(lblMenu, btnCliente, btnFuncionario,
                btnQuarto, btnReserva, btnRelatorio);

    }

}
