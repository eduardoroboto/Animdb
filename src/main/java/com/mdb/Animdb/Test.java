package com.mdb.Animdb;

import com.mdb.Animdb.enums.Status;
import com.mdb.Animdb.interfaces.User;
import com.mdb.Animdb.model.productions.Anime;
import com.mdb.Animdb.model.productions.Filme;
import com.mdb.Animdb.model.productions.Serie;
import com.mdb.Animdb.model.users.Usuario;
import org.json.JSONException;


public class Test {
    public static void main(String[] args) throws JSONException {
        Anime anime = new Anime.Builder().setModelAuthor("Fulano").setModelTitle("One Piece").build();
        System.out.println(anime.toString());

        Filme filme = new Filme.Builder().setModelDuration(180).setModelTitle("Harry Potter").build();
        System.out.println(filme.toString());

        Serie serie = new Serie.Builder().setModelStatus(Status.Finished).setModelTitle("Batman: Begins").build();

        System.out.println(serie.toString());

        Usuario novo_usuario = new Usuario("lol","lol@lol.com","00","12345");
        novo_usuario.createList("Favoritos");
        novo_usuario.addProductions("Favoritos",anime,filme,serie);
        System.out.println(novo_usuario);

        System.out.println(anime.getAll());

    }
}