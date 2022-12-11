package com.example.mystere;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.ArrayList;


public class Main extends Application {
    static TextField zone = new TextField();

    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage stage) throws Exception {
        FileInputStream dict = new FileInputStream("C://projet_code//projet_java//Autres//Mystere//Dictionnaire.txt");
        ArrayList<String> MotsCahes = new ArrayList<>();

        MotMystere mots = new MotMystere(dict);
        mots.SelectWords();
        mots.melangeMots();

        for (String elt: mots.getMots())
        {
            MotsCahes.add(elt);
            System.out.println(elt);
        }


        stage.setTitle("Mot Mystère");

        Text instrution = new Text("Trouvez le Mot Mystère");
        Text text = new Text(mots.getLettres());
        Button valider = new Button("Valider");


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(10);
        grid.setVgap(10);

        GridPane.setConstraints(instrution, 0, 0);
        GridPane.setConstraints(text, 0, 1);
        GridPane.setConstraints(zone, 0, 2);
        GridPane.setConstraints(valider, 0, 3);

        grid.getChildren().addAll(instrution, text, zone, valider);

        valider.setOnAction(e -> {
            if (mots.checkWin())
                System.out.println("Bravo vous avez trouver un des mots mysteres");
        });

        Scene scene = new Scene(grid,300, 300);
        stage.setScene(scene);
        stage.show();

    }

            /*

        int nbreLine = 0, j = 0;
        String mot = null;
        int[] rand = new int[3];
        ArrayList<String> mots = new ArrayList<>();
        Scanner sc = new Scanner(dict);

        //affichage du contenun du fichier ligne par ligne
        while (sc.hasNextLine())
        {
            mots.add(sc.nextLine());
            nbreLine += 1;
        }
        System.out.println(nbreLine);

        Random num = new Random();
        for(int  i = 0; i < 3; i++)
        {
            rand[i] = num.nextInt(nbreLine);
            System.out.println(rand[i]);
        }

        for(int elt: rand)
            System.out.println(mots.get(elt));

         */

    public static String getTextZone()
    {
        return zone.getText();
    }
}
