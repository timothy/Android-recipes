package edu.whitworth.list_app;

import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return (id == R.id.action_settings) ? true : super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends ListFragment {


         private List<bang> myRecipeList = new ArrayList<bang>();


        public PlaceholderFragment() {
        }

        @Override
        public void onViewCreated (View view, Bundle savedInstanceState) {

            myRecipeList = new ArrayList<bang>();

            myRecipeList.add(new bang("Pizza", R.drawable.pizza));
            myRecipeList.add(new bang("Rice Pudding!", R.drawable.rice));
            myRecipeList.add(new bang("Cookies", R.drawable.cookies));
            myRecipeList.add(new bang("Brownies", R.drawable.brownie));
            myRecipeList.add(new bang("Pumpkin Pie", R.drawable.pie));


            setListAdapter(new BangAdapter(myRecipeList));

            ListView lv = getListView();
            lv.setTextFilterEnabled(true);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
                public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                    Intent i = new Intent(getActivity(), Recipe.class);
                   i.putExtra("position", pos);
                    startActivity(i);
              /*        Toast.makeText(view.getContext(), ((TextView) view).getText(),
                            Toast.LENGTH_SHORT).show();
*/
               }
         });
        }
    }

}
