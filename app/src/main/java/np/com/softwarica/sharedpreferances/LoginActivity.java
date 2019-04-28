package np.com.softwarica.sharedpreferances;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText etusername,etpassword;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etpassword=findViewById(R.id.etpass);
        etusername=findViewById(R.id.etuname);
        btnlogin=findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckUser();
            }
        });
    }
    private void CheckUser(){
        SharedPreferences sharedPreferences =getSharedPreferences("user",MODE_PRIVATE);
        String username= sharedPreferences.getString("username","");
        String password= sharedPreferences.getString("password","");
        if (username.equals(etusername.getText().toString()) && password.equals(etpassword.getText().toString())){
            Toast.makeText(LoginActivity.this, "Successful", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(LoginActivity.this, "username or password mismatch", Toast.LENGTH_LONG).show();
        }
    }
}
