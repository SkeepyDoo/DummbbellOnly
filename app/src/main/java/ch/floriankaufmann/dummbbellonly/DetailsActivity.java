package ch.floriankaufmann.dummbbellonly;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String reps = "You should hit " + intent.getStringExtra("reps");
        this.setTitle(name);
        TextView textView = (TextView) findViewById(R.id.goal_reps);
        textView.setText(reps);
    }

    public void openLink(View v) {
        String link = getIntent().getStringExtra("link");
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));
    }
}
