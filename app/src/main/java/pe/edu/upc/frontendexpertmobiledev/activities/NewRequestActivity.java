package pe.edu.upc.frontendexpertmobiledev.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import pe.edu.upc.frontendexpertmobiledev.R;
import pe.edu.upc.frontendexpertmobiledev.models.Request;
import pe.edu.upc.frontendexpertmobiledev.models.Skill;

public class NewRequestActivity extends AppCompatActivity implements View.OnClickListener {
    //private Toolbar toolbar;
    private Spinner spnRequestType;
    private EditText edtSubject;
    private TextInputLayout tilSubject;
    private EditText edtDescription;
    private TextInputLayout tilDescription;
    private Button btnSend;
    private SpinnerAdapter spinnerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_request);

        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        spnRequestType = (Spinner) findViewById(R.id.spnRequestType);
        edtSubject = (EditText) findViewById(R.id.edtSubject);
        tilSubject = (TextInputLayout) findViewById(R.id.tilSubject);
        edtDescription = (EditText) findViewById(R.id.edtDescription);
        tilDescription = (TextInputLayout) findViewById(R.id.tilDescription);
        btnSend = (Button) findViewById(R.id.btnSend);

        //setSupportActionBar(toolbar);
        btnSend.setOnClickListener(this);

        adaptSpinner();
    }

    private void adaptSpinner(){
        String[] requestTypes = getResources().getStringArray(R.array.array_request_type);
        spinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, requestTypes);
        spnRequestType.setAdapter(spinnerAdapter);
    }

    @Override
    public void onClick(View view) {
        if (view == btnSend){
            Skill skill = new Skill(spnRequestType.getSelectedItemPosition(), (String) spnRequestType.getSelectedItem());
            //Request request = new Request(skill, edtDescription.getText().toString(), edtSubject.getText().toString());

            Request request = new Request(0, null, null, "", edtDescription.getText().toString(), "");

            /*Intent returnIntent = new Intent();
            returnIntent.putExtra(EXTRA_REQUEST, request);
            setResult(RESULT_OK, returnIntent);
            finish();*/
            Intent intent = new Intent(NewRequestActivity.this, ExpertsActivity.class);
            //intent.putExtra("",request);
            startActivityForResult(intent, 2);
        }
    }
}
