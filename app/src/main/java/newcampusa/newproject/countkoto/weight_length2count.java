package newcampusa.newproject.countkoto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class weight_length2count extends AppCompatActivity {

    private EditText length, weight;
    private Button calc_count_btn;
    private TextView output_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_length2count);
        getSupportActionBar().setTitle("Weight, Length to Count");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        length = (EditText)findViewById(R.id.length_wt_lt_count);
        weight = (EditText)findViewById(R.id.weight_wt_lt_count);

        calc_count_btn  = (Button)findViewById(R.id.lt_wt_btn);

        output_count = (TextView)findViewById(R.id.output_count);

        calc_count_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(length.getText().toString().length() <= 0 || length == null){
                    Toast.makeText(weight_length2count.this, "Length field is empty", Toast.LENGTH_SHORT).show();
                }
                else if(weight.getText().toString().length() <= 0 || length == null){
                    Toast.makeText(weight_length2count.this, "Weight field is empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    String length_str = length.getText().toString();
                    String weight_str = weight.getText().toString();
                    Double length_value = Double.parseDouble(length_str);
                    Double weight_value = Double.parseDouble(weight_str);
                    Double count = Math.round(((length_value)/(weight_value*840))*1000D)/1000D;

                    output_count.setVisibility(View.VISIBLE);
                    output_count.setText(count.toString()+" Ne");
                }
            }
        });
    }
}
