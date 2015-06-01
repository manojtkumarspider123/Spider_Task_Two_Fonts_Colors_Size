package spider_task_two.spider_task_two;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.widget.TextView;
import android.graphics.Color;


public class activity_show extends Activity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_show);

        textView = (TextView)findViewById(R.id.show_text);
        textView.setText(getIntent().getStringExtra("TEXT"));

        int size = Integer.parseInt(activity_main.size[getIntent().getIntExtra("SIZE", 0)]);
        textView.setTextSize(size);

        int pos_color = getIntent().getIntExtra("COLOR",0);
        displaycolor(pos_color);

        int pos_font = getIntent().getIntExtra("FONT",0);
        Typeface tf = Typeface.createFromAsset(getAssets(), displayfont(pos_font));
        textView.setTypeface(tf);







    }

    public void displaycolor(int pos_color)
    {
        switch(pos_color)
        {
            case 0: {
                textView.setTextColor(Color.BLUE);
                break;
            }

            case 1: {
                textView.setTextColor(Color.RED);
                break;
            }

            case 2: {
                textView.setTextColor(Color.YELLOW);
                break;
            }
            case 3:{
                textView.setTextColor(Color.CYAN);
                break;
            }
            case 4:{
                textView.setTextColor(Color.GREEN);
                break;
            }
            case 5:{
                textView.setTextColor(Color.GRAY);
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
