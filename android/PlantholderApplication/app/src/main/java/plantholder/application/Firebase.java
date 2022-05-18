package plantholder.application;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.HashMap;
import java.util.Objects;

public class Firebase extends AppCompatActivity {

    DatabaseReference myDatabase;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

    }

    public void getDatabase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://planty-9e09f-default-rtdb.europe-west1.firebasedatabase.app/");
        myDatabase = database.getReference("Plants");
    }

    public void writeNewPlant(String ID,String species, int row, int column, String selectedHealth){
        getDatabase();

        Plants plant = new Plants(ID,species,row,column,selectedHealth);
        myDatabase.child(ID).setValue(plant);

    }

    public void updatePlantHealth(String ID, String status){
        getDatabase();
        myDatabase.child(ID).child("health").setValue(status);

    }


}
