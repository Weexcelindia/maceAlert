package com.ayla.logic;

import android.util.Base64;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: billy
 * Date: 2014/6/19
 * Time: 下午 01:19
 */
public class DataFrameParser {

    public String base64(String value) {
        return  Base64.encodeToString(value.getBytes(),Base64.DEFAULT);
    }

    
    //TODO Weexcel follow these a bunch of binary utility function I need to use to help communicate with hardware, see if you can understand my objective c code & translate them to java code, you can reference the dataFrameParser.m. If you have difficult on them, just leave it alone , I can explain to  you more detail when I am back from vacation
    /**
     *
     - (NSString *)fillNameToHex:(NSString *)name length:(int)length {
     NSString *subName = [name substringWithRange:NSMakeRange(0, MIN(10, name.length))];   // substring in range
     NSString *res = @"";
     for (int i = 0; i < subName.length; i++) {
     unichar chars = [subName characterAtIndex:i];
     NSString *charHexString = [self upfillHexInt:chars toLength:2];  // hex change
     res = [res stringByAppendingString:charHexString];   //append string
     }
     while (res.length < length) {
     res = [res stringByAppendingString:@"0"];   // 0000add
     }
     return res;
     }


     Sensor1 is only 7 character, upfill it to length 10 character with 0
     sample input "Sensor1" length 32
     "S" ascii code 83, 83 hexformat is 53
     then post-fill it with 0 to target length
     sample output "53656E6F773231000000000000000000"
     should have a unit testcase for this method
     * @param input
     * @param length
     * @return
     * //TODO Weexcel
     */
    public String fillNameToHex(String input, int length) {
     String subName =input.substring(0,Math.min(10,input.length()));
     StringBuilder res=new StringBuilder("");
        for (int i = 0; i < subName.length(); i++) {
            int chars = subName.charAt(i);  // converting to ascii
            String charHexString = upfillHexInt(chars,2);  // change to hex
            res.append(charHexString);        //append hexstring
        }
        while (res.length() < length) {
            res.append("0");          // fill if required 0000
        }
        return res.toString();
    }

    /**
     *
     - (NSString *)upfillHex:(NSNumber *)number toLength:(int)length {
     return [self upfillHexInt:number.intValue toLength:length];
     }

     - (NSString *)upfillHexInt:(int)number toLength:(int)length {
     NSString *formatString = [NSString stringWithFormat:@"0%ix", length];  // cast to string
     formatString = [@"%i" stringByAppendingString:formatString];   //%410
     return [NSString stringWithFormat:formatString, number];
     }
     //TODO Weexcel
     * @param number
     * @param length
     * @return
     */
    public String upfillHex(long number, int length) {
        return upfillHexInt((int)number,length);
    }

    public String upfillHexInt(int number, int length) {
        String s=number+"0"+length+"x";
        return s;
    }


    /**
     *
     NSNumber *isBit(int anInt, int i) {
     return [NSNumber numberWithInt:(anInt & (1 << i)) > 0];
     }

     * @param input
     * @param position
     * @return
     */
    public boolean isBit(int input, int position){

        boolean a=((input&(1<<position))>0);
        return a;
    }

    /**
     *
     bool bitOnB(
     int i,
     int i1) {
     return (bool) (i | (int) pow(2, i1));
     }

     NSString *bitOn(int i, int i1) {
     bool d = bitOnB(i, i1);
     if (d) {
     return @"ON";
     }
     return @"OFF";
     }
     */
    private static DataFrameParser parserInstance = new DataFrameParser();

    /**
     *
     - (NSNumber *)getSignBit:(NSNumber *)number {
     //assume 8 bit length
     int i = number.intValue;
     i = (i >> 7);
     return [NSNumber numberWithInt:i];;
     }

     - (NSNumber *)removeSignBit:(NSNumber *)number {


     int i = number.intValue;
     i = i & ((1 << 7) - 1);

     return [NSNumber numberWithInt:i];
     };

     convert decimal e.g 13 to binary string "1101"
     - (NSString *)toBinary:(NSUInteger)input {
     if (input == 1 || input == 0) {
     return [NSString stringWithFormat:@"%u", input];
     }
     return [NSString stringWithFormat:@"%@%u", [self toBinary:input / 2], input % 2];
     }


     convert decimal to speific binary string
     e.g 13 to 8 length binary string "00001101"
     - (NSString *)upfill:(int)i
     toLength:(char)i1 {
     NSString *binaryForm = [self toBinary:i];
     while (binaryForm.length < i1) {
     binaryForm = [@"0" stringByAppendingString:binaryForm];
     }
     return binaryForm;
     }


     scan HexString e.g "7E" and output integer 126

     - (NSNumber *)stringToInt:(NSString *)input {
     NSScanner *scanner = [NSScanner scannerWithString:input];
     unsigned result = 0;
     [scanner scanHexInt:&result];

     return [NSNumber numberWithInt:result];
     }


     scan HexString e.g "1101" and output integer 126
     - (NSUInteger)convertBinaryToInt:(NSString *)binaryString {
     const char *utf8String = [binaryString UTF8String];
     const char *endPtr = NULL;
     long int foo = strtol(utf8String, &endPtr, 2);

     if (endPtr != utf8String + strlen(utf8String)) {
     // string wasn't entirely a binary number
     unexpectedCase();
     }
     if (errno == ERANGE && (foo == LONG_MAX || foo == LONG_MIN)) {
     // number was too big or too small
     unexpectedCase();
     }
     return foo;
     }




     this one may be too difficult to explain, may be I should do it myself
     basically it is creating a crc8 checksum
     - (NSString *)getHexCheckSum:(NSString *)hexIn {

     NSString *package = @"";

     for (int i = 0; i < hexIn.length; i++) {
     NSString *subChar = [hexIn substringWithRange:NSMakeRange(i, 1)];
     NSNumber *intvalue = [self stringToInt:subChar];
     NSString *binary = [self upfill:intvalue.intValue toLength:4];
     package = [package stringByAppendingString:binary];
     }
     int packageLength = package.length / 8;
     u8 chars[packageLength];
     int j = 0;
     //    NSLog(@"crc raw %@", package);

     for (int i = 0; i < package.length; i += 8) {
     NSString *subPath = [package substringWithRange:NSMakeRange(i, 8)];
     int asciiCode = [self convertBinaryToInt:subPath];
     //        NSLog(@"crc %@ %i", subPath, asciiCode);
     chars[j] = (u8) asciiCode;
     j++;
     }

     //    TTDPRINT(@"crc8 %@", remain);
     u8 code = crc_checkout_halfbyte(chars, (u8) packageLength);
     NSLog(@"crc result %i length %i", code, (u8) packageLength);

     u8 crc10 = crc_checkout_halfbyte(chars, (u8) packageLength - 1);
     chars[packageLength - 1] = crc10;
     u8 crc11 = crc_checkout_halfbyte(chars, (u8) packageLength);
     NSLog(@"crc10 %i crc11  %i", crc10, crc11);

     NSString *res2 = [self upfill:(int) code toLength:8];
     int intValue = [self convertBinaryToInt:res2];
     NSString *res = [self upfillHexInt:intValue toLength:2];
     TTDPRINT(@" hexCheckSum %@ -> %@ ", hexIn, res);
     return res;
     }




     typedef unsigned char u8;
     u8 const u8cCrcHalfTab[16] =
     {
     0x0, 0x31, 0x62, 0x53, 0xC4, 0xF5, 0xA6, 0x97,
     0xB9, 0x88, 0xDB, 0xEA, 0x7D, 0x4C, 0x1F, 0x2E
     };

    u8 crc_checkout_halfbyte(u8 *pu8Data, u8 u8Length) {
        u8 u8Temp, u8CrcData = 0;

        for (; u8Length > 0; u8Length--) {
            u8Temp = (u8CrcData >> 4) ^ (*pu8Data >> 4); //MSB
            u8CrcData <<= 4;
            u8CrcData ^= u8cCrcHalfTab[u8Temp];
            //	u8CrcData	=(u8CrcData<<4)^u8cCrcHalfTab[(u8CrcData>>4)^(*pu8Data>>4)];

            u8Temp = (u8CrcData >> 4) ^ (*pu8Data & 0x0f); //LSB
            u8CrcData <<= 4;
            u8CrcData ^= u8cCrcHalfTab[u8Temp];

            pu8Data++;//next byte
        }

        return (u8CrcData);
    }





     - (NSNumber *)addSignBit:(int)m {
     int signedBit = m + (1 << 7);
     return [NSNumber numberWithInt:signedBit];
     }
     * @return
     */

    public static DataFrameParser getInstance() {
        return parserInstance;
    }


    /**
     * a sample implemtation for
     * http://paulschou.com/tools/xlate/
     * we need to do hex to base64
     * &
     * base 64 to hex
     * sample hex string input "1CAD3C55DE"
     * sample base64 string output "HK08Vd4="
     *
     *
     *
     *
     * sample base64 string input "asdawdawdawd"
     * sample hex string output "6ac75ac1d6b075ac1d"
     * @param base64string
     * @return
     */

    public  String tohexadecimalString(String base64string) {  // convert
        byte[] text=Base64.decode(base64string, Base64.DEFAULT);
        return String.format("%x", new BigInteger(1, text));
    }



    public  String decodehexadecimalString(String hexString) {  // reverse

        byte [] txtInByte = new byte [hexString.length() / 2];
        int j = 0;
        for (int i = 0; i < hexString.length(); i += 2)
        {
            txtInByte[j++] = Byte.parseByte(hexString.substring(i, i + 2), 16);
        }
        return Base64.encodeToString(txtInByte,Base64.DEFAULT).toString();
//        return Base64.encodeToString(sb.toString().getBytes(),Base64.DEFAULT);
    }
}
