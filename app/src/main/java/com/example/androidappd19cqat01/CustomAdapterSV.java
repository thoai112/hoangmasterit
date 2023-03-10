package com.example.androidappd19cqat01;

import static androidx.core.content.ContextCompat.startActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapterSV extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<SinhVien> data;
    public CustomAdapterSV(@NonNull Context context, int resource, @NonNull ArrayList<SinhVien> data) {
        super(context,resource,data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Holder holder = new Holder();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, null);
            holder.ivGioiTinh = convertView.findViewById(R.id.ivGioiTinh);
            holder.tvHoTen = convertView.findViewById(R.id.tvHT);
            //holder.cbChon = convertView.findViewById(R.id.cbGioiTinh);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        SinhVien sv = data.get(position);
        holder.tvHoTen.setText(sv.getName());

        holder.btndetail = convertView.findViewById(R.id.btndtail);
        holder.btncall = convertView.findViewById(R.id.btncall);

        holder.btndetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Maindetail.class);
                intent.putExtra("msg",sv);
                context.startActivity(intent);
            }

        });
        holder.btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:123456789"));
                context.startActivity(intent);
            }

        });
        /*if (sv.getSex()) {
            holder.ivGioiTinh.setImageResource(R.drawable.baseline_man_50);
            holder.cbChon.setChecked(true);
        } else {
            holder.ivGioiTinh.setImageResource(R.drawable.baseline_woman_50);
            holder.cbChon.setChecked(false);
        }
        Holder finalHolder = holder;
        holder.cbChon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (finalHolder.cbChon.isChecked()) {
                    finalHolder.ivGioiTinh.setImageResource(R.drawable.baseline_man_50);
                } else {
                    finalHolder.ivGioiTinh.setImageResource(R.drawable.baseline_woman_50);
                }
            }
        });*/
        return convertView;
    }
    class Holder {
        ImageView ivGioiTinh;
        TextView tvHoTen;
        //CheckBox cbChon;
        Button btndetail;
        Button btncall;
    }
}
