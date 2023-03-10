import java.net.*;
import java.io.*;

class DSClient{
    public static void main(String args[])throws Exception{
        Socket s=new Socket("localhost", 6561);
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String inStr = "";
        String outStr = "";

        dout.writeUTF("HELO");
        dout.flush();
        loop1:
        while(true){
            // outStr=br.readLine();
            // dout.writeUTF(outStr);
            // dout.flush();

            inStr=din.readUTF();
            System.out.println(inStr);
            switch (inStr) {
                case "G'DAY":
                    dout.writeUTF("BYE");
                    dout.flush();
                    break;
                case "BYE":
                    break loop1;
            }
        }

        dout.close();
        s.close();
    }
}