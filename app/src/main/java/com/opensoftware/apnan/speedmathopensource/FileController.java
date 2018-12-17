package com.opensoftware.apnan.speedmathopensource;

import android.content.Context;

import java.io.FileOutputStream;
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

        }
    }
}
