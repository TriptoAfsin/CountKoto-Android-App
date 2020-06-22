package newcampusa.newproject.countkoto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class count2weight extends AppCompatActivity {

    private EditText length, count;
    private Button calc_weight_btn;
    private TextView output_weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count2weight);
        getSupportActionBar().setTitle("Count to Weight");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        count = (EditText)findViewById(R.id.count_count2weight);
        length = (EditText)findViewById(R.id.length_count2weight);

        calc_weight_btn  = (Button)findViewById(R.id.count2weight_btn);

        output_weight = (TextView)findViewById(R.id.output_weight);

        calc_weight_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count.getText().toString().length() <= 0 || count == null){
                    Toast.makeText(count2weight.this, "Count field is empty", Toast.LENGTH_SHORT).show();
                }
                else if(length.getText().toString().length() <= 0 || length == null){
                    Toast.makeText(count2weight.this, "Length field is empty", Toast.LENGTH_SHORT).show();
                }

                else{
                    String length_str = length.getText().toString();
                    String count_str = count.getText().toString();
                    Double length_value = Double.parseDouble(length_str);
                    Double count_value = Double.parseDouble(count_str);
                    Double weight = Math.round(((length_value)/(count_value*840))*1000D)/1000D;

                    output_weight.setVisibility(View.VISIBLE);
                    output_weight.setText(weight.toString()+" lbs");
                }
            }
        });
    }
}
