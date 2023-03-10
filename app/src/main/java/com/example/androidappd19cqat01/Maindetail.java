package com.example.androidappd19cqat01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Maindetail extends AppCompatActivity {
    EditText edtMaSV, edtTenSV, edtNgaySinh;
    ImageView ivGioitinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maindetail);
        setContorl();
        setEvent();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       // Toast.makeText(this,sv.toString(), Toast.LENGTH_SHORT).show();
    }

    private void setEvent() {
        SinhVien sv = (SinhVien) getIntent().getSerializableExtra("msg");
        edtMaSV.setText(sv.getId());
        edtTenSV.setText(sv.getName());
        edtNgaySinh.setText(sv.getBirthDate());
        if(sv.getSex()){
            ivGioitinh.setImageResource(R.drawable.baseline_man_50);
        }
        else{
            ivGioitinh.setImageResource(R.drawable.baseline_woman_50);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.mnThongbao:
                Toast.makeText(this, "Thoong bao", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnprint:
                Toast.makeText(this, "Thoong tin", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setContorl() {
        edtMaSV = findViewById(R.id.edtMaSV);
        edtTenSV = findViewById(R.id.edtTenSV);
        edtNgaySinh = findViewById(R.id.edtNgaySinh);
        ivGioitinh = findViewById(R.id.ivGioiTinh);
    }
}