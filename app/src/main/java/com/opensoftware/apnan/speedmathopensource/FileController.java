package com.opensoftware.apnan.speedmathopensource;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileController {
    private Context context;

    /**
     * @param context this is a base context that is needed for the builtin file read and write
     */
    public FileController(Context context) {
        this.context = context;
    }

    /**
     * @param game This is the game object to be saved.
     */
   // public void saveGame(Game game) {
   //     try {
    //        FileOutputStream fos = context.openFileOutput("savedGame", Context.MODE_PRIVATE);
   //         ObjectOutputStream os = new ObjectOutputStream(fos);
   //         os.writeObject(game);
   //         os.close();
   //     } catch(Exception e) {
   //         e.printStackTrace();
   //     }
   // }

    /**
     * @return Game object that was saved
     */
   // public Game loadGame() {
   //     Game game;
   //     try {
   //         FileInputStream fis = context.openFileInput("savedGame");
   //         ObjectInputStream is = new ObjectInputStream(fis);
   //         game = (Game)is.readObject();
   //         is.close();
   //         return game;
    //    } catch(Exception e) {
   //         e.printStackTrace();
   //     }
   //     return null;

   // }

    public SavedGames loadGames() {
        SavedGames games;
        try {
            FileInputStream fis = context.openFileInput("savedGame");
            ObjectInputStream is = new ObjectInputStream(fis);
            games = (SavedGames)is.readObject();
            is.close();
            return games;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new SavedGames();

    }

    public void saveGames(SavedGames games) {
        try {
            FileOutputStream fos = context.openFileOutput("savedGame", Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(games);
            os.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return An allscores object from file, if it cant be read it creates a new one
     */
    public AllScores loadScores() {
        AllScores scores;
        try {
            FileInputStream fis = context.openFileInput("allGames");
            ObjectInputStream is = new ObjectInputStream(fis);
            scores = (AllScores) is.readObject();
            is.close();
            return scores;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new AllScores();
    }

    /**
     * @param scores the Allscores object that is to be written to disk
     */
    public void saveScores(AllScores scores) {
        try {
            FileOutputStream fos = context.openFileOutput("allGames", Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(scores);
            os.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
