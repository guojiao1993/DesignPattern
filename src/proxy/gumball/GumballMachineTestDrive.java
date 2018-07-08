package proxy.gumball;
import java.net.MalformedURLException;
import java.rmi.*;

public class GumballMachineTestDrive {
 
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		Naming.rebind("//127.0.0.1/gm1", new GumballMachine("gm1", 100));
		Naming.rebind("//127.0.0.1/gm2", new GumballMachine("gm2", 200));
		Naming.rebind("//127.0.0.1/gm3", new GumballMachine("gm3", 300));
	}

}
