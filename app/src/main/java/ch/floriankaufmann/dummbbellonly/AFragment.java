package ch.floriankaufmann.dummbbellonly;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AFragment extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_a, container, false);

        DatabaseHandler db = new DatabaseHandler(getActivity());

        if (isfirstTime()) {

            db.addExercise(new Exercise("Dumbbell Squat", "3 Sets", "6-12 Reps", 0, 0, "http://bit.ly/2dRdiz8"));
            db.addExercise(new Exercise("Dumbbell Bench Press", "3 Sets", "6-12 Reps", 0, 0, "http://bit.ly/2e1zPIF"));
            db.addExercise(new Exercise("One Arm Dumbbell Row", "3 Sets", "6-12 Reps", 0, 0, "http://bit.ly/2dK3wK7"));
            db.addExercise(new Exercise("Standing Dumbbell Curl", "3 Sets", "6-12 Reps", 0, 0, "http://bit.ly/2deVOrr"));
            db.addExercise(new Exercise("Two Arm Seated Dumbbell Extension", "3 Sets", "6-12 Reps", 0, 0, "http://bit.ly/2dvyCHf"));
            db.addExercise(new Exercise("Sit Up", "3 Sets", "10-25 Reps", 0, 0, "http://bit.ly/2dsR58O"));
        }

        ArrayList<Exercise> exercises = db.getAllExercises();

        ExerciseAdapter adapter = new ExerciseAdapter(getActivity(), exercises);

        ListView listView = (ListView) rootView.findViewById(R.id.a_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return rootView;
    }

    private boolean isfirstTime() {
        SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("RanBefore", false);
        if (!ranBefore) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore", true);
            editor.commit();
        }
        return !ranBefore;
    }
}
