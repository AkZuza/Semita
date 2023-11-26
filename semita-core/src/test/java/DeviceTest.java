import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import semita.Device;
import java.net.InetAddress;

public class DeviceTest
{

    private String GetLocalHostName()
    {
        String thisName = "";
        try
        {
            thisName = InetAddress.getLocalHost().getHostName();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        return thisName;
    }


    @Test
    @DisplayName("Verify Device Details")
    public void VerifyDeviceDetails()
    {
        Device device = new Device();
        System.out.println("Device Name: " + device.GetName());
        assert device.GetName().equals(GetLocalHostName());

    }

    @Test
    @DisplayName("Verify Network connectivity")
    public void VerifyDeviceNetworkConnectivity()
    {
        Device device = new Device();
        System.out.println("Device is " + (device.isNetworkActive() ? "" : "not ") + "connected to a network");
    }
}
