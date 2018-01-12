
package mining;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class TriggerCPU extends Thread
{
    
    private JTextArea a1;
    private Display d;
    private String loccpu,flagscpu,address,walletaddress;
    public TriggerCPU(String loccpu,String flagscpu, String address,String walletaddress, Display d)
    {
        System.out.println(loccpu);
    	this.d=d;
        a1=d.getTextField("CPU");
        this.loccpu=loccpu; 
        this.flagscpu=flagscpu;
        this.address=address;
        this.walletaddress=walletaddress;
    }
    @Override
    public void run()
    {
        try {
        //System.out.println(loccpu+" -o "+address+" -u "+walletaddress+" "+flagscpu);
        //a1.append("Test");
        Process child = Runtime.getRuntime().exec(loccpu+" -o "+address+" -u "+walletaddress+" "+flagscpu);

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


