package ch.floriankaufmann.dummbbellonly;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CFragment extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_c, container, false);

        DatabaseHandler db = new DatabaseHandler(getActivity());

        if (isfirstTime()) {

            db.addExercise(new Exercise("Dumbbell Lunge", "3 Sets", "6-12 Reps", "0", "0", "http://bit.ly/2e2hlru", "C"));
            db.addExercise(new Exercise("Dumbbell Floor Press", "3 Sets", "6-12 Reps", "0", "0", "http://bit.ly/2cSKLYQ", "C"));
            db.addExercise(new Exercise("Wide Grip Pull Up", "3 Sets", "6-12 Reps", "0", "0", "http://bit.ly/2cTucav", "C"));
            db.addExercise(new Exercise("Standing Hammer Curl", "3 Sets", "6-12 Reps", "0", "0", "http://bit.ly/2e2iEql", "C"));
            db.addExercise(new Exercise("Lying Dumbbell Extension", "3 Sets", "6-12 Reps", "0", "0", "http://bit.ly/2cTttWG", "C"));
            db.addExercise(new Exercise("Lying Floor Leg Raise", "3 Sets", "10-25 Reps", "0", "0", "http://bit.ly/2dSx61x", "C"));
        }

        ArrayList<Exercise> exercises = db.getExercisesC();

        ExerciseAdapter adapter = new ExerciseAdapter (getActivity(), exercises);

        ListView listView = (ListView) rootView.findViewById(R.id.c_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=cxLG2wtE7TM")));
            }
        });

        return rootView;
    }

    private boolean isfirstTime() {
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("RanBefore3", false);
        if (!ranBefore) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore3", true);
            editor.commit();
        }
        return !ranBefore;
    }
}