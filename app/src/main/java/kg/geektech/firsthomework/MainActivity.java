package kg.geektech.firsthomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText gmailBox, themeMail, textMail;
    private Button sendMail;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gmailBox = findViewById(R.id.et_gmailBox);
        themeMail = findViewById(R.id.et_themeGmail);
        textMail = findViewById(R.id.et_textGmail);
        sendMail = findViewById(R.id.button_sendMail);

        intent = new Intent(Intent.ACTION_SEND);
        sendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {gmailBox.getText().toString()});
                intent.putExtra(Intent.EXTRA_SUBJECT, themeMail.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, textMail.getText().toString());
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });


    }
}