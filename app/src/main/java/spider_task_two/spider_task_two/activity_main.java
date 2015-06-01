package spider_task_two.spider_task_two;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.Toast;


public class activity_main extends Activity {

    private EditText edittext;
    private ListView lvfont;
    private Spinner spsize;
    private Spinner spcolor;

    private CheckBox boldcheckbox;
    private CheckBox italicscheckbox;

    public static String font[];
    public static String size[];
    public static String color[];
    String text;
    Intent i;


    String TAG_FONT = "FONT";
    String TAG_SIZE = "SIZE";
    String TAG_COLOR = "COLOR";
    String TAG_TEXT = "TEXT";
    String TAG_BOLD = "BOLD";
    String TAG_ITALICS = "ITALICS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_main);
        i = new Intent(activity_main.this, activity_show.class);

        edittext = (EditText)findViewById(R.id.editText);
        lvfont = (ListView)findViewById(R.id.listView);
        spsize = (Spinner)findViewById(R.id.spinner_size);
        spcolor = (Spinner)findViewById(R.id.spinner_color);

        boldcheckbox = (CheckBox)findViewById(R.id.checkBoxbold);
        italicscheckbox=(CheckBox)findViewById(R.id.checkBoxitalics);


        font = getResources().getStringArray(R.array.font);
        size = getResources().getStringArray(R.array.size);
        color = getResources().getStringArray(R.array.color);

        ArrayAdapter<String> font_adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,font );
        ArrayAdapter<String> size_adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, size);
        ArrayAdapter<String> color_adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, color);

        lvfont.setAdapter(font_adapter);
        spsize.setAdapter(size_adapter);
        spcolor.setAdapter(color_adapter);

        edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {



            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {





            }

            @Override
            public void afterTextChanged(Editable s) {
                text = s.toString();

                

                i.putExtra(TAG_TEXT, text);


            }
        });

        lvfont.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                i.putExtra(TAG_FONT, position);
                if((text!=null)){
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                }


                else
                    Toast.makeText(activity_main.this, R.string.no_text, Toast.LENGTH_LONG).show();
            }
        });

        spsize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                i.putExtra(TAG_SIZE, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spcolor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                i.putExtra(TAG_COLOR, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        boldcheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                i.putExtra(TAG_BOLD, isChecked);
            }
        });

        italicscheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                i.putExtra(TAG_ITALICS,isChecked);
            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
