package proxy.gumball;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class GumballMachineTestDrive2 {

    /**
     * 与 Head First 设计模式 讲的不同，这里没有繁琐的rmic、rmiregister等配置操作
     * 使用 java.rmi.registry.LocateRegistry 来注册服务和绑定
     * @param args
     * @throws RemoteException
     * @throws MalformedURLException
     * @throws AlreadyBoundException
     */
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		LocateRegistry.createRegistry(7744);
		Naming.bind("rmi://localhost:7744/gm1", new GumballMachine("gm1", 100));
		Naming.bind("rmi://localhost:7744/gm2", new GumballMachine("gm2", 200));
		Naming.bind("rmi://localhost:7744/gm3", new GumballMachine("gm3", 300));
	}

}
