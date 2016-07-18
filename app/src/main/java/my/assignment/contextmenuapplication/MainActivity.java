package my.assignment.contextmenuapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Contacts contacts;
    ArrayList<Contacts> contactList = new ArrayList<Contacts>();
    CustomeAdapter adapter;
    ListView lv;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lv = (ListView) findViewById(R.id.listview);

        contacts = new Contacts("Priyanka", "9652792707");
        contactList.add(contacts);
        contacts = new Contacts("Nitin", "9985942095");
        contactList.add(contacts);
        contacts = new Contacts("Abhinandan", "8149614526");
        contactList.add(contacts);
        contacts = new Contacts("Swathi", "9703636511");
        contactList.add(contacts);
        contacts = new Contacts("Sahil", "9652792707");
        contactList.add(contacts);
        contacts = new Contacts("Somesh", "9868105964");
        contactList.add(contacts);
        contacts = new Contacts("Arun", "9731007615");
        contactList.add(contacts);
        contacts = new Contacts("Deepa", "71569421615");
        contactList.add(contacts);
        adapter = new CustomeAdapter(this, contactList);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        menu.setHeaderTitle("Select the Action");
        menu.add(0, view.getId(), 0, "Call");
        menu.add(0, view.getId(), 0, "Send SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int i = info.position;
        Contacts c = (Contacts) lv.getItemAtPosition(i);
        String num = c.getPhone();


        if (item.getTitle() == "Call") {

            Toast.makeText(this, "Call " + num, Toast.LENGTH_SHORT).show();
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+num));
            startActivity(callIntent);


        } else if (item.getTitle() == "Send SMS") {
            Toast.makeText(this, "Send SMS to that number", Toast.LENGTH_SHORT).show();
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO);
            smsIntent.setData(Uri.parse("smsto:"+num));
            startActivity(smsIntent);
        } else
            return false;
        return true;
    }


}
