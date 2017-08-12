package lauraknight.todo_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class DisplayMessageActivity extends AppCompatActivity {
    MainActivity mainActivity;
    ArrayList<String> todos;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        mainActivity.readItems();

        Intent intent = getIntent();
        pos = intent.getIntExtra(MainActivity.TODO_INDEX, 0);
        String todo = todos.get(pos);

        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText(todo);
    }

    public void editTodo(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String todo = editText.getText().toString();

        todos.set(pos, todo);
        mainActivity.writeItems();
        super.finish();
    }

    public void deleteTodo() {

    }
}
