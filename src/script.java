package src;

public class script {

    public void scriptExample(int numberToTest)
    {
        packet packet = new packet(numberToTest);
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

