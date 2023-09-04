package src;

public class script {

    public void scriptExample()
    {
        packet packet = new packet(0);
        int data;
        switch (packet.value)
        {
            case 0:
                data = packet.value;
                break;
            case 1:
                data = packet.value;
                break;
            default:
                data = packet.value;
                packet = null;
                break;
        }
        data = packet.value; // In case of default it will throw error as packet is null
    }

    public script () {};
}

