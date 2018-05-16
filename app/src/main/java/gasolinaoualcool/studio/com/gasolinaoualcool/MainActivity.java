package gasolinaoualcool.studio.com.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoVerificar;
    private TextView textoResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Localizar componentes na tela
        precoAlcool = (EditText) findViewById(R.id.precoAlcoolId);
        precoGasolina = (EditText) findViewById(R.id.precoGasolinaId);
        botaoVerificar = (Button) findViewById(R.id.botaoVerificarId);
        textoResultado = (TextView) findViewById(R.id.textoResultadoId);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //recuperar os valores digitado
                String textoPrecoAlcool = precoAlcool.getText().toString();
                String textoPrecoGasolina = precoGasolina.getText().toString();

                // verificando se as variaveis foram  preechidas
                if (!textoPrecoAlcool.equals("") && !textoPrecoGasolina.equals("")) {

                    //converter valores string para numeros
                    Double valorAlcool = Double.parseDouble(textoPrecoAlcool);
                    Double valorGasolina = Double.parseDouble(textoPrecoGasolina);

                    //calculo => alcool / gasolina (> 0,7 gasolina) (< 0,7 alcool)
                    double resultado = valorAlcool / valorGasolina;

                    if (resultado >= 0.7) {
                        //gasolina
                        textoResultado.setText("É melhor usar GASOLINA");
                    } else {
                        //alcool
                        textoResultado.setText("É melhor usar ÁLCOOL");

                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Informe os valores dos combustiveis", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
