package ch.floriankaufmann.dummbbellonly;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 11;

    private static final String DATABASE_NAME = "exercisesManager";

    private static final String TABLE_EXERCISES = "exercises";

    private static int count = 0;

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SETS = "sets";
    private static final String KEY_REPS = "reps";
    private static final String KEY_STOREDREPS = "storedreps";
    private static final String KEY_STOREDWEIGHT = "storedweight";
    private static final String KEY_LINK = "link";
    private static final String KEY_FRAGMENT = "fragment";

    public DatabaseHandler (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_EXERCISES_TABLE = "CREATE TABLE " + TABLE_EXERCISES + "("
                + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT, "
                + KEY_SETS + " TEXT, " + KEY_REPS + " TEXT, " + KEY_STOREDREPS + " TEXT, "
                + KEY_STOREDWEIGHT + " TEXT, " + KEY_LINK + " TEXT, " + KEY_FRAGMENT + " TEXT " + ")";

            sqLiteDatabase.execSQL(CREATE_EXERCISES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISES);
        onCreate(sqLiteDatabase);
    }

    // Adding new exercises
    public void addExercise(Exercise exercise) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, exercise.getName());
        values.put(KEY_SETS, exercise.getSets());
        values.put(KEY_REPS, exercise.getReps());
        values.put(KEY_STOREDREPS, exercise.getStoredReps());
        values.put(KEY_STOREDWEIGHT, exercise.getStoredWeight());
        values.put(KEY_LINK, exercise.getLink());
        values.put(KEY_FRAGMENT, exercise.getFragment());

        db.insert(TABLE_EXERCISES, null, values);
        db.close();
    }

    // Getting single contact
    public Exercise getExercise(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_EXERCISES, new String[] { KEY_ID, KEY_NAME, KEY_SETS, KEY_REPS, KEY_STOREDREPS, KEY_STOREDWEIGHT, KEY_LINK, KEY_FRAGMENT}, KEY_ID + "=?",
                new String[] {String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Exercise exercise = new Exercise(Integer.parseInt(cursor.getString(0)), cursor.getString(1),cursor.getString(2), cursor.getString(3), cursor.getString(4),
                cursor.getString(5),  cursor.getString(6));

        return exercise;
    }



    // Getting All Exercises
    public ArrayList<Exercise> getAllExercises() {
            ArrayList<Exercise> exerciseList = new ArrayList<Exercise>();
            // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_EXERCISES;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    Exercise exercise = new Exercise();
                    exercise.setId(Integer.parseInt(cursor.getString(0)));
                    exercise.setName(cursor.getString(1));
                    exercise.setSets(cursor.getString(2));
                    exercise.setReps(cursor.getString(3));
                    exercise.setStoredReps(cursor.getString(4));
                    exercise.setStoredWeight(cursor.getString(5));
                    exercise.setLink(cursor.getString(6));
                    exercise.setFragment(cursor.getString(7));
                    // Adding contact to list
                    exerciseList.add(exercise);
                } while (cursor.moveToNext());
            }

            // return contact list
            return exerciseList;
    }

    public ArrayList<Exercise> getExercisesA() {
        ArrayList<Exercise> exerciseList = new ArrayList<Exercise>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(
                TABLE_EXERCISES, null, KEY_FRAGMENT + "=?", new String[]{"A"}, null, null, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Exercise exercise = new Exercise();
                exercise.setId(Integer.parseInt(cursor.getString(0)));
                exercise.setName(cursor.getString(1));
                exercise.setSets(cursor.getString(2));
                exercise.setReps(cursor.getString(3));
                exercise.setStoredReps(cursor.getString(4));
                exercise.setStoredWeight(cursor.getString(5));
                exercise.setLink(cursor.getString(6));
                exercise.setFragment(cursor.getString(7));
                // Adding contact to list
                exerciseList.add(exercise);
            } while (cursor.moveToNext());
        }

        // return contact list
        return exerciseList;
    }

    public ArrayList<Exercise> getExercisesB() {
        ArrayList<Exercise> exerciseList = new ArrayList<Exercise>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(
                TABLE_EXERCISES, null, KEY_FRAGMENT + "=?", new String[]{"B"}, null, null, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Exercise exercise = new Exercise();
                exercise.setId(Integer.parseInt(cursor.getString(0)));
                exercise.setName(cursor.getString(1));
                exercise.setSets(cursor.getString(2));
                exercise.setReps(cursor.getString(3));
                exercise.setStoredReps(cursor.getString(4));
                exercise.setStoredWeight(cursor.getString(5));
                exercise.setLink(cursor.getString(6));
                exercise.setFragment(cursor.getString(7));
                // Adding contact to list
                exerciseList.add(exercise);
            } while (cursor.moveToNext());
        }

        // return contact list
        return exerciseList;
    }

    public ArrayList<Exercise> getExercisesC() {
        ArrayList<Exercise> exerciseList = new ArrayList<Exercise>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(
                TABLE_EXERCISES, null, KEY_FRAGMENT + "=?", new String[]{"C"}, null, null, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Exercise exercise = new Exercise();
                exercise.setId(Integer.parseInt(cursor.getString(0)));
                exercise.setName(cursor.getString(1));
                exercise.setSets(cursor.getString(2));
                exercise.setReps(cursor.getString(3));
                exercise.setStoredReps(cursor.getString(4));
                exercise.setStoredWeight(cursor.getString(5));
                exercise.setLink(cursor.getString(6));
                exercise.setFragment(cursor.getString(7));
                // Adding contact to list
                exerciseList.add(exercise);
            } while (cursor.moveToNext());
        }

        // return contact list
        return exerciseList;
    }

    // Getting contacts Count
    public int getExerciseCount() {
            String countQuery = "SELECT  * FROM " + TABLE_EXERCISES;
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(countQuery, null);
            cursor.close();

            // return count
            return cursor.getCount();
    }

    // Updating single exercise
    public int updateExercise(Exercise exercise) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_STOREDREPS, exercise.getStoredReps());
        values.put(KEY_STOREDWEIGHT, exercise.getStoredWeight());

        // updating row
        return db.update(TABLE_EXERCISES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(exercise.getId())});
    }

    // Deleting single exercise
    public void deleteExercise(Exercise exercise) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_EXERCISES, KEY_ID + " = ?",
                new String[] { String.valueOf(exercise.getId()) });
        db.close();
    }
}
