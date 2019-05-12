package ba.unsa.etf.labirint3dwifi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);

        setajOnClickZaButtone();
    }

    @Override
    protected void onDestroy()
    {
        WiFiComm.zatvoriKonekciju();

        super.onDestroy();
    }

    private void setajOnClickZaButtone()
    {
        ImageButton buttonDolje = (ImageButton) findViewById(R.id.buttDolje);
        buttonDolje.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                posaljiPoruku("s");
            }
        });

        ImageButton sendButton = (ImageButton) findViewById(R.id.buttonSend);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                posaljiPoruku("w");
            }
        });

        ImageButton buttLijevo = (ImageButton) findViewById(R.id.buttLijevo);
        buttLijevo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                posaljiPoruku("a");
            }
        });

        ImageButton buttDesno = (ImageButton) findViewById(R.id.buttDesno);
        buttDesno.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                posaljiPoruku("d");
            }
        });


        ImageButton buttConfirm = (ImageButton) findViewById(R.id.buttConfirm);
        buttConfirm.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                posaljiPoruku("k");
            }
        });

        ImageButton buttRotacijaLijevo = (ImageButton) findViewById(R.id.buttRotacijaLijevo);
        buttRotacijaLijevo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                posaljiPoruku("i");
            }
        });

        ImageButton buttRotacijaDesno = (ImageButton) findViewById(R.id.buttRotacijaDesno);
        buttRotacijaDesno.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                posaljiPoruku("o");
            }
        });

        ImageButton buttBack = (ImageButton) findViewById(R.id.buttBack);
        buttBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                posaljiPoruku("b");
            }
        });
    }

    private void posaljiPoruku(String poruka)
    {
        Intent intent = new Intent(getApplicationContext(), WiFiComm.class);

        intent.putExtra("poruka", poruka);

        startService(intent);
    }
}
