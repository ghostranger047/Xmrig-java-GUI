
package mining;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class TriggerGPU extends Thread
{
    
    private JTextArea a1;
    private String locgpu,flagsgpu,address,walletaddress;
    public TriggerGPU(String locgpu,String flagsgpu, String address,String walletaddress,Display d)
    {
        a1=d.getTextField("GPU");
        this.locgpu=locgpu; 
        this.flagsgpu=flagsgpu;
        this.address=address;
        this.walletaddress=walletaddress;
    }
    @Override
    public void run()
    {
        try {
        //System.out.println(loccpu+" -o "+address+" -u "+walletaddress+" "+flagscpu);
        //a1.append("Test");
        Process child = Runtime.getRuntime().exec(locgpu+" -o "+address+" -u "+walletaddress+" "+flagsgpu);

        InputStream lsOut = child.getInputStream();
        InputStreamReader r = new InputStreamReader(lsOut);
        BufferedReader in = new BufferedReader(r);

        // read the child process' output
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
            a1.append(line+"\n");
            // You should set JtextArea
        }
        } 
        catch (Exception e) { // exception thrown

        System.err.println("Command failed!");
        }
    }
    
    
    

}


