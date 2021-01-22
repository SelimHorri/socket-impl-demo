package socket_project;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
// Begin Class
	
	public static void main (String[] args) {
	// Begin main()
		
		try {
			
			Socket s = new Socket("localhost",4444);
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			
			String str = "", str2 = "";
			
			while (!str.equalsIgnoreCase("stop")) {
				
				str = bf.readLine();
				out.writeUTF(str);
				out.flush();
				str2 = in.readUTF();
				System.out.println("Server : "+ str2);
				
			}
			
			out.close();
			s.close();
			
		}
		catch (UnknownHostException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	// End main()
	}
	
// End Class
}
