package socket_project;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
// Begin Class
	
	public static void main (String[] args) {
	// Begin main()
		
		try {
			
			ServerSocket ss = new ServerSocket(4444);
			Socket s = ss.accept();
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			
			String str = "", str2 = "";
			
			while (!str.equalsIgnoreCase("stop")) {
				
				str = in.readUTF();
				System.out.println("Client : "+ str);
				str2 = bf.readLine();
				out.writeUTF(str2);
				out.flush();
				
			}
			
			in.close();
			s.close();
			ss.close();
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	// End main()
	}
	
// End Class
}
