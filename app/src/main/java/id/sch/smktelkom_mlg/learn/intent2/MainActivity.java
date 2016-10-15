package id.sch.smktelkom_mlg.learn.intent2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        findViewById(R.id.buttonInput).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, InputActivity.class), REQUEST_CODE);
            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String nama = data.getStringExtra(InputActivity.NAMA);
                int thnLhr = data.getIntExtra(InputActivity.TAHUN_LAHIR, 0);
                TextView tvBiodata = (TextView) findViewById(R.id.textViewBiodata);
                tvBiodata.setText("Nama\t\t\t\t\t\t\t\t: " + nama + "\nTahun Kelahiran\t: " + thnLhr);

            }
        }
    }
}
