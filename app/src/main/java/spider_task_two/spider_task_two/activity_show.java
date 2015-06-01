package spider_task_two.spider_task_two;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;


public class activity_show extends Activity {

    private EditText text;
    private Button exit_button;
    boolean bold;
    boolean italics;
    Typeface tf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_show);

        text = (EditText)findViewById(R.id.show_text);
        exit_button = (Button)findViewById(R.id.button_exit);

        text.setText(getIntent().getStringExtra("TEXT"));



        int size = Integer.parseInt(activity_main.size[getIntent().getIntExtra("SIZE", 0)]);
        text.setTextSize(size);

        int pos_color = getIntent().getIntExtra("COLOR",0);
        displaycolor(pos_color);

        int pos_font = getIntent().getIntExtra("FONT",0);
        tf = Typeface.createFromAsset(getAssets(), displayfont(pos_font));

        bold = getIntent().getBooleanExtra("BOLD", false);
        italics = getIntent().getBooleanExtra("ITALICS", false);

        setTypeface();


        exit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });





    }

    public void displaycolor(int pos_color)
    {
        switch(pos_color)
        {
            case 0: {
                text.setTextColor(Color.BLUE);
                break;
            }

            case 1: {
                text.setTextColor(Color.RED);
                break;
            }

            case 2: {
                text.setTextColor(Color.YELLOW);
                break;
            }
            case 3:{
                text.setTextColor(Color.CYAN);
                break;
            }
            case 4:{
                text.setTextColor(Color.GREEN);
                break;
            }
            case 5:{
                text.setTextColor(Color.GRAY);
                break;
            }


        }
    }

    public String displayfont(int pos_font)
    {
        Typeface tf;

        switch(pos_font)
        {
            case 0:
            {
                return "timeroman.ttf";


            }
            case 1:
            {
                return "LDFComicSansBold.ttf";

            }

            case 2:
            {
                return "cosmicspam.ttf";

            }

            case 3:
            {
                return "flower.ttf";
            }

            case 4:
            {
                return "cartoon.ttf";
            }

            case 5:
            {
                return "Debbie-Normal.ttf";
            }

            default:
            {
               return "Dion.ttf";
            }

        }

    }

    public void setTypeface()
    {
        if(bold&&italics)
        {
            text.setTypeface(tf , tf.BOLD_ITALIC);
        }
        else if (bold)
        {
            text.setTypeface(tf , tf.BOLD);
        }
        else if (italics)
        {
            text.setTypeface(tf , tf.ITALIC);
        }
        else
        {
            text.setTypeface(tf);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_show, menu);
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
