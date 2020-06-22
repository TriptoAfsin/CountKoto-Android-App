package newcampusa.newproject.countkoto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class fabric_calc extends AppCompatActivity {

    private EditText epi, ppi;
    private Button calc_ends_btn;
    private TextView output_ends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabric_calc);
        getSupportActionBar().setTitle("Total Ends Calc.");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        epi = (EditText)findViewById(R.id.epi);
        ppi = (EditText)findViewById(R.id.ppi);
        calc_ends_btn = (Button)findViewById(R.id.total_ends_btn);
        output_ends = (TextView)findViewById(R.id.output_total_ends);

        calc_ends_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(epi == null && epi.getText().toString().length() <= 0){
                    Toast.makeText(fabric_calc.this, "EPI & PPI field is empty", Toast.LENGTH_SHORT).show();
                }
                else if(epi == null){
                    Toast.makeText(fabric_calc.this, "EPI field is empty", Toast.LENGTH_SHORT).show();
                }
                else if(ppi == null || ppi.getText().toString().length() <= 0){
                    Toast.makeText(fabric_calc.this, "PPI field is empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    String epi_str = epi.getText().toString();
                    String ppi_str = ppi.getText().toString();
                    Double epi_value = Double.parseDouble(epi_str);
                    Double ppi_value = Double.parseDouble(ppi_str);
                    Double ends_value = epi_value * ppi_value;
                    output_ends.setText(ends_value.toString());
                }

            }
        });
    }
}
