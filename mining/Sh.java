
package mining;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JTextArea;

public class Sh extends Thread
{
    private Display d;
    String locsh;
    private JTextArea a1;
    public Sh(String locsh, Display d)
    {
        this.locsh=locsh;
        this.d=d;
        a1=d.getTextField("sh");
        
    }
    @Override
    public void run()
    {
        try {
        //System.out.println(loccpu+" -o "+address+" -u "+walletaddress+" "+flagscpu);
        //a1.append("Test");
        a1.setText("");
        Runtime.getRuntime().exec("/usr/bin/x-terminal-emulator --disable-factory -e sh "+locsh);
        Thread.sleep(1000);
                
        }
         
        catch (Exception e) { // exception thrown

        System.err.println("Command failed!");
        }
    }
    
}
