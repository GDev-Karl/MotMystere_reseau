package com.example.mystere;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static com.example.mystere.Controller.textZone;
import static com.example.mystere.Main.zone;


public class MotMystere {

    private final ArrayList<String> listesMots; //listes de tout les mots du dictionnaire de mot
    private final ArrayList<String> mots; //listes des mots mystere
    private final FileInputStream dict; //dictionnaire de mot
    private String lettres; //les lettres possibles des mots

    public MotMystere(FileInputStream file) {
        dict = file;
        listesMots = new ArrayList<>();
        mots = new ArrayList<>();
        lettres = " ";
    }
    public void SelectWords() {
        int i, nberLine = 0;
        int[] rand = new int[3];
        Scanner sc = new Scanner(dict);


        // ajouts des mots dans la listes des mots
        while (sc.hasNextLine())
        {
            listesMots.add(sc.nextLine());
            nberLine += 1;
        }

        // generation de 3 nombre aléatoire entre 0 et nberLine
        Random num = new Random();
        for(i = 0; i < 3; i++)
        {
            rand[i] = num.nextInt(nberLine);
            System.out.println(rand[i]);
        }

        for(int elt: rand) {
            mots.add(listesMots.get(elt));
            //System.out.println(listesMots.get(elt));
        }

    }
    public ArrayList<String> getMots() {
        return mots;
    }
    public void melangeMots() {
        ArrayList<Character> listeLettres = new ArrayList<>();
        for(String elt: mots)
            lettres = lettres.concat(elt);

        //chaque charactere de lettres non existants dans listelettres est ajouter dans listelettres
        for(char e: lettres.toCharArray())
        {
            if(!hasChar(listeLettres, e))
                listeLettres.add(e);
        }

        //lettres prend la valeur de listelettres
        lettres = new String(String.valueOf(listeLettres));
    }
    public boolean hasChar(ArrayList<Character> str, char a) {
        for(char elt: str)
        {
            if(elt == a)
                return true;
        }

        return false;
    }
    public String getLettres()
    {
        return lettres;
    }
    public boolean checkWin() {
        for (String str: mots)
        {
            if(zone.getText().toUpperCase().equals(str))
                return true;
        }

        return false;
    }

}
