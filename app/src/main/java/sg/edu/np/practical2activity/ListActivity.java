package sg.edu.np.practical2activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    ArrayList<User> myList = new ArrayList<>();
    private final static String TAG = "ListActivity";
    private UserAdapter.RecyclerViewCLickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        for (int i = 1; i < 21; i++){
            if (i % 2 == 0){
                User user = new User("Name " + String.valueOf(randomNum()),
                        "Desc " + String.valueOf(randomNum()),
                        i, true);
                myList.add(user);
            }
            else {
                User user = new User("Name"  + String.valueOf(randomNum()),
                        "Desc " + String.valueOf(randomNum()),
                        i, false);
                myList.add(user);
            }
        }

        setOnClickListener();

        RecyclerView recyclerView = findViewById(R.id.rView);
        UserAdapter myAdapter = new UserAdapter(myList, listener);
        LinearLayoutManager myLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(myLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);

        Log.v(TAG, "On Create List Activity!");
        int temp = myList.size();
        Log.v(TAG, String.valueOf(temp));

    }

    private void setOnClickListener() {
        listener = new UserAdapter.RecyclerViewCLickListener() {
            @Override
            public void onClick(View v, int pos) {
                ClickButton(pos);
            }
        };
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
    public int randomNum() {
        Random ran = new Random();
        int value = ran.nextInt(1000000000);
        return value;
    }

    private void ClickButton(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(myList.get(position).getName()).setCancelable(false);
        builder.setTitle("Profile");
        builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.v(TAG, "View Button Clicked!");
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                intent.putExtra("name", myList.get(position).getName());
                intent.putExtra("desc", myList.get(position).getDescription());
                startActivity(intent);
            }
        });
        builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.v(TAG, "Close Button Clicked!");
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

}