package ch.floriankaufmann.dummbbellonly;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BFragment extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_b, container, false);

        DatabaseHandler db = new DatabaseHandler(getActivity());

        if (isfirstTime()) {

            db.addExercise(new Exercise("Dumbbell Step Up", "3 Sets", "6-12 Reps", "0", "0", "http://bit.ly/2dRSkjB", "B"));
            db.addExercise(new Exercise("Dumbbell Stiff Leg Deadlift", "3 Sets", "6-12 Reps", "0", "0", "http://bit.ly/2dK5uua", "B"));
            db.addExercise(new Exercise("Seated Dumbbell Press", "3 Sets", "6-12 Reps", "0", "0", "http://bit.ly/2dsSw75", "B"));
            db.addExercise(new Exercise("Standing One Leg Dumbbell Calf Raise", "3 Sets", "10-20 Reps", "0", "0", "http://bit.ly/2dKJSD3", "B"));
            db.addExercise(new Exercise("Dumbbell Shrug", "3 Sets", "10-15 Reps", "0", "0", "http://bit.ly/2dSvMvm", "B"));
            db.addExercise(new Exercise("Dumbbell Side Bends", "3 Sets", "10-15 Reps", "0", "0", "http://bit.ly/2cTryl2", "B"));
        }

        ArrayList<Exercise> exercises = db.getExercisesB();

        ExerciseAdapter adapter = new ExerciseAdapter (getActivity(), exercises);

        ListView listView = (ListView) rootView.findViewById(R.id.b_list);

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
        boolean ranBefore = preferences.getBoolean("RanBefore2", false);
        if (!ranBefore) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore2", true);
            editor.commit();
        }
        return !ranBefore;
    }
}

