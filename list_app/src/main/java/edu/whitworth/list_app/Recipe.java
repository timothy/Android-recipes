package edu.whitworth.list_app;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Recipe extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.recipe, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private List<bang> myRecipe = new ArrayList<bang>();

       private void populateRecipeList(){

        myRecipe.add(new bang("Pizza!!!\n 3 boneless chicken breast halves, cooked and cubed \n" +
                " 1 cup hickory flavored barbeque sauce                 \n" +
                " 1 tablespoon honey                                    \n" +
                " 1 teaspoon molasses                                   \n" +
                " 1/3 cup brown sugar                                   \n" +
                " 1/2 bunch fresh cilantro, chopped                     \n" +
                " 1 (12 inch) pre-baked pizza crust                     \n" +
                " 1 cup smoked Gouda cheese, shredded                   \n" +
                " 1 cup thinly sliced red onion                         \n", R.drawable.pizza));

        myRecipe.add(new bang("Rice Pudding!!!   \n 1 quart whole milk        \n" +
                "1 cup short-grain or long-grain white rice     \n" +
                "6 tablespoons granulated sugar                 \n" +
                "Pinch salt                                     \n" +
                "1/4 teaspoon vanilla or almond extract         \n" +
                "Toppings such as chopped nuts, dried or fresh fruit\n, cinnamon, or nutmeg (optional)\n", R.drawable.rice));

        myRecipe.add(new bang("COOKIES!!! \n 3/4 cup white sugar      \n" +
                "1 cup brown sugar                      \n" +
                "1 cup butter, softened                 \n" +
                "1 tablespoon vanilla                   \n" +
                "2 large eggs, slightly beaten          \n" +
                "3 cups all-purpose flour               \n" +
                "3/4 teaspoon baking soda               \n" +
                "3/4 teaspoon salt                      \n" +
                "3 cups semi-sweet chocolate chips      \n" +
                "1 cup walnuts, chopped or 1 cup pecans \n", R.drawable.cookies));

        myRecipe.add(new bang("Brownies!!!\n 1. Preheat oven to 350 degrees.  \n" +
                "2. Cream sugars and butter.                                                   \n" +
                "3. Add vanilla and eggs and mix well.                                         \n" +
                "4. Combine dry ingredients together and\ngradually add to creamed mixture.     \n" +
                "5. Stir in chips and nuts.                                                    \n" +
                "6. Roll into 1 1/4 balls and place \non non-stick cookie sheets, about 2 apart. \n" +
                "7. Bake for 10 to 12 minutes.", R.drawable.brownie));

        myRecipe.add(new bang("Pumpkin pie!!! \n 1 pound unsalted butter  \n" +
                "1 pound plus 12 ounces semisweet chocolate  chips\n" +
                "6 ounces unsweetened chocolate                   \n" +
                "6 extra-large eggs                               \n" +
                "3 tablespoons instant coffee granules            \n" +
                "2 tablespoons pure vanilla extract               \n" +
                "2 1/4 cups sugar                                 \n" +
                "1 1/4 cups all-purpose flour                     \n" +
                "1 tablespoon baking powder                       \n" +
                "1 teaspoon salt                                  \n" +
                "3 cups chopped walnuts                           \n", R.drawable.pie));
      }

        public PlaceholderFragment() {

            populateRecipeList();

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_recipe, container, false);

            Intent i = this.getActivity().getIntent();

            int num = i.getIntExtra("position",0);

            TextView tv = (TextView)rootView.findViewById(R.id.test);

            ImageView iv = (ImageView)rootView.findViewById(R.id.imageView);

            tv.setText(myRecipe.get(num).getRecipe());

            iv.setImageResource(myRecipe.get(num).getIconID());


            return rootView;
        }
    }

}
