package ch.floriankaufmann.dummbbellonly;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ExerciseAdapter extends ArrayAdapter<Exercise> {

    private SharedPreferences mSharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Reps = "repsKey";


    public ExerciseAdapter(Activity context, ArrayList<Exercise> exercises) {
        super(context, 0, exercises);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final Exercise currentExercise = getItem(position);
        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("name", currentExercise.getName());
                intent.putExtra("reps", currentExercise.getReps());
                intent.putExtra("sets", currentExercise.getSets());
                intent.putExtra("link", currentExercise.getLink());
                getContext().startActivity(intent);
            }
        });

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);
        nameTextView.setText(currentExercise.getName());

        TextView setsTextView = (TextView) listItemView.findViewById(R.id.sets);
        setsTextView.setText(currentExercise.getSets());

        TextView repsTextView = (TextView) listItemView.findViewById(R.id.reps);
        repsTextView.setText(currentExercise.getReps());

        return listItemView;
    }
}
