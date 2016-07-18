package my.assignment.contextmenuapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by root on 7/17/16.
 */

public class CustomeAdapter extends BaseAdapter {
    ArrayList<Contacts> data;
    Context context;
    private static LayoutInflater inflater=null;



    public CustomeAdapter(Context context, ArrayList<Contacts> list){

        this.context=context;
        this.data=list;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView tv1;
        TextView tv2;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.list_view, null);
        holder.tv1=(TextView) rowView.findViewById(R.id.textView);
        holder.tv2=(TextView) rowView.findViewById(R.id.textView2);

        holder.tv1.setText(data.get(position).getName());
        holder.tv2.setText(data.get(position).getPhone());

        return rowView;
    }
}
