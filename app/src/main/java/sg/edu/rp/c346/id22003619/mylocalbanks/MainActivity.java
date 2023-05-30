package sg.edu.rp.c346.id22003619.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String wordClicked = "";
    Boolean checkFavDBS=false;
    Boolean checkFavOCBC=false;
    Boolean checkFavUOB=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDBS = findViewById(R.id.tvDBS);
        tvOCBC = findViewById(R.id.tvOCBC);
        tvUOB = findViewById(R.id.tvUOB);
        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Visit Website");
        menu.add(0, 1, 1, "Contact the bank");
        menu.add(0, 2, 2, "Toggle favourite");
        if (v == tvDBS) {
            wordClicked = "DBS";
        } else if (v == tvOCBC) {
            wordClicked = "OCBC";
        } else if (v == tvUOB) {
            wordClicked = "UOB";
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.myanmarSelection) {
            Toast.makeText(MainActivity.this, "မြန်မာဘာသာအားရွေးချယ်ထားပါသည်။", Toast.LENGTH_SHORT).show();
            tvDBS.setText("ဒီဘီအက်စ်");
            tvOCBC.setText("အိုစီဘီစီ");
            tvUOB.setText("ယူအိုဘီ");
            return true;
        } else {
            tvDBS.setText("Error translation");
            tvOCBC.setText("Error translation");
            tvUOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked =="DBS") {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }else if (item.getItemId() == 2) {
                checkFavDBS=!checkFavDBS;
                checkFav(tvDBS,checkFavDBS);
                return true;  //menu item successfully handled
            }
        } if (wordClicked == "OCBC") {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }else if (item.getItemId() == 2) {
                checkFavOCBC=!checkFavOCBC;
                checkFav(tvOCBC,checkFavOCBC);
                return true;  //menu item successfully handled
            }
        } if (wordClicked == "UOB") {
                if (item.getItemId() == 0) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                    startActivity(intent);

                    return true; //menu item successfully handled
                } else if (item.getItemId() == 1) {
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                    startActivity(intentCall);

                    return true;  //menu item successfully handled
                }else if (item.getItemId() == 2) {
                    checkFavUOB=!checkFavUOB;
                    checkFav(tvUOB,checkFavUOB);
                    return true;  //menu item successfully handled
                }
            }
            return super.onContextItemSelected(item); //pass menu item to the superclass implementation


    }
    private void checkFav(TextView tv,Boolean b){
        if(b==true){
            tv.setTextColor((Color.parseColor("#FF0000")));
            Toast.makeText(MainActivity.this, "Added to favorites", Toast.LENGTH_SHORT).show();
        }else{
            tv.setTextColor((Color.parseColor("#000000")));
            Toast.makeText(MainActivity.this, "Removed favorites", Toast.LENGTH_SHORT).show();

        }
    }
}

