//package vasila.mir.ereader.data.db
//
//import android.content.Context
//import android.database.sqlite.SQLiteDatabase
//import android.database.sqlite.SQLiteOpenHelper
//import java.io.File
//import java.io.FileOutputStream
//
//class BooksDbHelper (val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
//
//    override fun onCreate(db: SQLiteDatabase?) {
//        // Nothing to do
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//        // Nothing to do
//    }
//
//    private fun installDatabaseFromAssets() {
//        val inputStream = context.assets.open("$ASSETS_PATH/$DATABASE_NAME.sqlite3")
//
//        try {
//            val outputFile = File(context.getDatabasePath(DATABASE_NAME).path)
//            val outputStream = FileOutputStream(outputFile)
//
//            inputStream.(outputStream)
//            inputStream.close()
//
//            outputStream.flush()
//            outputStream.close()
//        } catch (exception: Throwable) {
//            throw RuntimeException("The $DATABASE_NAME database couldn't be installed.", exception)
//        }
//    }
//
//    companion object {
//        const val DATABASE_NAME = "books"
//        const val DATABASE_VERSION = 1
//    }
//
//}