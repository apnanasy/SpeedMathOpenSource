package com.opensoftware.apnan.speedmathopensource;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileController {
    private Context context;

    public FileController(Context context) {
        this.context = context;
    }
    public void saveGame(Game game) {
        try {
            FileOutputStream fos = context.openFileOutput("savedGame", Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(game);
            os.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public Game loadGame() {
        Game game;
        try {
            FileInputStream fis = context.openFileInput("savedGame");
            ObjectInputStream is = new ObjectInputStream(fis);
            game = (Game)is.readObject();
            is.close();
            return game;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
