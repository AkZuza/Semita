package semita;

import org.apache.commons.math3.exception.util.ExceptionContext;

import java.net.InetAddress; // for getting the host device name
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Arrays;

import org.sputnikdev.bluetooth.manager.BluetoothManager;
import org.sputnikdev.bluetooth.manager.impl.BluetoothManagerBuilder;


public class Device {

    /**
     * Retrieves the name of the device and stores it in Name
     * and identifies the Class of device(Desktop, Mobile, AudioOutput etc.) and stores it in Class
     */
    public Device()
    {
        try
        {
            this.Name = InetAddress.getLocalHost().getHostName();

        } catch(Exception ex)
        {
            System.out.println("Device: Couldn't get local device name");
            System.out.println(ex.getMessage());
        }

        String os = System.getProperty("os.name");

        switch(os)
        {
            case "Windows 11":
            case "Windows 10":
            case "Linux":
                this.Class = DeviceClass.Desktop;
                break;

            case "Android":
                this.Class = DeviceClass.Mobile;
                break;
        }

    }

    /**
     *
     * @return name of the device
     */
    public String GetName()
    {
        return this.Name;
    }

    /**
     *  Checks if the local device is connected to Wi-Fi and Bluetooth
     *  @return True if local device has Wi-Fi and Bluetooth enabled, else False
     */
    public Boolean isNetworkActive()
    {

        // check if device has any connections
        try
        {
            Enumeration<NetworkInterface> intefaces = NetworkInterface.getNetworkInterfaces();
            while(intefaces.hasMoreElements())
            {
                NetworkInterface networkInterface = intefaces.nextElement();
                if(networkInterface.isUp())
                    break;
            }

        }
        catch(Exception exception)
        {
            System.out.println("Not connected to a Wi-Fi with internet access");
            return false;
        }

        // bluetooth connection test
        BluetoothManagerBuilder builder = new BluetoothManagerBuilder();
        builder.withDiscovering(true);

        BluetoothManager manager = builder.build();
        return manager.isStarted();
    }

//    public Device[] GetAllConnectedPeripherals()
//    {
//
//    }

    /**
     *
     * @return Class of the device
     */
    public DeviceClass GetClass()
    {
        return this.Class;
    }

    private String Name;
    private DeviceClass Class;

}
