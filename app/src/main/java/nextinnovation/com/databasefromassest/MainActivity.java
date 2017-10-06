package nextinnovation.com.databasefromassest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private RecyclerView recyclerView ;
    private ArrayList<Student> students ;
    private DatabaseAccess databaseAccess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadRecyclerView();
        this.listView = (ListView) findViewById(R.id.listView);
        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> quotes = databaseAccess.getStudent();
        databaseAccess.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, quotes);
        this.listView.setAdapter(adapter);
    }

    private void loadRecyclerView() {
        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        students = databaseAccess.getStudentInfo() ;
        databaseAccess.close();
        recyclerView = (RecyclerView) findViewById(R.id.recylerView);
        RecyclerAdapter adapter = new RecyclerAdapter(this,students );
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}