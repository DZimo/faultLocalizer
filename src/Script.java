package src;

public class Script {

    public int scriptExample(int numberToTest)
    {
        Packet packet = new Packet(numberToTest);
        int data;
        switch (packet.value) {
            case 0 -> data = packet.value;
            case 1 -> data = packet.value;
            default -> {
                data = packet.value;
                packet = null;
            }
        }
        data = packet.value;

        return data;
    }

    public Script() {};
}

