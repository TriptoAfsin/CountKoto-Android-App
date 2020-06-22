package newcampusa.newproject.countkoto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class count2length extends AppCompatActivity {

    private EditText count, weight;
    private Button calc_length_btn;
    private TextView output_length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count2length);
        getSupportActionBar().setTitle("Count to Length");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        count = (EditText)findViewById(R.id.count_count2length);
        weight = (EditText)findViewById(R.id.weight_count2length);

        calc_length_btn  = (Button)findViewById(R.id.count2length_btn);

        output_length = (TextView)findViewById(R.id.output_count2length);

        calc_length_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count.getText().toString().length() <= 0 || count == null){
                    Toast.makeText(count2length.this, "Count field is empty", Toast.LENGTH_SHORT).show();
                }
                else if(weight.getText().toString().length() <= 0 || weight == null){
                    Toast.makeText(count2length.this, "Weight field is empty", Toast.LENGTH_SHORT).show();
                }

                else{
                    String count_str = count.getText().toString();
                    String weight_str = weight.getText().toString();
                    Double count_value = Double.parseDouble(count_str);
                    Double weight_value = Double.parseDouble(weight_str);
                    Double length = Math.round(((count_value*840)*(weight_value))*1000D)/1000D;

                    output_length.setVisibility(View.VISIBLE);
                    output_length.setText(length.toString()+" yds");
                }

            }
        });
    }
}
