package adnziica.com.nutricion.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import adnziica.com.nutricion.R;


public class MoviesFragment extends Fragment {

    TextView txtText;

    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        txtText = (TextView) view.findViewById(R.id.idTextMovies);

        // Inflate the layout for this fragment
        return view;
    }

    public void CalculoRealizado(String text, Context context){
        Toast.makeText(context, "hola"+text, Toast.LENGTH_SHORT).show();
        //txtText.setText(text);
    }

}
