package mpg12.ase.umkc.sqllite;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    public static  String NAME ="";

        Button login, register;
        EditText user_name,user_pwd;
        String username,userpwd;
        Context ctx=this;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            login=(Button)findViewById(R.id.button);
            register=(Button)findViewById(R.id.button2);
            user_name=(EditText)findViewById(R.id.editText);
            user_pwd=(EditText)findViewById(R.id.editText2);
            register.setOnClickListener(this);

            login.setOnClickListener(this);



           /* register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.button2:
                            Intent i = new Intent(this,Login.class);
                            startActivity(i);
                            break;
                        default:
                            break;
                    }
                }
            });*/

        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
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
        switch (v.getId()){
            case R.id.button:
                username=user_name.getText().toString();
                userpwd=user_pwd.getText().toString();
                DatabaseOperation dob = new DatabaseOperation(ctx);
                Cursor cr = dob.getInformation(dob);
                cr.moveToFirst();
                boolean login_status = false;

                do{
                    if(username.equals(cr.getString(1))&& userpwd.equals(cr.getString(2)))
                    {
                        login_status=true;
                        NAME=cr.getString(0);
                    }
                }
                while(cr.moveToNext());
                if(login_status)
                {
                    Toast.makeText(getBaseContext(),"Login Success.....\n"+NAME,Toast.LENGTH_LONG).show();
                    finish();
                    Intent i = new Intent(this,Home.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getBaseContext(),"Login failed",Toast.LENGTH_LONG).show();
                    finish();
                }
                break;
            case R.id.button2:
                Intent i = new Intent(this,Login.class);
                startActivity(i);
                break;
            default:
                break;
        }
        }
    }
