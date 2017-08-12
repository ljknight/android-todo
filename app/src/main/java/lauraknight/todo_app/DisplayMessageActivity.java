package lauraknight.todo_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static lauraknight.todo_app.MainActivity.TODO_INDEX;

public class DisplayMessageActivity extends AppCompatActivity {
    ArrayList<String> todos;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        readItems();

        Intent intent = getIntent();
        pos = intent.getIntExtra(TODO_INDEX, 0);
        String todo = todos.get(pos);

        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText(todo);
        editText.setSelection(editText.getText().length());
    }

    public void editTodo(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String todo = editText.getText().toString();

        todos.set(pos, todo);
        writeItems();
        finish();
    }

    public void deleteTodo(View view) {
        todos.remove(pos);
        writeItems();
        finish();
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
