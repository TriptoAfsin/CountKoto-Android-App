package newcampusa.newproject.countkoto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class useful_units extends AppCompatActivity {

    private EditText meter, yard, kg,lb;
    private ImageView meter_btn, yard_btn, kg_btn, lb_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useful_units);
        getSupportActionBar().setTitle("Unit Converter");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        meter = (EditText)findViewById(R.id.editText_meter);
        yard = (EditText)findViewById(R.id.editText_yard);
        kg = (EditText)findViewById(R.id.editText_kg);
        lb = (EditText)findViewById(R.id.editText_lb);

        meter_btn = (ImageView)findViewById(R.id.meter_convert_btn);
        yard_btn = (ImageView)findViewById(R.id.yard_convert_btn);
        kg_btn = (ImageView)findViewById(R.id.kg_convert_btn);
        lb_btn = (ImageView)findViewById(R.id.lb_convert_btn);



        meter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(meter.getText().toString().length() >0){
                    String meter_str = meter.getText().toString();
                    Double meter_value = Double.parseDouble(meter_str);
                    Double yard_converted_value = Math.round((meter_value*1.093613)*10000D)/10000D;
                    String yard_converted_str = yard_converted_value.toString();
                    yard.setText(yard_converted_str);
                }
                else{
                    Toast.makeText(useful_units.this, "Meter field is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
        yard_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(yard.getText().toString().length() >0){
                    String yard_str = yard.getText().toString();
                    Double yard_value = Double.parseDouble(yard_str);
                    Double meter_converted_value = Math.round((yard_value*0.9144)*10000D)/10000D;
                    String meter_converted_str = meter_converted_value.toString();
                    meter.setText(meter_converted_str);
                }
                else{
                    Toast.makeText(useful_units.this, "Yard field is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
        kg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(kg.getText().toString().length() >0){
                    String kg_str = kg.getText().toString();
                    Double kg_value = Double.parseDouble(kg_str);
                    Double lb_converted_value = Math.round((kg_value*2.2046)*10000D)/10000D;
                    String lb_converted_str = lb_converted_value.toString();
                    lb.setText(lb_converted_str);
                }
                else{
                    Toast.makeText(useful_units.this, "Kg field is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        lb_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lb.getText().toString().length() >0){
                    String lb_str = lb.getText().toString();
                    Double lb_value = Double.parseDouble(lb_str);
                    Double kg_converted_value = Math.round((lb_value*0.453592)*10000D)/10000D;
                    String kg_converted_str = kg_converted_value.toString();
                    kg.setText(kg_converted_str);
                }
                else{
                    Toast.makeText(useful_units.this, "Lb field is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
