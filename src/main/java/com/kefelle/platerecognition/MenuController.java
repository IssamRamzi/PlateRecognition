package com.kefelle.platerecognition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class MenuController {
    /*
        todo : attributs
    */
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField searchField = new TextField();
    @FXML
    public ScrollPane scrollPane;
    @FXML
    private VBox vBox = new VBox();
    private ScrollPane scrollPaneManual = new ScrollPane();
    private VBox vBoxManual = new VBox();

    /*
        todo : switch scenes
    */
    @FXML
    public void changeToHome(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminPage/Home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void changeToProfile(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminPage/AdminProfile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void changeToLists(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminPage/Lists.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void changeToStatistics(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminPage/Statistics.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void changeToManual(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminPage/Manual.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        this.generateManual(event);
        System.out.println("Manual");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void changeToContact(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminPage/Contact.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /*
        todo : Lists

        * : fix displayUsers method to display the users that are new in the VBox and also clear the VBox before when redisplaying the users
    */

    public void displayUsers(MouseEvent event) throws SQLException {
        // ! not working
        clearVBox();
        scrollPane.setContent(null);
        var list = User.getUsersList();
        for (User user : list) {
            Text userText = new Text(user.toString());
            vBox.getChildren().add(userText);
        }
        scrollPane.setContent(vBox);
        scrollPane.setPannable(true);
    }
    public void searchUserKeyBoard(KeyEvent event) throws SQLException {
        // ! not working (When pressing enter)

        if (event.getCode() == KeyCode.ENTER) {
            String search = searchField.getText();
            try {
                if (User.isUser(search)) {
                    clearVBox();
                    Text userText = new Text(User.getUser(search).toString());
                    System.out.println(User.getUser(search));
                    vBox.getChildren().add(userText);
                    scrollPane.setContent(vBox);
                    scrollPane.setPannable(true);
                } else {
                    Text text = new Text("User not found");
                    text.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-fill: red;");
                    clearVBox();
                    vBox.getChildren().add(text);
                    scrollPane.setContent(vBox);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void searchUser(MouseEvent event) {
        String search = searchField.getText();
        try {
            if (User.isUser(search)) {
                clearVBox();
                Text userText = new Text(User.getUser(search).toString());
                System.out.println(User.getUser(search));
                vBox.getChildren().add(userText);
                scrollPane.setContent(vBox);
                scrollPane.setPannable(true);
            } else {
                Text text = new Text("User not found");
                text.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-fill: red;");
                clearVBox();
                vBox.getChildren().add(text);
                scrollPane.setContent(vBox);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void clearVBox(){
        vBox.getChildren().clear();
    }
    public void addNewUser(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AdminPage/AddUser.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage s = new Stage();
        s.setTitle("AddUser");
        s.setScene(scene);
        s.show();
//        User.addUser();
    }
    public void deleteUser(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AdminPage/DeleteUser.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage s = new Stage();
        s.setTitle("Delete User");
        s.setScene(scene);
        s.show();
    }
    public void modifyUser(MouseEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AdminPage/ModifyUser.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage s = new Stage();
        s.setTitle("Modify User");
        s.setScene(scene);
        s.show();
    }
    /*
        todo : Manual
    */
    @FXML
    public void generateManual(MouseEvent event) {
        vBoxManual.getChildren().clear();
        final int big_font = 24;
        final int small_font = 18;
        Text titre = new Text("Manuel d'Utilisation - Système de Gestion des Plaques d'Immatriculation");
        titre.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-fill: Red;");

        Text Introduction = new Text("\n\nIntroduction : ");
        Introduction.setStyle("-fx-font-size: " + big_font + "px; -fx-font-weight: bold; -fx-fill: black;");
        Text introduction_text = new Text("\tBienvenue dans le système de gestion des plaques d'immatriculation. Ce manuel fournit des instructions détaillées sur " +
                "\nl'utilisation de différentes fonctionnalités disponibles pour les administrateurs.");
        introduction_text.setStyle("-fx-font-size: " + small_font + "px; -fx-font-weight: bold; -fx-fill: black;");

        Text connexion = new Text("\nConnexion : ");
        connexion.setStyle("-fx-font-size: " + big_font + "px; -fx-font-weight: bold; -fx-fill: black;");
        Text connexion_text = new Text("\tPour vous connecter, veuillez entrer votre nom d'utilisateur et votre mot de passe dans les champs appropriés. " +
                "\nCliquez sur le bouton de connexion pour accéder à votre compte.");
        connexion_text.setStyle("-fx-font-size: " + small_font + "px; -fx-font-weight: bold; -fx-fill: black;");

        Text tbl_de_bord = new Text("\nTableau de bord : ");
        tbl_de_bord.setStyle("-fx-font-size: " + big_font + "px; -fx-font-weight: bold; -fx-fill: black;");
        Text tbl_de_bord_text = new Text("\tLe tableau de bord principal présente plusieurs options pour la gestion des plaques d'immatriculation.");
        tbl_de_bord_text.setStyle("-fx-font-size: " + small_font + "px; -fx-font-weight: bold; -fx-fill: black;");

        Text nav = new Text("\nNavigation : ");
        nav.setStyle("-fx-font-size: " + big_font + "px; -fx-font-weight: bold; -fx-fill: black;");
        Text nav_text = new Text("\tPour naviguer entre les différentes pages, utilisez les boutons de navigation situés a gauche de l'écran. " +
                "\nCliquez sur le bouton correspondant à la page que vous souhaitez visiter.");
        nav_text.setStyle("-fx-font-size: " + small_font + "px; -fx-font-weight: bold; -fx-fill: black;");

        Text pages = new Text("\nPages : ");
        pages.setStyle("-fx-font-size: " + big_font + "px; -fx-font-weight: bold; -fx-fill: black;");
        Text pages_text = new Text("\tLes pages disponibles sont les suivantes : \n" +
                "\t\t- Accueil : Permet de revenir à la page d'accueil du tableau de bord.\n" +
                "\t\t- Profil : Affiche et permet de modifier les informations du profil de l'administrateur.\n" +
                "\t\t- Listes : Affiche la liste des utilisateurs enregistrés dans le système.\n" +
                "\t\t- Statistiques : Affiche les statistiques et les rapports sur l'utilisation du système.\n" +
                "\t\t- Manuel : Accède au manuel d'utilisation pour une référence rapide.\n" +
                "\t\t- Contact : Pour contacter les developpeurs du systeme\n");
        pages_text.setStyle("-fx-font-size: " + small_font + "px; -fx-font-weight: bold; -fx-fill: black;");

        Text fct_princi = new Text("\nFonctionnalités Principales : ");
        fct_princi.setStyle("-fx-font-size: " + big_font + "px; -fx-font-weight: bold; -fx-fill: black;");
        Text fct_princi_text = new Text("\tLes fonctionnalités principales disponibles pour les administrateurs sont les suivantes : \n" +
                "\t\t- Ajouter un utilisateur : Permet d'ajouter un nouvel utilisateur au système.\n" +
                "\t\t- Rechercher un utilisateur : Permet de rechercher un utilisateur existant du système.\n" +
                "\t\t- Supprimer un utilisateur : Permet de supprimer un utilisateur existant du système.\n" +
                "\t\t- Modifier un utilisateur : Permet de modifier les informations d'un utilisateur existant.\n" +
                "\t\t- Afficher les utilisateurs : Affiche la liste des utilisateurs enregistrés dans le système.\n" +
                "\t\t- Afficher les statistiques : Affiche les statistiques et les rapports sur l'utilisation du système.\n");
        fct_princi_text.setStyle("-fx-font-size: " + small_font + "px; -fx-font-weight: bold; -fx-fill: black;");


        vBoxManual.getChildren().add(titre);
        vBoxManual.getChildren().add(Introduction);
        vBoxManual.getChildren().add(introduction_text);

        vBoxManual.getChildren().add(connexion);
        vBoxManual.getChildren().add(connexion_text);

        vBoxManual.getChildren().add(tbl_de_bord);
        vBoxManual.getChildren().add(tbl_de_bord_text);

        vBoxManual.getChildren().add(nav);
        vBoxManual.getChildren().add(nav_text);

        vBoxManual.getChildren().add(pages);
        vBoxManual.getChildren().add(pages_text);

        vBoxManual.getChildren().add(fct_princi);
        vBoxManual.getChildren().add(fct_princi_text);

        scrollPaneManual.setContent(vBoxManual);
    }


}
