package vasila.mir.ereader.data.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.room.Room;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BooksDbHelper extends SQLiteOpenHelper {

    private final String DATABASE_NAME = "books";
    private final String  ASSETS_PATH = "databases";
    private final String  SHARED_PREFERENCES_TITLE = "com.vasila.database_preferences";
    private final int DATABASE_VERSION = 3;
    private Context context;

    private SharedPreferences preferences;

    public BooksDbHelper(@Nullable Context context) {
        super(context, "books", null, 1);

        this.context = context;

        preferences = context.getSharedPreferences("SHARED_PREFERENCES_TITLE", Context.MODE_PRIVATE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void installDatabaseFromAssets(){
        try {
            String path = ASSETS_PATH + "/" + DATABASE_NAME + ".db";
            InputStream inputStream = context.getAssets().open(ASSETS_PATH + "/" + DATABASE_NAME + ".db");

            File outputFile = new File(context.getDatabasePath(DATABASE_NAME).getPath());
            OutputStream outputStream = new FileOutputStream(outputFile);

            this.writeExtractedFileToDisk(inputStream, outputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Boolean installedDatabaseIsOutdated() {
        return preferences.getInt(DATABASE_NAME, 0) < DATABASE_VERSION;
    }

    private void writeDatabaseVersionInPreferences() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(DATABASE_NAME, DATABASE_VERSION);
        editor.apply();
    }

    private void writeExtractedFileToDisk(InputStream in, OutputStream outs) throws IOException {
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer))>0){
            outs.write(buffer, 0, length);
        }
        outs.flush();
        outs.close();
        in.close();
    }

    private synchronized void installOrUpdateIfNecessary() {
        if (installedDatabaseIsOutdated()) {
            context.deleteDatabase(DATABASE_NAME);
            installDatabaseFromAssets();
            writeDatabaseVersionInPreferences();
        }
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        throw new RuntimeException("The $DATABASE_NAME database is not writable.");
    }

    @Override
    public SQLiteDatabase getReadableDatabase() {
        installOrUpdateIfNecessary();
        return super.getReadableDatabase();
    }


}
