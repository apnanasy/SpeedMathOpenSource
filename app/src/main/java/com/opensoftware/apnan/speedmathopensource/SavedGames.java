package com.opensoftware.apnan.speedmathopensource;

import java.io.Serializable;
import java.util.ArrayList;

public class SavedGames implements Serializable {
    private ArrayList<Game> SavedGames;

    public SavedGames() {
        SavedGames = new ArrayList<>();
    }
    public void addGame(Game game) {
        SavedGames.add(game);
    }
    public Game getGame(int pos) {
        //Game game = SavedGames.get(pos);
        //SavedGames.remove(game);
        return SavedGames.remove(pos);
    }
    public ArrayList<Game> getSavedGames() {
        return SavedGames;
    }
    public int getSize() {
        return SavedGames.size();
    }
}
