package hezron;

public class Main {

    public static void main(String[] args) {
        byte bytes[] = {
                0x13,0x55,(byte)0xb6,0x76,
                0x79,(byte)0x88,0x29,0x5e,
                0x00,0x00,0x00,0x00,
                0x00,0x03,0x00,0x34,
                0x7e,0x58,0x1e,0x36,
                0x00,0x00,0x00,0x00,
                0x00,0x00,0x00,0x00
        };
        //source port
        int sourcePort = 0;
        sourcePort |= (bytes[0] &0xff)<<8;
        sourcePort |= (bytes[1] &0xff);
        System.out.println("Source Port -->"+ sourcePort);



        //destination port
        int destinationport =0;
        destinationport |= (bytes[2] &0xff)<<8;
        destinationport |=(bytes[3] &0xff);
        System.out.println("Destination Port -->"+destinationport);

        //verification tag
        //indexes 4,5,6,7
        int verificationTag =0;
        verificationTag |= (bytes[4] &0xff)<<24;//shift 24 bit
        verificationTag |= (bytes[5] &0xff)<<16;
        verificationTag |= (bytes[6] &0xff)<<8;
        verificationTag |= (bytes[7] &0xff);
        System.out.println("Verification Tag -->"+verificationTag);

        //checksum
        //indexes --8,9,10,11
        int checksum= 0;
        checksum |= (bytes[8] &0xff) <<24;
        checksum |= (bytes[9] &0xff) <<16;
        checksum |= (bytes[10] &0xff) <<8;
        checksum |= (bytes[11] &0xff);
        System.out.println("Checksum -->"+ checksum);

        //data chunk 12,13 14 15
        int type =0;
        type |= (bytes[12] &0xff);
        System.out.println("Type"+type);

        boolean reserved = ((bytes[13] &0xff) &0b11100000) >0;
        System.out.println("Reserves -->"+reserved);

        boolean u = ((bytes[13] &0xff) &0b00010000) >0;
        System.out.println("U-->"+u);

        boolean b = ((bytes[13] &0xff) &0b00000100) >0;
        System.out.println("B -->"+b);
        boolean r = ((bytes[13] &0xff) &0b00000010) >0;
        System.out.println("R -->"+r);

        int length =0;
        length |= (bytes[14] &0xff)<<8;
        length |= (bytes[15] &0xff);
        System.out.println("Length"+ length);



    }
}
