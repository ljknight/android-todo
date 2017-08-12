package lauraknight.todo_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TODO_INDEX = "todoIndex";
    ArrayList<String> todos;
    ArrayAdapter<String> todosAdapter;
    ListView listViewTodos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewTodos = (ListView) findViewById(R.id.listView);
        readItems();
        todosAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todos);

        listViewTodos.setAdapter(todosAdapter);
        setupListViewListener();
    }

    @Override
    public void onRestart() {
        super.onRestart();

        readItems();
        todosAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todos);
        listViewTodos.setAdapter(todosAdapter);
    }

    private void setupListViewListener() {
        listViewTodos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
            public void onItemClick(AdapterView<?> adapter, View todo, int pos, long id) {
               openEdit(pos);
           }
        });
    }

    public void addTodo(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String todo = editText.getText().toString();

        todosAdapter.add(todo);
        editText.setText("");
        writeItems();
    }

    public void openEdit(int pos) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(TODO_INDEX, pos);
        startActivity(intent);
    }

    public void readItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");

        try {
            todos = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch(IOException e) {
            todos = new ArrayList<String>();
        }
    }

    public void writeItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");

        try {
            FileUtils.writeLines(todoFile, todos);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}


