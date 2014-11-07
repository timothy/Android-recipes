package edu.whitworth.list_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tbradford16 on 4/11/14.
 */
public class BangAdapter extends BaseAdapter {
    private List<bang> bangs;

    public BangAdapter(List<bang> bs) {
        bangs = bs;
    }

    @Override
    public int getCount() {
        return bangs.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout rootView = (LinearLayout) inflater.inflate(R.layout.list_item, parent, false);

        TextView tv = (TextView)rootView.findViewById(R.id.txtview);
        tv.setText((CharSequence) bangs.get(position).getRecipe());

        ImageView iv = (ImageView)rootView.findViewById(R.id.imgview);
        iv.setImageResource(bangs.get(position).getIconID());


        return rootView;
    }
}
