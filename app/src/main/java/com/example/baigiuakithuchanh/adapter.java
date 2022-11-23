package com.example.baigiuakithuchanh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class adapter extends BaseAdapter {
    private Context context;
    private int layout;
    public List<person> arraylist;

    public adapter(Context context, int layout, List<person> arraylist) {
        this.context = context;
        this.layout = layout;
        this.arraylist = arraylist;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView =inflater.inflate(layout,null);
        person person =  arraylist.get(position);

        TextView txtname =convertView.findViewById(R.id.txtname);
        TextView txtcapbac =convertView.findViewById(R.id.txtcapbac);
        TextView txtvitri =convertView.findViewById(R.id.txtvitri);
        ImageView imagehinh = convertView.findViewById(R.id.imageHinh);
        ImageView btnvn = convertView.findViewById(R.id.btnadd);
        ImageView btndanhgia = convertView.findViewById(R.id.danhgia);

        txtname.setText(person.getName());
        txtcapbac.setText(person.getCapbac());
        txtvitri.setText(person.getVitri());
        imagehinh.setImageResource(person.getHinh());

        btnvn.setImageResource(person.getVn());
        btndanhgia.setImageResource(person.getDanhgia());


        return convertView;
    }
}
