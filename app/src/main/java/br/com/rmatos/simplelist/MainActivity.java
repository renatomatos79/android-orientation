package br.com.rmatos.simplelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText txtItem;
    private Button btnAdd;
    private ListView lstView;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        if (bundle == null)
        {
            list = new ArrayList<>();
        }
        else
        {
            list = bundle.getStringArrayList("list");
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        txtItem = (EditText)findViewById(R.id.txtItem);

        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                list.add(txtItem.getText().toString());
                adapter.notifyDataSetChanged();

            }
        });

        lstView = (ListView)findViewById(R.id.lstView);
        lstView.setAdapter(adapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("list", list);

    }

}
