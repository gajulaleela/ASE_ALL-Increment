package mpg12.ase.umkc.sqllite;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends ActionBarActivity implements View.OnClickListener {


        EditText name,uname,paswd,mail,phno,cnfpwd;
        String user_name,user1_name,user_paswd,user_mail,user_phno,cnf_pwd;
        Button reg;
        Context ctx= this;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            name = (EditText) findViewById(R.id.regname);
            uname= (EditText) findViewById(R.id.regusername);
            paswd=(EditText)findViewById(R.id.regpassword);
            cnfpwd=(EditText)findViewById(R.id.cnfpassword);
            mail=(EditText)findViewById(R.id.mailid);
            phno=(EditText)findViewById(R.id.regphnum);
            reg=(Button)findViewById(R.id.submit);
            reg.setOnClickListener(this);




                }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_login, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

    @Override
    public void onClick(View v) {
        user_name = name.getText().toString();
        user1_name = uname.getText().toString();
        user_paswd = paswd.getText().toString();
        cnf_pwd=cnfpwd.getText().toString();
        user_mail = mail.getText().toString();
        user_phno = phno.getText().toString();
        if(!(user_paswd.equals(cnf_pwd))) {
            Toast.makeText(getBaseContext(), "Password are not matching", Toast.LENGTH_LONG).show();
            name.setText("");
            uname.setText("");
            paswd.setText("");
            cnfpwd.setText("");
            mail.setText("");
            phno.setText("");
        }
        else{
            DatabaseOperation db = new DatabaseOperation(ctx);
            db.putInformation(db,user_name,user1_name,user_paswd,cnf_pwd,user_mail,user_phno);
            Toast.makeText(getBaseContext(), "RegistrationSuccess", Toast.LENGTH_LONG).show();
            finish();
            Intent i = new Intent(this,SuccessRegister.class);
            startActivity(i);

        }
    }
}
