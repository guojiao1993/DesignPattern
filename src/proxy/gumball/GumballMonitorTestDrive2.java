package proxy.gumball;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class GumballMonitorTestDrive2 {

    /**
     * 与 Head First 设计模式 讲的不同的地方在于定位地址中增加了端口号
     * @param args
     * @throws RemoteException
     * @throws NotBoundException
     * @throws MalformedURLException
     */
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        String[] location = {"rmi://localhost:7744/gm1", "rmi://localhost:7744/gm2", "rmi://localhost:7744/gm3"};
        GumballMonitor[] monitor = new GumballMonitor[location.length];
        for (int i = 0; i < location.length; i++) {
            GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(location[i]);
            monitor[i] = new GumballMonitor(machine);
            System.out.println(monitor[i]);
        }
        for (int i = 0; i < monitor.length; i++) {
            monitor[i].report();
        }
    }

}
