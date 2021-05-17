package sg.edu.np.practical2activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private final static String TAG = "Main Activity";
    private String number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "On Create Main Activity!");

        User user1 = new User("John","man",
                1001, false);

        Button button = findViewById(R.id.followbutton);

        TextView tv = findViewById(R.id.name123);
        TextView tv2 = findViewById(R.id.desc123);
        Bundle receiveData = getIntent().getExtras();
        String name = receiveData.getString("name");
        String desc = receiveData.getString("desc");
        tv.setText(name);
        tv2.setText(desc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (user1.isFollowed() == false) {
                    button.setText("Unfollow");
                    user1.setFollowed(true);
                    Toast.makeText(MainActivity.this,
                            "Followed!", Toast.LENGTH_SHORT).show();
                    Log.v(TAG, "Followed!");

                }
                else if (user1.isFollowed() == true) {
                    button.setText("Follow");
                    user1.setFollowed(false);
                    Toast.makeText(MainActivity.this,
                            "Unfollowed!", Toast.LENGTH_SHORT).show();
                    Log.v(TAG, "Unfollowed!");
                }
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "On Start!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "On Resume!");
    }

    @Override
    protected void onPause (){
        super.onPause();
        Log.v(TAG,"On Pause!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "On Stop!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "On Destroy!");
    }



}