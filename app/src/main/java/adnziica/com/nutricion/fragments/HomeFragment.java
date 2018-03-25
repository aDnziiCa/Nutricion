package adnziica.com.nutricion.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import adnziica.com.nutricion.R;


public class HomeFragment extends Fragment {

    EditText etPeso, etEstatura;
    Button btnCalcular;
    DataListener callback;

    public HomeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        etPeso = (EditText) view.findViewById(R.id.etPeso);
        etEstatura = (EditText) view.findViewById(R.id.etEstatura);
        btnCalcular = (Button) view.findViewById(R.id.btnCalcular);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendText(etPeso.getText().toString());
            }
        });


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            callback = (DataListener) context;
        }catch (Exception e) {
            throw new ClassCastException(context.toString()+ "You must implement DataListener");
        }
    }

    public void sendText(String text){
        callback.sendData(text);
    }


    public interface DataListener{
        void sendData(String text);

    }

}
