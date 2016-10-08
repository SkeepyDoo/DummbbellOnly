package ch.floriankaufmann.dummbbellonly;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private EditText repsEditText;
    private EditText weightEditText;
    Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mIntent = getIntent();
        String name = mIntent.getStringExtra("name");
        Log.d("name: ", name);
        String reps = "You should hit " + mIntent.getStringExtra("reps");

        repsEditText = (EditText) findViewById(R.id.reps_edit_text);
        repsEditText.addTextChangedListener(mTextEditorWatcher);
        String storedReps = mIntent.getStringExtra("storedReps");
        if (!storedReps.equals("0")) {
            repsEditText.setText(storedReps, TextView.BufferType.EDITABLE);
        }

        weightEditText = (EditText) findViewById(R.id.weight_edit_text);
        weightEditText.addTextChangedListener(mTextEditorWatcher);
        String storedWeight = mIntent.getStringExtra("storedWeight");
        if (!storedReps.equals("0")) {
            weightEditText.setText(storedWeight, TextView.BufferType.EDITABLE);
        }

        this.setTitle(name);
        TextView textView = (TextView) findViewById(R.id.goal_reps);
        textView.setText(reps);
    }

    public void openLink(View v) {
        String link = getIntent().getStringExtra("link");
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));
    }


    private final TextWatcher mTextEditorWatcher = new TextWatcher() {

        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count)
        {

        }

        public void afterTextChanged(Editable s)
        {
            String repsText = String.valueOf(repsEditText.getText());
            String weightText = String.valueOf(weightEditText.getText());
            Log.d("reps: ", weightText);
            DatabaseHandler db = new DatabaseHandler(getBaseContext());
            int id = mIntent.getIntExtra("id", 0);
            Log.d("id: ", String.valueOf(id));
            Exercise exercise = db.getExercise(id);
            exercise.setStoredReps(repsText);
            exercise.setStoredWeight(weightText);
            db.updateExercise(exercise);
            db.close();
        }
    };
}
