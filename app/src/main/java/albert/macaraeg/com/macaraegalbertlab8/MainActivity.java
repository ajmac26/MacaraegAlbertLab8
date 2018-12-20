package albert.macaraeg.com.macaraegalbertlab8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText fullname;
    EditText age;
    EditText gender;
    TextView fullname_text;
    TextView age_text;
    TextView gender_text;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullname = (EditText) findViewById(R.id.fullname);
        fullname_text = (TextView) findViewById(R.id.fullname_text);

        age = (EditText) findViewById(R.id.age);
        age_text = (TextView) findViewById(R.id.age_text);

        gender = (EditText) findViewById(R.id.gender);
        gender_text = (TextView) findViewById(R.id.gender_text);

        dbHandler = new MyDBHandler(this, null, null, 1);

        printDatabase();


    }

    //Add.
    public void addButtonClicked(View view){
        Details detail1 = new Details(fullname.getText().toString());
        Details detail3 = new Details(age.getText().toString());
        Details detail2 = new Details(gender.getText().toString());
        dbHandler.addDetails(detail1);
        dbHandler.addDetails(detail2);
        dbHandler.addDetails(detail3);
        printDatabase();
    }

    //Delete
    public void searchButtonClicked(View view){
       String inputText1 = fullname.getText().toString();
       dbHandler.searchDetails(inputText1);
       String inputText2 = age.getText().toString();
       dbHandler.searchDetails(inputText2);
       String inputText3 = gender.getText().toString();
       dbHandler.searchDetails(inputText3);
       printDatabase();



    }


    public void printDatabase(){
        String dbString1 = dbHandler.databaseToString();
        fullname_text.setText(dbString1);
        fullname.setText("");

        String dbString2 = dbHandler.databaseToString();
        age_text.setText(dbString2);
        age.setText("");

        String dbString3 = dbHandler.databaseToString();
        gender_text.setText(dbString3);
        gender.setText("");




    }



}
