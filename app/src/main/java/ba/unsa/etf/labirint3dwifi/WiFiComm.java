package ba.unsa.etf.labirint3dwifi;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class WiFiComm extends IntentService
{
    private static final String ip_adresa = "192.168.1.11";
    private static final int port = 8008;

    private static Socket socket = null;

    public WiFiComm ()
    {
        super("WiFiComm");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent)
    {
        if(intent != null)
        {
            try
            {
                if(socket == null)
                {
                    socket = new Socket(ip_adresa, port);
                }

                String poruka = intent.getStringExtra("poruka");

                PrintWriter pw = new PrintWriter(socket.getOutputStream());

                pw.write(poruka);
                pw.flush();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void zatvoriKonekciju()
    {
        try
        {
            if(socket != null)
            {
                socket.close();
                socket = null;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
