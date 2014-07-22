//
//  Created by User on 05/09/2013.
//
//

#import "DataFrameParser.h"
#import "ut.h"
#import "stdlib.h"
#import "DataFrame.h"
//#import "AylaDemoGlobal.h"
#import "AylaDevicesViewController.h"
#import "AylademoAppDelegate.h"
#import "DataPoint.h"
#import "AylaDevice.h"
#import "AylaDemoGlobal.h"
#import "DevicePoint.h"
#import "PanelCommandPoint.h"
#import "Panel.h"
#import "TimeZonePicker.h"
#import "NSDataBase64.h"
#import "Setting.h"
#import "NSData+Base64.h"

DataFrameParser *DataFrame_Instance;

NSString *bitOn(int i, int i1);

bool bitOnB(int i, int i1);

NSNumber *isBit(int anInt, int i);
//#define getCheckSum()  [self getHexCheckSum:[ut append:panelIdToData,nil]]
#define getCheckSum()  [self getHexCheckSum:[ut append:header,type,panelIdToData,nil]]

@implementation DataFrameParser {

@private
    bool _debugMode;
}
@synthesize debugMode = _debugMode;


/*
* 1110010000000000011010000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000110100001001000001000001000100101011
*
*
* */

objection_register_singleton(DataFrameParser)

- (void)awakeFromObjection {
//    [super awakeFromObjection];
    self.waitingCommands = [[NSMutableArray alloc] init];
    self.sending = false;
    DataFrame_Instance = self;
}


- (void)syncCloud {
    //when user connect to ayla cloud,
    //fetch latest 100 points?
    //fetch the trigger to load device names? sensor names?
    //sync to local store
    //data point store


}

- (NSArray *)getSensorPoints:(NSArray *)properties {

    NSMutableArray *array = [self importProperties:properties];
    DevicePoint *panelPoint;
    for (DevicePoint *point in array) {
        if (point.sensorType.intValue == 1) {
            panelPoint = point;
        }
    }
    [array removeObject:panelPoint];

    return array;
}

- (bool )testFinish:(NSString *)input2 {
//    assume finish length

    NSData *data = [NSData dataWithBase64EncodedString:input2];
    NSString *input = [data hexadecimalString];

    NSString *lengthStr = [input substringWithRange:NSMakeRange(2, 4)];

    int stringLength = [self stringToInt:lengthStr].intValue;
    if (stringLength < 16 * 2 * 10) {
        return true;
    }
    return false;
}

//- (NSArray *)parseBatchPoints:(NSString *)input2 {
//
//    NSMutableArray *res = [[NSMutableArray alloc] init];
//    if (input2 == nil) {
//        return res;
//    }
//
//    NSData *data = [NSData dataWithBase64EncodedString:input2];
//    NSString *input = [data hexadecimalString];
//
//    NSString *multiFrame = [input substringWithRange:NSMakeRange(2, input.length - 2 - 2)];
//    assert(multiFrame.length % 32 == 0);
//    int frameCount = multiFrame.length / 32;
//    for (int i = 0; i < frameCount; i++) {
//        NSString *frameString = [multiFrame substringWithRange:NSMakeRange(i * 32, 32)];
//        PanelCommandPoint *commandPoint = [self parseCloudToPanel:frameString];
//        [res addObject:commandPoint];
//
//    }
//    return res;
//}

#define readText(a) [input substringWithRange:NSMakeRange(counter, a)];counter+=a;
//- (PanelCommandPoint *)parseCloudToPanel:(NSString *)input2 {
//
//    NSData *data = [NSData dataWithBase64EncodedString:input2];
//    NSString *input = [data hexadecimalString];
//
//    int counter=0;
//
//    NSString *data1_3 = readText(6);
//    NSString *data4 = readText(2);
//    NSString *data5 = readText(2);
//    NSString *data6 = readText(2);
//    NSString *data7 = readText(2);
//    NSString *data8 = readText(2);
//    NSString *data9 = readText(2);
//    NSString *data10 = readText(2);
//    NSString *data11 = readText(2);
//    NSString *data12 = readText(2);
//    NSString *data13 = readText(2);
//    NSString *data14 = readText(2);
//    NSString *data15 = readText(2);
//    NSString *data16 = readText(2);
//
//    PanelCommandPoint *commandPoint = [PanelCommandPoint MR_createEntity];
//    commandPoint.raw = input;
////    commandPoint.header = [self stringToInt:header];
////    commandPoint.length = [self stringToInt:length];
////    commandPoint.flag = [self stringToInt:flag];
////    commandPoint.type = [self stringToInt:type];
//    commandPoint.type = [self stringToInt:@""];
////    commandPoint.commandType = [self stringToInt:data1];
//
//    int data6Int = [self stringToInt:data6].intValue;
//    TTDPRINT(@"data6 is %@(%i)", data6, data6Int);
//    int data7Int = data7.intValue;
//    TTDPRINT(@"data7 is %@(%i)", data7, data7Int);
//    if (commandPoint.commandType.intValue == 1) {
//
//    } else {
//        NSString *data8 = [input substringWithRange:NSMakeRange(24, 2)];
//        NSString *data9 = [input substringWithRange:NSMakeRange(26, 2)];
//        NSString *data10 = [input substringWithRange:NSMakeRange(28, 2)];
//        NSString *data11 = [input substringWithRange:NSMakeRange(30, 2)];
////        NSString *data12 = [input substringWithRange:NSMakeRange(30, 2)];
////        NSString *data13 = [input substringWithRange:NSMakeRange(32, 2)];
////        NSString *data14 = [input substringWithRange:NSMakeRange(34, 2)];
////        NSString *data15 = [input substringWithRange:NSMakeRange(36, 2)];
////        NSString *data16 = [input substringWithRange:NSMakeRange(38, 2)];
////        NSString *data17 = [input substringWithRange:NSMakeRange(40, 2)];
//
//        if (commandPoint.commandType.intValue == 2) {
//            NSNumber *oldChar1 = [self HSB:data6];
//            NSNumber *oldChar2 = [self LSB:data6];
//            NSNumber *oldChar3 = [self HSB:data7];
//            NSNumber *oldChar4 = [self LSB:data7];
//            NSNumber *newChar1 = [self HSB:data8];
//            NSNumber *newChar2 = [self LSB:data8];
//            NSNumber *newChar3 = [self HSB:data9];
//            NSNumber *newChar4 = [self LSB:data9];
//            commandPoint.oldPassword = [NSString stringWithFormat:@"%@%@%@%@", oldChar1, oldChar2, oldChar3, oldChar4];
//            commandPoint.newPassword = [NSString stringWithFormat:@"%@%@%@%@", newChar1, newChar2, newChar3, newChar4];
//
//
//        } else if (commandPoint.commandType.intValue == 3) {
//            commandPoint.year = [self stringToInt:data6];
//            commandPoint.month = [self stringToInt:data7];
//            commandPoint.day = [self stringToInt:data8];
//            commandPoint.hour = [self stringToInt:data9];
//            commandPoint.minute = [self stringToInt:data10];
//            commandPoint.second = [self stringToInt:data11];
//        }
//    }
////    commandPoint.sensorId = [self stringToInt:data2_4];
//    commandPoint.sensorType = [self stringToInt:data5];
////    commandPoint.checkSum = data18;
//
//    return commandPoint;
//
//}

- (NSString *)getBackCloudPoint:(DevicePoint *)input {
    NSString *header = @"E";
    NSString *type = @"3";

    NSString *res;


    if (input.sensorType.intValue == 1) {

//    NSString *length = [input substringWithRange:NSMakeRange(2, 4)];


        NSString *data1_3 = [self upfillHex:input.sensorId toLength:6];
        NSString *data4 = [self upfillHex:input.sensorType toLength:2];

        int data5Int = 0;
        data5Int += input.tamper.intValue << 6;
        data5Int += input.lowVoltage.intValue << 5;
        data5Int += input.acPower.intValue << 4;
        if (input.arm.boolValue) {
            data5Int += 1;
        } else if (input.home.boolValue) {
            data5Int += 2;
        } else if (input.alert.boolValue) {
            data5Int += 3;
        } else if (input.disarm.boolValue) {
            data5Int += 4;
        } else if (input.panic.boolValue) {
            data5Int += 5;

        }


        NSString *data5 = [self upfillHexInt:data5Int toLength:2];
        NSString *data6 = [self upfillHexInt:input.editMode.intValue << 7 toLength:2];


        NSString *data7 = [self upfillHex:input.exitDelayMinutes toLength:2];
        NSString *data8 = [self upfillHex:input.exitDelaySecond toLength:2];
        NSString *data9 = [self upfillHex:input.entryDelayMinutes toLength:2];
        NSString *data10 = [self upfillHex:input.entryDelaySecond toLength:2];
        NSString *data11 = [self upfillHex:input.alarmTimeMinutes toLength:2];
        NSString *data12 = [self upfillHex:input.alarmTimeSecond toLength:2];
        NSString *data13_16 = @"00000000";

        NSString *sensorCount = [self upfillHexInt:(01) toLength:2];
        NSString *length = [self upfillHexInt:(20) toLength:2];

        NSString *panelIdToData = [ut append:sensorCount, length, data1_3,
                                             data4,
                                             data5,
                                             data6,
                                             data7,
                                             data8,
                                             data9,
                                             data10,
                                             data11,
                                             data12,
                                             data13_16, nil
        ];
        NSString *panelIdToData_ = [ut append_:sensorCount, length, data1_3,
                                               data4,
                                               data5,
                                               data6,
                                               data7,
                                               data8,
                                               data9,
                                               data10,
                                               data11,
                                               data12,
                                               data13_16, nil
        ];

//    NSString *lengthAndData = [NSString stringWithFormat:@"%@%@",  panelIdToData];
//    NSString *checkSumInput = panelIdToData;
        NSString *CHECKSUM = getCheckSum();


        TTDPRINT(@"Header %@", header);
        TTDPRINT(@"sensorCount %@", sensorCount);
        TTDPRINT(@"length %@", length);
        TTDPRINT(@"command type %@", type);
        TTDPRINT(@"data1_3 %@", data1_3);
        TTDPRINT(@"data4 %@", data4);
        TTDPRINT(@"data5 %@", data5);
        TTDPRINT(@"data6 %@", data6);
        TTDPRINT(@"data7 %@", data7);
        TTDPRINT(@"data8 %@", data8);
        TTDPRINT(@"data9 %@", data9);
        TTDPRINT(@"data10 %@", data10);
        TTDPRINT(@"data11 %@", data11);
        TTDPRINT(@"data12 %@", data12);
        TTDPRINT(@"data13_16 %@", data13_16);
        TTDPRINT(@"checksum %@", CHECKSUM);
        TTDPRINT(@"All_datas_ %@", panelIdToData_);
        res = [[ut append:header, type, panelIdToData, CHECKSUM, nil] uppercaseString];

        TTDPRINT(@"final data %@", res);

    } else {
        //sensors....


        NSString *data1_3 = [self upfillHex:input.sensorId toLength:6];
        NSString *data4 = [self upfillHex:input.sensorType toLength:2];

        int data5Int = 0;
//        data5Int += input.tamper.intValue << 6;
//        data5Int += input.lowVoltage.intValue << 5;
//        data5Int += input.acPower.intValue << 4;
//        if (input.arm.boolValue) {
//            data5Int += 1;
//        } else if (input.home.boolValue) {
//            data5Int += 2;
//        } else if (input.alert.boolValue) {
//            data5Int += 3;
//        } else if (input.disarm.boolValue) {
//            data5Int += 4;
//        } else if (input.panic.boolValue) {
//            data5Int += 5;
//
//        }

        NSString *data5 = [self upfillHexInt:data5Int toLength:2];


        int data6Int = 0;
        data6Int += input.editMode.intValue << 7;
        data6Int += input.modeAlert.intValue << 3;
        data6Int += input.modeAlertHome.intValue << 2;
        data6Int += input.modeArmHome.intValue << 1;
        data6Int += input.modeArm.intValue << 0;


        NSString *data6 = [self upfillHexInt:data6Int toLength:2];

        NSString *nameHex = [self fillNameToHex:input.sensorName length:20];


        NSString *sensorCount = @"01";
        NSString *length = [self upfillHexInt:(20) toLength:2];

        NSString *panelIdToData = [ut append:sensorCount, length, data1_3, data4,
                                             data5,
                                             data6,

                                             nameHex, nil
        ];
        NSString *panelIdToData_ = [ut append_:sensorCount, length, data1_3, data4,
                                               data5,
                                               data6,
                                               nameHex, nil
        ];

        NSString *CHECKSUM = getCheckSum();


        TTDPRINT(@"Header %@", header);
        TTDPRINT(@"length %@", length);
        TTDPRINT(@"command type %@", type);
//        TTDPRINT(@"flag %@", flag);
//        TTDPRINT(@"data1 %@", data1);
        TTDPRINT(@"data1_3 %@", data1_3);
        TTDPRINT(@"data4 %@", data4);
        TTDPRINT(@"data5 %@", data5);
        TTDPRINT(@"data6 %@", data6);
//        TTDPRINT(@"data7 %@", data7);
        TTDPRINT(@"name %@", nameHex);
        TTDPRINT(@"checksum %@", CHECKSUM);
        TTDPRINT(@"All_datas_ %@", panelIdToData_);
        res = [[ut append:header, type, panelIdToData, CHECKSUM, nil] uppercaseString];

        TTDPRINT(@"final data %@", res);
    }

    return res;

}

- (NSString *)getBackCloudPoint2:(DevicePoint *)input {
    NSString *header = @"E";
    NSString *type = @"3";

    NSString *res;
    if (input.sensorType.intValue == 1) {

//    NSString *length = [input substringWithRange:NSMakeRange(2, 4)];


        NSString *data1_3 = [self upfillHex:input.sensorId toLength:6];
        NSString *data4 = [self upfillHex:input.sensorType toLength:2];

        int data5Int = 0;
        data5Int += input.tamper.intValue << 6;
        data5Int += input.lowVoltage.intValue << 5;
        data5Int += input.acPower.intValue << 4;
        if (input.arm.boolValue) {
            data5Int += 1;
        } else if (input.home.boolValue) {
            data5Int += 2;
        } else if (input.alert.boolValue) {
            data5Int += 3;
        } else if (input.disarm.boolValue) {
            data5Int += 4;
        } else if (input.panic.boolValue) {
            data5Int += 5;

        }


        NSString *data5 = [self upfillHexInt:data5Int toLength:2];
        NSString *data6 = @"00";

        NSString *data7 = [self upfillHex:input.exitDelayMinutes toLength:2];
        NSString *data8 = [self upfillHex:input.exitDelaySecond toLength:2];
        NSString *data9 = [self upfillHex:input.entryDelayMinutes toLength:2];
        NSString *data10 = [self upfillHex:input.entryDelaySecond toLength:2];
        NSString *data11 = [self upfillHex:input.alarmTimeMinutes toLength:2];
        NSString *data12 = [self upfillHex:input.alarmTimeSecond toLength:2];
        NSString *data13_16 = @"00000000";

        NSString *sensorCount = [self upfillHexInt:(01) toLength:2];
        NSString *length = [self upfillHexInt:(20) toLength:2];

        NSString *panelIdToData = [ut append:sensorCount, length, data1_3,
                                             data4,
                                             data5,
                                             data6,
                                             data7,
                                             data8,
                                             data9,
                                             data10,
                                             data11,
                                             data12,
                                             data13_16, nil
        ];
        NSString *panelIdToData_ = [ut append_:sensorCount, length, data1_3,
                                               data4,
                                               data5,
                                               data6,
                                               data7,
                                               data8,
                                               data9,
                                               data10,
                                               data11,
                                               data12,
                                               data13_16, nil
        ];

//    NSString *lengthAndData = [NSString stringWithFormat:@"%@%@",  panelIdToData];
//    NSString *checkSumInput = panelIdToData;
        NSString *CHECKSUM = [self getHexCheckSum:[ut append:header, type, panelIdToData, nil]];


        TTDPRINT(@"Header %@", header);
        TTDPRINT(@"sensorCount %@", sensorCount);
        TTDPRINT(@"length %@", length);
        TTDPRINT(@"command type %@", type);
        TTDPRINT(@"data1_3 %@", data1_3);
        TTDPRINT(@"data4 %@", data4);
        TTDPRINT(@"data5 %@", data5);
        TTDPRINT(@"data6 %@", data6);
        TTDPRINT(@"data7 %@", data7);
        TTDPRINT(@"data8 %@", data8);
        TTDPRINT(@"data9 %@", data9);
        TTDPRINT(@"data10 %@", data10);
        TTDPRINT(@"data11 %@", data11);
        TTDPRINT(@"data12 %@", data12);
        TTDPRINT(@"data13_16 %@", data13_16);
        TTDPRINT(@"checksum %@", CHECKSUM);
        TTDPRINT(@"All_datas_ %@", panelIdToData_);
        res = [[ut append:header, type, panelIdToData, CHECKSUM, nil] uppercaseString];

        TTDPRINT(@"final data %@", res);

    } else {
        //sensors....


        NSString *data1_3 = [self upfillHex:input.sensorId toLength:6];
        NSString *data4 = [self upfillHex:input.sensorType toLength:2];

        int data5Int = 0;
//        data5Int += input.tamper.intValue << 6;
//        data5Int += input.lowVoltage.intValue << 5;
//        data5Int += input.acPower.intValue << 4;
//        if (input.arm.boolValue) {
//            data5Int += 1;
//        } else if (input.home.boolValue) {
//            data5Int += 2;
//        } else if (input.alert.boolValue) {
//            data5Int += 3;
//        } else if (input.disarm.boolValue) {
//            data5Int += 4;
//        } else if (input.panic.boolValue) {
//            data5Int += 5;
//
//        }

        NSString *data5 = [self upfillHexInt:data5Int toLength:2];


        int data6Int = 0;
        data6Int += input.modeAlert.intValue << 3;
        data6Int += input.modeAlertHome.intValue << 2;
        data6Int += input.modeArmHome.intValue << 1;
        data6Int += input.modeArm.intValue << 0;


        NSString *data6 = [self upfillHexInt:data6Int toLength:2];

        NSString *nameHex = [self fillNameToHex:input.sensorName length:20];


        NSString *sensorCount = @"01";
        NSString *length = [self upfillHexInt:(20) toLength:2];

        NSString *panelIdToData = [ut append:sensorCount, length, data1_3, data4,
                                             data5,
                                             data6,

                                             nameHex, nil
        ];
        NSString *panelIdToData_ = [ut append_:sensorCount, length, data1_3, data4,
                                               data5,
                                               data6,
                                               nameHex, nil
        ];

        NSString *CHECKSUM = getCheckSum();


        TTDPRINT(@"Header %@", header);
        TTDPRINT(@"length %@", length);
        TTDPRINT(@"command type %@", type);
//        TTDPRINT(@"flag %@", flag);
//        TTDPRINT(@"data1 %@", data1);
        TTDPRINT(@"data1_3 %@", data1_3);
        TTDPRINT(@"data4 %@", data4);
        TTDPRINT(@"data5 %@", data5);
        TTDPRINT(@"data6 %@", data6);
//        TTDPRINT(@"data7 %@", data7);
        TTDPRINT(@"name %@", nameHex);
        TTDPRINT(@"checksum %@", CHECKSUM);
        TTDPRINT(@"All_datas_ %@", panelIdToData_);
        res = [[ut append:header, type, panelIdToData, CHECKSUM, nil] uppercaseString];
        res = [[ut append:panelIdToData, CHECKSUM, nil] uppercaseString];

        TTDPRINT(@"final data %@", res);
    }

    return res;

}

- (NSString *)fillNameToHex:(NSString *)name length:(int)length {
    NSString *subName = [name substringWithRange:NSMakeRange(0, MIN(10, name.length))];
    NSString *res = @"";
    for (int i = 0; i < subName.length; i++) {
        unichar chars = [subName characterAtIndex:i];
        NSString *charHexString = [self upfillHexInt:chars toLength:2];
        res = [res stringByAppendingString:charHexString];
    }
    while (res.length < length) {
        res = [res stringByAppendingString:@"0"];
    }
    return res;
}

- (NSString *)upfillHex:(NSNumber *)number toLength:(int)length {
    return [self upfillHexInt:number.intValue toLength:length];
}

- (NSString *)upfillHexInt:(int)number toLength:(int)length {
    NSString *formatString = [NSString stringWithFormat:@"0%ix", length];
    formatString = [@"%" stringByAppendingString:formatString];
    return [NSString stringWithFormat:formatString, number];
}

- (NSNumber *)HSB:(NSString *)data6 {
    int i = [self stringToInt:data6].intValue >> 4;
    return [NSNumber numberWithInt:i];
}

- (NSNumber *)LSB:(NSString *)data6 {
    int i = [self stringToInt:data6].intValue % (1 << 4);
    return [NSNumber numberWithInt:i];
}


//#define readText(a) [input substringWithRange:NSMakeRange(counter, a)];counter+=a;
//- (PanelCommandPoint *)parseCloudToPanel:(NSString *)input2 {


//- (DevicePoint *)parsePoint:(NSString *)input2 {
- (NSArray *)parsePoint:(AylaDatapoint *)input3 {
    return [self parsePoint:input3 withInfo:[[NSMutableDictionary alloc] init] historyInfo:nil];
}

- (NSArray *)parseHistoryPoint:(NSArray *)input3 {
    DevicePoint *point = [input3 objectAtIndex:0];
    NSDictionary *dict = [input3 objectAtIndex:1];
    NSArray *array = [self parsePoint:point withInfo:[[NSMutableDictionary alloc] init] historyInfo:dict];
    [[NSManagedObjectContext MR_contextForCurrentThread] MR_saveToPersistentStoreAndWait];
    return array;
}

- (bool)validPoint:(NSString *)input2 {
    if (empty(input2) || input2.length < 25) {
//        TTDPRINT(@"Device Point input2 length too short %@", input2);
        return false;
    }
    NSString *input4 = [input2 stringByTrimmingCharactersInSet:[NSCharacterSet whitespaceAndNewlineCharacterSet]];
    if (input4.length < 25) {
//        TTDPRINT(@"Device Point input length too short %@", input4);
        return false;
    }
    return true;
}

- (NSArray *)parsePoint:(AylaDatapoint *)input3 withInfo:(NSDictionary *)info historyInfo:(NSDictionary *)info1 {


    NSString *input2 = input3.sValue;

    if (empty(input2) || input2.length < 25) {
//        TTDPRINT(@"Device Point input2 length too short %@", input2);
        return @[[[NSArray alloc] init], @0];
    }
    NSString *input4 = [input2 stringByTrimmingCharactersInSet:[NSCharacterSet whitespaceAndNewlineCharacterSet]];
    if (input4.length < 25) {
//        TTDPRINT(@"Device Point input length too short %@", input4);
        return @[[[NSArray alloc] init], @0];
    }
//    NSData *data = [NSData dataWithBase64EncodedString:input2];
    NSData *data = [NSData dataFromBase64String:input2];
    NSString *input = [data hexadecimalString];

    int counter = 0;
    NSString *header = readText(1);
    NSString *packageType = readText(1);
    NSString *sensorLogCount = readText(2);
    NSNumber *sensorLogCountInt = [self stringToInt:sensorLogCount];

    NSString *length = readText(2);
    NSString *multiFrame = [input substringWithRange:NSMakeRange(1 + 1 + 2 + 2, input.length - (1 + 1 + 2 + 2) - 2)];
//    assert(multiFrame.length % 32 == 0);
    int frameCount = multiFrame.length / 32;
//    TTDPRINT(@"Parsing frame %@", input);

    NSMutableArray *res = [[NSMutableArray alloc] init];
    for (int i = 0; i < frameCount; i++) {
        NSString *frameString = [multiFrame substringWithRange:NSMakeRange(i * 32, 32)];
        DevicePoint *commandPoint = [self parseAylaFrame:frameString packageType:packageType dataPoint:input3 info:info historyInfo:info1];
        if (commandPoint!=nil)
        [res addObject:commandPoint];

    }
    return @[res, sensorLogCountInt];
}

- (DevicePoint *)parseAylaFrame:(NSString *)input packageType:(NSString *)type dataPoint:(AylaDatapoint *)point2 info:(NSDictionary *)info1 historyInfo:(NSDictionary *)info2 {
    if ([type isEqualToString:@"1"]) {
        return [self parseInfoFrame:input point:point2 allInfo:info1];
    } else if ([type isEqualToString:@"2"]) {
        return [self parseHistoryFrame:input point:point2 historyInfo:info2];
    }
    return nil;
}

- (DevicePoint *)parseHistoryFrame:(NSString *)input point:(AylaDatapoint *)point2 historyInfo:(NSDictionary *)info1 {

    int counter = 0;


    NSString *data1_3 = readText(6);
    NSString *data4 = readText(2);
    NSString *data5 = readText(2);
    NSString *data6 = readText(2);
    NSString *data7 = readText(2);
    NSString *data8 = readText(2);
    NSString *data9 = readText(2);
    NSString *data10 = readText(2);
    NSString *data11 = readText(2);
    NSString *data12 = readText(2);
    NSString *data13 = readText(2);
    NSString *data14 = readText(2);
    NSString *data15 = readText(2);
    NSString *data16 = readText(2);
    //should replace current frame?
    NSNumber *sensorType = [self stringToInt:data4];
//    DevicePoint *oldPoint = [DevicePoint getLastHistoryPoint:data1_3 sensorType:sensorType.intValue];

    DevicePoint *oldPoint = [info1 objectForKey:info1];
    if (oldPoint == nil)
        oldPoint = [DevicePoint getImportedHistoryPoint:input];
    if (oldPoint != nil) {
//        oldPoint.createdAt = [ut parseAylaTime:point2.createdAt];
//        oldPoint.createdAtStr = point2.createdAt;
        if (oldPoint.sensorId.intValue == 0) {
            return oldPoint;
        }
        return oldPoint;
    }
    TTDPRINT(@"importing history point %@", input);


//    NSNumber *serialPoint = [self stringToInt:data1];
    DevicePoint *dataFrame = [DevicePoint MR_createEntity];
    dataFrame.raw = input;
    dataFrame.dsn = gblCurrentPanel.dsn;
    dataFrame.sensorId = [self stringToInt:data1_3];
    dataFrame.type = @2;


    dataFrame.sensorType = sensorType;
    int data5Int = [self stringToInt:data5].intValue;
    TTDPRINT(@"data5 is %@(%i)", data5, data5Int);
//    int data7Int = data7.intValue;
    int data6Int = [self stringToInt:data6].intValue;;
    int data7Int = [self stringToInt:data7].intValue;;
    TTDPRINT(@"data7 is %@(%i)", data7, data7Int);
    if (dataFrame.sensorType.intValue == 1) {

//        int i = data5Int & 1 << 7;
//        int data5 = data5Int ;
        dataFrame.wifiDisconnect = [NSNumber numberWithInt:(data5Int & 1 << 7) > 0];
        dataFrame.tamper = [NSNumber numberWithInt:(data5Int & 1 << 6) > 0];
        dataFrame.lowVoltage = [NSNumber numberWithInt:(data5Int & 1 << 5) > 0];
        int lowerPart = data5Int % 16;
        switch (lowerPart) {
            case 0:
                dataFrame.unknown = @1;
                break;
            case 5:
                dataFrame.panic = @1;
                break;
            case 6:
                dataFrame.force = @1;
                break;

        }
    } else {

        dataFrame.sensorLost = isBit(data5Int, 7);
        dataFrame.tamper = isBit(data5Int, 6);
        dataFrame.lowVoltage = isBit(data5Int, 5);
        if (dataFrame.lowVoltage == nil) {
            unexpectedCase();
        }
        dataFrame.trigger = isBit(data5Int, 0);
//        if (dataFrame.sensorType.intValue == 3) {
        dataFrame.closeTrigger = isBit(data5Int, 1);
//        }
        dataFrame.modeAlert = isBit(data7Int, 3);
        dataFrame.modeAlertHome = isBit(data7Int, 2);
        dataFrame.modeArmHome = isBit(data7Int, 1);
        dataFrame.modeArm = isBit(data7Int, 0);

//
//        NSString *namez = @"";
//        for (int i = 0; i < 10; i++) {
//            int loc = 24 + i * 2;
//            NSString *charHex = [input substringWithRange:NSMakeRange(loc, 2)];
//            NSNumber *intValue = [self stringToInt:charHex];
//            if (intValue.intValue == 0) {
//                break;
//            }
//            namez = [NSString stringWithFormat:@"%@%c", namez, intValue.charValue];
//        }
//        dataFrame.sensorName = namez;

    }
    dataFrame.year = [self stringToInt:data8];
    dataFrame.month = [self stringToInt:data9];
    dataFrame.day = [self stringToInt:data10];
    dataFrame.hour = [self stringToInt:data11];
    dataFrame.minute = [self stringToInt:data12];


    NSCalendar *cal = [NSCalendar currentCalendar];
    NSTimeZone *timeZone = [TimeZonePicker getTimeZoneFromString:gblCurrentPanel.timezone];
    [cal setTimeZone:timeZone];
    NSDateComponents *const components =
            [cal components:(NSYearCalendarUnit | NSHourCalendarUnit | NSMinuteCalendarUnit | NSSecondCalendarUnit) fromDate:[NSDate date]];
    [components setYear:2000 + dataFrame.year.intValue];
    [components setMonth:dataFrame.month.intValue];
    [components setDay:dataFrame.day.intValue];
    [components setHour:dataFrame.hour.intValue];
    [components setMinute:dataFrame.minute.intValue];

    NSDate *date = [cal dateFromComponents:components];
    dataFrame.createdAt = date;
    dataFrame.createdAtStr = point2.createdAt;


    //for each dataFrame find back the sensor it belongs to, add to its data point history
    return dataFrame;
}

- (DevicePoint *)parseInfoFrame:(NSString *)input point:(AylaDatapoint *)point allInfo:(NSDictionary *)dict {

    int counter = 0;


    NSString *data1_3 = readText(6);
    NSString *data4 = readText(2);
    NSString *data5 = readText(2);
    NSString *data6 = readText(2);
    NSString *data7 = readText(2);
    NSString *data8 = readText(2);
    NSString *data9 = readText(2);
    NSString *data10 = readText(2);
    NSString *data11 = readText(2);
    NSString *data12 = readText(2);
    NSString *data13 = readText(2);
    NSString *data14 = readText(2);
    NSString *data15 = readText(2);
    NSString *data16 = readText(2);
    NSNumber *sensorType = [self stringToInt:data4];
    NSNumber *sensorTypeIn = [self stringToInt:data4];
    int sensorId = [self stringToInt:data1_3].intValue;
    NSString *nowComboId = [NSString stringWithFormat:@"%i_%i", sensorType.intValue, sensorId];
    DevicePoint *oldPoint = [dict objectForKey:nowComboId];
    if (oldPoint == nil) {


        oldPoint = [DevicePoint getLastInfoPoint:sensorId sensorType:sensorType.intValue];
    }
    if (oldPoint != nil && [oldPoint.raw isEqualToString:input]) {
        oldPoint.createdAt = [ut parseAylaTime:point.createdAt];
        oldPoint.createdAtStr = point.createdAt;

        return oldPoint;
    }

    TTDPRINT(@"importing info point %@", input);

//    NSNumber *serialPoint = [self stringToInt:data1];
//    DevicePoint *dataFrame = [DevicePoint MR_createEntity];
    DevicePoint *dataFrame;
    if (oldPoint != nil) {
        dataFrame = oldPoint;
    } else {
        dataFrame = [DevicePoint MR_createEntity];;
    }

    dataFrame.raw = input;
    dataFrame.dsn = gblCurrentPanel.dsn;
    dataFrame.sensorId = [self stringToInt:data1_3];
    dataFrame.createdAt = [ut parseAylaTime:point.createdAt];
    dataFrame.createdAtStr = point.createdAt;
    dataFrame.type = @1;
    dataFrame.version = [self stringToInt:data13];

    dataFrame.sensorType = sensorTypeIn;
    int data5Int = [self stringToInt:data5].intValue;
    TTDPRINT(@"data5 is %@(%i)", data5, data5Int);
//    int data7Int = data7.intValue;
    int data6Int = [self stringToInt:data6].intValue;;
    int data7Int = [self stringToInt:data7].intValue;;
    TTDPRINT(@"data7 is %@(%i)", data7, data7Int);
    if (dataFrame.sensorType.intValue == 1) {

//        int i = data5Int & 1 << 7;
//        int data5 = data5Int ;
        dataFrame.dataChange = [NSNumber numberWithInt:(data5Int & 1 << 7) > 0];
        dataFrame.tamper = [NSNumber numberWithInt:(data5Int & 1 << 6) > 0];
        dataFrame.lowVoltage = [NSNumber numberWithInt:(data5Int & 1 << 5) > 0];
        dataFrame.acPower = [NSNumber numberWithInt:(data5Int & 1 << 4) > 0];
        dataFrame.arm = @0;
        dataFrame.home = @0;
        dataFrame.alert = @0;
        dataFrame.disarm = @0;
        dataFrame.panic = @0;

        int lowerPart = data5Int % 16;
        switch (lowerPart) {
            case 1:
                dataFrame.arm = @1;
                break;
            case 2:
                dataFrame.home = @1;
                break;
            case 3:
                dataFrame.alert = @1;
                break;
            case 4:
                dataFrame.disarm = @1;
                break;
            case 5:
                dataFrame.panic = @1;
                break;
        }
        NSNumber *number7 = [self stringToInt:data7];
        dataFrame.exitDelayMinutes = [self removeSignBit:number7];
        dataFrame.exitOnOff = [self getSignBit:number7];
        dataFrame.exitDelaySecond = [self stringToInt:data8];
        NSNumber *number9 = [self stringToInt:data9];
        dataFrame.entryDelayMinutes = [self removeSignBit:number9];
        dataFrame.entryDelaySecond = [self stringToInt:data10];
        dataFrame.entryOnOff = [self getSignBit:number9];
        NSNumber *number11 = [self stringToInt:data11];
        dataFrame.alarmTimeMinutes = [self removeSignBit:number11];
        dataFrame.alarmTimeSecond = [self stringToInt:data12];
        dataFrame.alarmOnOff = [self getSignBit:number11];
    } else {

        if (dataFrame.sensorType.intValue != 2) {
            dataFrame.modeArm = isBit(data6Int, 0);
            dataFrame.modeArmHome = isBit(data6Int, 1);
            dataFrame.modeAlertHome = isBit(data6Int, 2);
            dataFrame.modeAlert = isBit(data6Int, 3);
        }
        dataFrame.dataChange = isBit(data5Int, 7);

        NSString *namez = @"";
        for (int i = 0; i < 10; i++) {
            int loc = 2 * 6 + i * 2;
            NSString *charHex = [input substringWithRange:NSMakeRange(loc, 2)];
            NSNumber *intValue = [self stringToInt:charHex];
            if (intValue.intValue == 0) {
                break;
            }
            namez = [NSString stringWithFormat:@"%@%c", namez, intValue.charValue];
        }
        dataFrame.sensorName = namez;

    }
    return dataFrame;
}

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


/**
*       1110010000000000011010000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000011110000110100001001000001000001000100101011
*/

//const NSString * CMD_panel;
//const NSString * CMD_remote;
//const NSString * CMD_siren_sensor;

- (NSString *)sendCommand:(NSString *)inputIn
                    data1:(int)subCommand
                 duration:(long)durationInSecond
              oldPassword:(long)oldPassword
               relayOnOff:(NSString *)onOffString
                newSensor:(int)sensorNumber
              newPassword:(long)newPassword {
    return [self sendCommand:inputIn data1:subCommand duration:durationInSecond oldPassword:oldPassword
                  relayOnOff:onOffString newSensor:sensorNumber newPassword:newPassword zone:0 successFx:nil failFx:nil];

}

- (NSString *)sendCommand:(NSString *)inputIn
                    data1:(int)subCommand
                     zone:(int)zoneNo {
    return [self sendCommand:inputIn data1:subCommand duration:0 oldPassword:0 relayOnOff:nil newSensor:0 newPassword:0
                        zone:zoneNo successFx:nil failFx:nil];

}

- (NSString *)sendCommand:(NSString *)inputIn
                    data1:(int)subCommand
                 duration:(long)durationInSecond
              oldPassword:(long)oldPassword
               relayOnOff:(NSString *)onOffString
                newSensor:(int)sensorNumber
              newPassword:(long)newPassword
                successFx:(void (^)(AylaResponse *response, AylaDatapoint *))fx failFx:(void (^)(AylaError *))fx1 {
    return [self sendCommand:inputIn data1:subCommand duration:durationInSecond oldPassword:oldPassword
                  relayOnOff:onOffString newSensor:sensorNumber newPassword:newPassword zone:0 successFx:fx failFx:fx1];
}

typedef void (^PointBlock)(AylaResponse *, AylaDatapoint *);

typedef void (^ErrorBlock)(struct Ayla_error *);

- (NSString *)sendCommand:(NSString *)inputIn
                    data1:(int)subCommand
                 duration:(long)durationInSecond
              oldPassword:(long)oldPassword
               relayOnOff:(NSString *)onOffString
                newSensor:(int)sensorNumber
              newPassword:(long)newPassword
                     zone:(int)zoneNumber
                successFx:(void (^)(AylaResponse *response, AylaDatapoint *))fx failFx:(void (^)(AylaError *))fx1 {
//    AylaProperty *properties = [gblCurrentDevice.properties valueForKeyPath:@"control_cloud_to_panel"];
//    NSMutableDictionary *callParams = [NSMutableDictionary new];
//    [callParams setObject:[NSNumber numberWithInt:30] forKey:@"count"];
    void (^cancelFx)() = [ut showLoading];
    __block void (^successFx)(AylaResponse *, AylaDatapoint *) = fx;
    __block void (^failFx)(AylaError *) = fx1;


//    [properties getDatapointsByActivity:nil success:^(AylaResponse *response, NSArray *datapoints) {
//        @autoreleasepool {
//            NSMutableArray *array = [[NSMutableArray alloc] init];
//
//            if (datapoints.count > 0) {
////                AylaDatapoint *datas = [datapoints objectAtIndex:0];
//
//                for (AylaDatapoint *aylaDatapoint in datapoints) {
//                    if ([ut isValidDataPoint:aylaDatapoint]) {
//
//                        DevicePoint *oldPoint = [DevicePoint findPoint:aylaDatapoint];;
//                        if (oldPoint == nil) {
//                            DevicePoint *frame = [self parsePoint:aylaDatapoint];
//                            frame.createdAt = aylaDatapoint.createdAt;
//                            [array addObject:frame];
//
//                        }
//                    }
//
//                }
//
//            }
//            [[NSManagedObjectContext MR_contextForCurrentThread] MR_saveToPersistentStoreAndWait];
    [self sendPanelCore:inputIn
              successFx:^(AylaResponse *response2, AylaDatapoint *datapointCreated) {
                  if (successFx != nil)
                      successFx(response2, datapointCreated);

                  cancelFx();

              }
                 failFx:^(AylaError *err) {
                     if (cancelFx != nil)
                         cancelFx();
                     failFx(err);
                 }];

//        }
//    }                           failure:^(AylaError *err) {
//        @autoreleasepool {
//        }
//    }];


    return @"";

}

- (void)sendPanelCore:(NSString *)inputIn successFx:(void (^)(AylaResponse *, AylaDatapoint *))fx failFx:(void (^)(AylaError *))fx1 {

    NSString *input = [inputIn lowercaseString];
    //if is panel
    int data6Lower = 0;
//    NSArray *allPoints = [DevicePoint MR_findAll];



    DevicePoint *source = [DevicePoint getLastPanelPoint];

    if (source == nil) {
        {

        }
    }

    DevicePoint *pending = [DevicePoint getClientPoint];

    DevicePoint *point = [source clonePoint];
    point.type = @3;
//    point.createdAt = [NSDate date];
    point.arm = @0;
    point.home = @0;
    point.alert = @0;
    point.disarm = @0;
    point.panic = @0;
    point.force = @0;
    if ([input isEqualToString:@"arm"]) {
        point.arm = @1;
    } else if ([input isEqualToString:@"home"]) {
        point.home = @1;
    } else if ([input isEqualToString:@"alert"]) {
        point.alert = @1;
    } else if ([input isEqualToString:@"disarm"]) {
        point.disarm = @1;
    } else if ([input isEqualToString:@"panic"]) {
        point.panic = @1;
    } else if ([input isEqualToString:@"force"]) {
        point.force = @1;
    }
    point.editMode = @0;


    pending.type=point.type;
    pending.home=point.home;
    pending.alert=point.alert;
    pending.disarm=point.disarm;
    pending.panic=point.panic;
    pending.force=point.force;
    pending.createdAt = [NSDate date];
    [self saveContext];

    NSString *res = [self getBackCloudPoint:point];

//    AylaDatapoint *dataPoint = [AylaDatapoint new];
//    dataPoint.sValue = res;
//    dataPoint.sValue = debug;
//    dataPoint.sValue = dataPackage;
//    bool findDevice = false;
    [self sendCommandString:res];

//    AylaProperty *properties = [gblCurrentDevice.properties valueForKeyPath:@"control_cloud_to_panel"];
//    if (properties == nil|| dataPoint == nil|| point == nil) {
//        [ut showAlert:@"Panel is not ready yet"];
//        [self syncInfo];
//        return;
//    }
//    if (!self.debugMode) {
//
//        NSArray *tuple = nil;
////        void (^fx)(AylaResponse *, AylaDatapoint *);
//        if (fx == nil) {
//            fx = ^(AylaResponse *response, AylaDatapoint *datapointCreated) {
//            };
//        }
//        if (fx1 == nil) {
//            fx1 = ^(AylaError *err) {
//            };
//        }
//        tuple = @[properties, dataPoint, point, fx, fx1,];
//        @synchronized (self.waitingCommands) {
//            [self.waitingCommands addObject:tuple];
//        }
//
//
//        [self tryDispatch];
//
//    }
}

- (void)tryDispatch {
    if (self.waitingCommands.count == 0) {
        return;
    }
//    if (!self.sending) {
//        self.sending = true;
//        @synchronized (self.waitingCommands) {
    NSArray *tuple = [self.waitingCommands objectAtIndex:0];
    [self.waitingCommands removeObjectAtIndex:0];

    if (![tuple isKindOfClass:[NSArray class]]) {
        ///?????
        [self tryDispatch];
        return;
    }

    AylaProperty *devices = [tuple objectAtIndex:0];
    __block AylaDatapoint *dataPoint = [tuple objectAtIndex:1];
    DevicePoint *devicePoint;
    if (tuple.count > 2) {
        devicePoint = [tuple objectAtIndex:2];
        if (![devicePoint isKindOfClass:[DevicePoint class]]) {
            devicePoint = nil;
        }
    }

    PointBlock fx = nil;
    if (tuple.count > 3) {
        fx = [tuple objectAtIndex:3];

    }
    ErrorBlock fx1;
    if (tuple.count > 4) {
        fx1 = [tuple objectAtIndex:4];
    }

    NSString *in = dataPoint.sValue;

    NSString *base64Str = [ut hexToBase64:in];
    NSString *res = base64Str;
    dataPoint.sValue = res;
//    NSLog(@"UPLOAD AYLAPoint source %@", in);
    NSLog(@"UPLOAD AYLAPoint %@", dataPoint.sValue);
    NSLog(@"pending queue size %i", self.waitingCommands.count);
    //add a point in the queue to see gracefully upload data
    self.lastSendDate = [NSDate date];
    [devices createDatapoint:dataPoint
                     success:^(AylaResponse *response, AylaDatapoint *datapointCreated) {

//                                          UIAlertView *av = [[UIAlertView alloc] initWithTitle:@"Sended Successfully" message:ascii delegate:nil cancelButtonTitle:nil otherButtonTitles:@"Ok", nil];
//                                          [av show];
//                                 self.sending = false;
                         devicePoint.createdAt = [ut parseAylaTime:datapointCreated.createdAt];
                         if (devicePoint != nil) {
//                                     int sensorType = devicePoint.sensorType.intValue;
                             //panel update
                             AylaProperty *prop = nil;
//                                     prop = [[gblCurrentDevice properties] objectForKey:@"panel_status"];
                             prop = [[gblCurrentDevice properties] objectForKey:@"control_cloud_to_panel"];
                             if (prop != nil) {
//                                         NSMutableDictionary *callParams = [NSMutableDictionary new];
//                                         [callParams setObject:@1 forKey:@"count"];

//                                         [prop getDatapointsByActivity:callParams success:^(AylaResponse *response, NSArray *datapoints) {
//                                             NSMutableArray *array = [[NSMutableArray alloc] init];
//
//                                             if (datapoints.count > 0) {
//                                                 for (AylaDatapoint *aylaDatapoint in datapoints) {
//                                                     if ([ut isValidDataPoint:aylaDatapoint]) {
//                                                         DevicePoint *oldPoint = [DevicePoint findPoint:aylaDatapoint];;
//                                                         if (oldPoint == nil) {
//                                                             DevicePoint *frame = [self parsePoint:aylaDatapoint.sValue];
//                                                             frame.createdAt = aylaDatapoint.createdAt;
//                                                             [array addObject:frame];
//                                                         }
//                                                     }
//
//                                                 }
//                                                 AylaDatapoint *lastPoint = [datapoints objectAtIndex:0];
//
//                                                 if (![self hadDataChanged:lastPoint expectedPoint:dataPoint]) {
////                                                     [ut showAlert:@"Panel failed to update" withContent:@"Please make sure panel is online"];
//                                                 }
//                                             } else {
////                                                 [ut showAlert:@"Panel failed to update" withContent:@"Please make sure panel is online"];
//                                             }
                                 [self saveContext];
//
//                                             //after send panel command , need to check panel is
                                 if (fx != nil) {
                                     fx(response, datapointCreated);
                                 }
//
//
                                 NSLog(@"FINISH AYLAPoint %@ %@", datapointCreated.sValue, datapointCreated.createdAt);
                                 [self tryDispatch];
//                                         }                     failure:^(AylaError *err) {
//                                             @autoreleasepool {
//                                             }
//                                         }];
                             };
                         } else {
                             fx(response, datapointCreated);

                         }


                     }
                     failure:^(AylaError *err) {
//                                 self.sending = false;
                         NSString *errorMsg = [NSString stringWithFormat:@"ErrorCode : %i\n", err.errorCode];
                         NSString *debug = [debug stringByAppendingString:errorMsg];
                         UIAlertView *av = [[UIAlertView alloc] initWithTitle:@"Sended Failed" message:debug delegate:nil cancelButtonTitle:nil otherButtonTitles:@"Ok", nil];
                         [av show];
//                                 NSError *ns = err.nativeErrorInfo;
                         NSError *ns = err.nativeErrorInfo;
                         if (ns.code == NSURLErrorBadServerResponse && err.httpStatusCode == 401) {
                             [AylademoAppDelegate popUpAlert:@"pop" code:ns.code message:16];
//                             [self logout];
                         }
//                                 [self tryDispatch];
                         NSLog(@"FAILED AYLAPoint %@", dataPoint.sValue);
                         TTDPRINT(@"%@", err);
                         [self.waitingCommands insertObject:dataPoint atIndex:0];
                         [self tryDispatch];

                     }];
//        }

//        self.sending = false;
    [self tryDispatch];

//    } else {
//        NSLog(@"someone Sending, wait,queue size %i", self.waitingCommands.count);
//        if (self.lastSendDate != nil && [self.lastSendDate timeIntervalSinceNow] < -20) {
//            [self.waitingCommands removeObjectAtIndex:0];
//
//        }
//        [self tryDispatch];
//
//    }
}

- (BOOL)hadDataChanged:(AylaDatapoint *)datapoint expectedPoint:(AylaDatapoint *)point {
    NSDate *updateTime = [ut parseAylaTime:datapoint.createdAt];
    //should be within 10
    if (updateTime.timeIntervalSinceNow < -20) {
        return false;
    }
    NSString *nowSValue = [datapoint.sValue substringWithRange:NSMakeRange(8, datapoint.sValue.length - 2 - 8)];
    NSString *expectSValue = [point.sValue substringWithRange:NSMakeRange(8, point.sValue.length - 2 - 8)];
    if ([nowSValue isEqualToString:expectSValue]) {
        return true;
    } else return false;

}

- (void)saveContext {
    [[NSManagedObjectContext MR_contextForCurrentThread] MR_saveToPersistentStoreAndWait];
}

- (NSString *)changeAscii:(NSString *)package debug:(bool)debug {
    NSString *res = @"";
    if (debug) {
//        res = @"[";
    }
    for (int i = 0; i < package.length; i += 8) {
        NSString *subPath = [package substringWithRange:NSMakeRange(i, 8)];
        int asciiCode = [self convertBinaryToInt:subPath];
        if (debug) {
            NSString *string = [NSString stringWithFormat:@"%i_", asciiCode];
            res = [res stringByAppendingString:string];
        } else {
//            char characterCodeInASCII = asciiCode;
//            NSString *stringWithAInIt = [[NSString alloc] initWithBytes:&characterCodeInASCII length:1 encoding:NSASCIIStringEncoding];
//            s
            NSString *string = [NSString stringWithFormat:@"%02x", (unsigned int) asciiCode];
            res = [res stringByAppendingString:string];
        }
    }
    if (debug) {
//        res = [res stringByAppendingString:@"]"];
    }

    return res;
}

- (NSString *)upfillTime:(long)second
                toLength:(int)length {
    if (second <= 127) {
        return [@"0" stringByAppendingString:[self upfill:second toLength:length - 1]];
    }
    second = second / 60;
    return [@"1" stringByAppendingString:[self upfill:second toLength:length - 1]];;
}

- (NSString *)upfillString:(NSString *)string
                  toLength:(int)length {
    while (string.length < length) {
        string = [@"0" stringByAppendingString:string];
    }
    return string;
};

- (NSString *)toBinary:(NSUInteger)input {
    if (input == 1 || input == 0) {
        return [NSString stringWithFormat:@"%u", input];
    }
    return [NSString stringWithFormat:@"%@%u", [self toBinary:input / 2], input % 2];
}

- (NSString *)toBinaryString:(NSInteger)input {
    return [NSString stringWithFormat:@"%@", [self toBinary:input]];
}

- (NSString *)upfill:(int)i
            toLength:(char)i1 {
    NSString *binaryForm = [self toBinary:i];
    while (binaryForm.length < i1) {
        binaryForm = [@"0" stringByAppendingString:binaryForm];
    }
    return binaryForm;
}

- (NSNumber *)stringToInt:(NSString *)input {
    NSScanner *scanner = [NSScanner scannerWithString:input];
    unsigned result = 0;
    [scanner scanHexInt:&result];

//    int total = 0;
//
//    for (int i = 0; i < input.length; i++) {
//        NSString *character = [input substringWithRange:NSMakeRange(i, 1)];
//
//        if ([character isEqualToString:@"1"]) {
//            double d = pow(2, i);
//            total += d;
//        }
//    }
    return [NSNumber numberWithInt:result];
}

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


//static NSString *CRC8_Divisor = @"11101011";
static NSString *CRC8_Divisor = @"00110001";
static int CRC8_Int = 235;


typedef unsigned char u8;
//半字节CRC8 table,0x31 左移正序余式表
u8 const u8cCrcHalfTab[16] =
        {
                0x0, 0x31, 0x62, 0x53, 0xC4, 0xF5, 0xA6, 0x97,
                0xB9, 0x88, 0xDB, 0xEA, 0x7D, 0x4C, 0x1F, 0x2E
        };


/*
功能:按半字节计算CRC8,左移正序
入口:1:要计算数据的首地址
	 2:数据长度
出口:返回CRC8
*/
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

- (NSString *)getCheckSum:(NSString *)package {

    //each char be 4 digit binary

//    NSString *remain = string;
//    TTDPRINT(@"crc started %@",string);
//    string.length/8;
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

    NSString *res = [self upfill:(int) code toLength:8];
    return res;
}

- (int)crc8Checksum:(NSString *)dataFrame {

    char j;
    int crc8 = 0;
    int x = 0;

    for (int i = 0; i < [dataFrame length]; i += 2) {
        x = [self stringToInt:[dataFrame substringToIndex:2]].intValue;
//        int x1=[dataFrame characterAtIndex:i]<<8;
//        int x2=[dataFrame characterAtIndex:i+1];
//        x = x1+x2;

        for (int k = 0; k < 8; k++) {
            j = 1 & (x ^ crc8);
            crc8 = ((int) floor(crc8 / 2)) & 0xFF;
            x = ((int) floor(x / 2)) & 0xFF;
            if (j != 0) {
                crc8 = crc8 ^ 0x8C;
            }
        }
    }
    return crc8;
}

- (NSString *)getHexCheckSum:(NSString *)hexIn {

    NSString *package = @"";

    for (int i = 0; i < hexIn.length; i++) {
        NSString *subChar = [hexIn substringWithRange:NSMakeRange(i, 1)];
        NSNumber *intvalue = [self stringToInt:subChar];
        NSString *binary = [self upfill:intvalue.intValue toLength:4];
        package = [package stringByAppendingString:binary];
    }
//    TTDPRINT("hex to binary %@ => %@", hexIn, package);
    //each char be 4 digit binary

//    NSString *remain = string;
//    TTDPRINT(@"crc started %@",string);
//    string.length/8;
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

//- (NSString *)getCheckSum2:(NSString *)string {
//
//    const NSUInteger stringLength = string.length;
//    const NSUInteger appendBit = 8 - (stringLength % 8);
//    NSString *appended = string;
//    for (int i = 0; i < appendBit; i++) {
//        appended = [appended stringByAppendingString:@"0"];
//    }
//    const NSUInteger integer = appended.length;
//    int bitRound = integer / 8;
//    int totalCount = 0;
//    for (int i = 0; i < bitRound; i++) {
//        NSString *const subString = [appended substringWithRange:NSMakeRange(i * 8, 8)];
//        int intValue = [self convertBinaryToInt:subString];
//        totalCount = totalCount + intValue;
////        TTDPRINT(@"bit value %@ %i %i", subString, intValue, totalCount);
//    }
////    NSString *const checkSum = [self toBinaryString:totalCount];
//    NSString *const checkSum = [self upfill:totalCount toLength:8];;
//    NSString *checkSum2 = checkSum;
//    if (checkSum2.length > 8) {
//        checkSum2 = [checkSum substringWithRange:NSMakeRange(checkSum.length - 8, 8)];
//    }
////    NSString *lastIndex = [checkSum2 substringFromIndex:7];
////    checkSum2 = lastIndex;
////    if ([lastIndex isEqualToString:@"1"]) {
////        checkSum2 = [checkSum2 stringByAppendingString:@"1"];
////    }
//    return checkSum2;
//}

- (void)storeNewFrame:(DataFrame *)dictionary {

}
//-Panel = 0000 0000
//-remote =0000 0001
//-Pir sensor =0000 0010
//-Door/ window sensor =0000 0011
//-Garage sensor =0000 0100
//-Flood Sensor =0000 0101
//-Shock Sensor =0000 0110
//-Mat sensor =0000 0111
//-Siren Sensor =0000 1000
//-Indoor siren sensor =0000 1001
//-Outdoor siren sensor =0000 1010
//-GSM dial sensor =0000 1011
//-Camera sensor =0000 1100
//-Socket sensor =0000 1101




- (NSString *)formatEvent:(DataPoint *)point {
    NSString *cmd = [NSString stringWithFormat:@"Unknown command %@ %@", point.sensorId, point.data1];
    int data1 = point.data1.intValue;
    int sensorId = point.sensorId.intValue;
    switch (sensorId) {
        //panel
        case SENSOR_Panel: {

            cmd = [NSString stringWithFormat:@"Heartbeat:%@ Tamper:%@ Low Voltage:%@ Power:%@"
                    , bitOn(data1, 7)
                    , bitOn(data1, 6)
                    , bitOn(data1, 5)
                    , bitOn(data1, 4)
            ];
        }
            break;


        case SENSOR_Remote: {
            //remote
            cmd = [NSString stringWithFormat:@"Heartbeat:%@ Tamper:%@ Low Voltage:%@ Alert:%@ Home:%@ Disarm:%@ Arm:%@"
                    , bitOn(data1, 7)
                    , bitOn(data1, 6)
                    , bitOn(data1, 5)
                    , bitOn(data1, 3)
                    , bitOn(data1, 2)
                    , bitOn(data1, 1)
                    , bitOn(data1, 0)];
        }
            break;

        case SENSOR_PIR: {
            //pir sensor
            cmd = [NSString stringWithFormat:@"Heartbeat:%@ Tamper:%@ Low Voltage:%@ Trigger:%@"
                    , bitOn(data1, 7)
                    , bitOn(data1, 6)
                    , bitOn(data1, 5)
                    , bitOn(data1, 1)];
        }
            break;
        case SENSOR_DOOR: {
            //door sensor
            cmd = [NSString stringWithFormat:@"Heartbeat:%@ Tamper:%@ Low Voltage:%@ Close Trigger:%@ Open Trigger:%@"
                    , bitOn(data1, 7)
                    , bitOn(data1, 6)
                    , bitOn(data1, 5)
                    , bitOn(data1, 2)
                    , bitOn(data1, 1)
            ];
        }
            break;
        case SENSOR_GARAGE: {
            //garage
            cmd = [NSString stringWithFormat:@"Heartbeat:%@ Tamper:%@ Low Voltage:%@ Close Trigger:%@ Open Trigger:%@"
                    , bitOn(data1, 7)
                    , bitOn(data1, 6)
                    , bitOn(data1, 5)
                    , bitOn(data1, 2)
                    , bitOn(data1, 1)
            ];

        }
            break;
        case SENSOR_FLOOD: {
            //flood
            cmd = [NSString stringWithFormat:@"Heartbeat:%@ Tamper:%@ Low Voltage:%@ Trigger:%@"
                    , bitOn(data1, 7)
                    , bitOn(data1, 6)
                    , bitOn(data1, 5)
                    , bitOn(data1, 1)
            ];
        }
            break;
        case SENSOR_SHOCK: {
            //flood
            cmd = [NSString stringWithFormat:@"Heartbeat:%@ Tamper:%@ Low Voltage:%@ Trigger:%@"
                    , bitOn(data1, 7)
                    , bitOn(data1, 6)
                    , bitOn(data1, 5)
                    , bitOn(data1, 1)
            ];

        }
            break;

        case SENSOR_MAT: {
            cmd = [NSString stringWithFormat:@"Heartbeat:%@ Tamper:%@ Low Voltage:%@ Trigger:%@"
                    , bitOn(data1, 7)
                    , bitOn(data1, 6)
                    , bitOn(data1, 5)
                    , bitOn(data1, 1)
            ];

        }
            break;

        case SENSOR_SIREN: {
            cmd = [NSString stringWithFormat:@"Heartbeat:%@ Tamper:%@ Low Voltage:%@ Close Siren:%@ Open Siren:%@"
                    , bitOn(data1, 7)
                    , bitOn(data1, 6)
                    , bitOn(data1, 5)
                    , bitOn(data1, 2)
                    , bitOn(data1, 1)
            ];
        }
            break;

        case SENSOR_INDOOR_SIREN: {
            cmd = [NSString stringWithFormat:@"Heartbeat:%@ Tamper:%@ Low Voltage:%@ Close Siren:%@ Open Siren:%@"
                    , bitOn(data1, 7)
                    , bitOn(data1, 6)
                    , bitOn(data1, 5)
                    , bitOn(data1, 2)
                    , bitOn(data1, 1)
            ];
        }
            break;

        case SENSOR_OUTDOOR_SIREN: {
            cmd = [NSString stringWithFormat:@"Heartbeat:%@ Tamper:%@ Low Voltage:%@ Close Siren:%@ Open Siren:%@"
                    , bitOn(data1, 7)
                    , bitOn(data1, 6)
                    , bitOn(data1, 5)
                    , bitOn(data1, 2)
                    , bitOn(data1, 1)
            ];
        }
            break;
        case SENSOR_GSM: {
            NSString *gsm = @"GSM: No trigger";
            if (bitOnB(data1, 2)) {
                gsm = @"GSM: OFF";
            }
            if (bitOnB(data1, 1)) {
                gsm = @"GSM: Triggered";
            }

            cmd = [NSString stringWithFormat:@"Heartbeat:%@ Tamper:%@ Low Voltage:%@ %@"
                    , bitOn(data1, 7)
                    , bitOn(data1, 6)
                    , bitOn(data1, 5)
                    , bitOn(data1, 2)
                    , gsm
            ];
        }
            break;
        case SENSOR_CAMERA: {

            cmd = [NSString stringWithFormat:@"Heartbeat:%@ Tamper:%@ Low Voltage:%@ Recording:%@ Photo Taking:%@"
                    , bitOn(data1, 7)
                    , bitOn(data1, 6)
                    , bitOn(data1, 5)
                    , bitOn(data1, 2)
                    , bitOn(data1, 1)
            ];
        }
            break;
        case SENSOR_SOCKET: {
            cmd = [NSString stringWithFormat:@"Heartbeat:%@ Socket7:%@ Socket6:%@ Socket5:%@ Socket4:%@ Socket3:%@ Socket2:%@ Socket1:%@"
                    , bitOn(data1, 7)
                    , bitOn(data1, 6)
                    , bitOn(data1, 5)
                    , bitOn(data1, 4)
                    , bitOn(data1, 3)
                    , bitOn(data1, 2)
                    , bitOn(data1, 1)
                    , bitOn(data1, 6)
            ];
        }
            break;
        default:
            break;
    }

    return cmd;
}


- (void)exitDelay:(BOOL)exitDelay entryDelay:(BOOL)entryDelay alarmDelay:(BOOL)alarmDelay
        exitDelay:(int)exitDelayM exitDelay:(int)exitDelayS entryDelay:(int)entryDelayM
       entryDelay:(int)entryDelayS alarmDelay:(int)alarmDelayM alarmDelay:(int)alarmDelayS {
    DevicePoint *source = [DevicePoint getLastPanelPoint];
    DevicePoint *point = [source clonePoint];
    point.type = @3;
    point.entryDelayMinutes = [NSNumber numberWithInt:entryDelayM];
    point.entryDelaySecond = [NSNumber numberWithInt:entryDelayS];
    if (entryDelay) {
    } else {
        point.entryDelayMinutes = [self addSignBit:entryDelayM];
//        point.entryDelayMinutes = @0;
//        point.entryDelaySecond = @0;
    }
    point.exitDelayMinutes = [NSNumber numberWithInt:exitDelayM];
    point.exitDelaySecond = [NSNumber numberWithInt:exitDelayS];
    if (exitDelay) {
    } else {
        point.exitDelayMinutes = [self addSignBit:exitDelayM];
//        point.exitDelayMinutes = @0;
//        point.exitDelaySecond = @0;
    }
    point.alarmTimeMinutes = [NSNumber numberWithInt:alarmDelayM];
    point.alarmTimeSecond = [NSNumber numberWithInt:alarmDelayS];
    if (alarmDelay) {
    } else {
        point.alarmTimeMinutes = [self addSignBit:alarmDelayM];
//        point.alarmTimeMinutes = @0;
//        point.alarmTimeSecond = @0;
    }
    point.editMode = @1;

    NSString *res = [self getBackCloudPoint:point];
//    [self sendCommandStringUp:point res:res];
    [self sendCommandString:res];
//    AylaDatapoint *dataPoint = [AylaDatapoint new];
//    dataPoint.sValue = res;
//    AylaProperty *properties = [gblCurrentDevice.properties valueForKeyPath:@"control_cloud_to_panel"];
////    void (^cancelFx)() = [ut showLoading];
//    if (!self.debugMode) {
//
//        NSArray *tuple = nil;
////        void (^fx)(AylaResponse *, AylaDatapoint *);
////        if (fx == nil) {
//        void (^fx)(AylaResponse *, AylaDatapoint *) = ^(AylaResponse *response, AylaDatapoint *datapointCreated) {
////            cancelFx();
//            //check Changed?
//
//
//        };
////        }
////        if (fx1 == nil) {
//        void (^fx1)(AylaError *) = ^(AylaError *err) {
//        };
////        }
//        tuple = @[properties, dataPoint, point, fx, fx1];
//        @synchronized (self.waitingCommands) {
//            [self.waitingCommands addObject:tuple];
//        }
//
//
//        [self tryDispatch];
//
//    }
}

- (NSNumber *)addSignBit:(int)m {
    int signedBit = m + (1 << 7);
    return [NSNumber numberWithInt:signedBit];
}

- (void)changeSensorName:(DevicePoint *)point2 newName:(NSString *)name {
    DevicePoint *point = [point2 clonePoint];
    point.type = @3;
    point.sensorName = name;
    point.editMode = @1;

//    NSString *res = [self getBackCloudPoint2:point];
    NSString *res = [self getBackCloudPoint:point];

//    [self sendCommandStringUp:point res:res];
    [self sendCommandString:res];

}

//- (void)sendCommandStringUp:(DevicePoint *)point res:(NSString *)res {
//    AylaDatapoint *dataPoint = [AylaDatapoint new];
//    dataPoint.sValue = res;
//    AylaProperty *properties = [gblCurrentDevice.properties valueForKeyPath:@"control_cloud_to_panel"];
////    void (^cancelFx)() = [ut showLoading];
//    if (!self.debugMode) {
//
//        NSArray *tuple = nil;
////        void (^fx)(AylaResponse *, AylaDatapoint *);
////        if (fx == nil) {
//        void (^fx)(AylaResponse *, AylaDatapoint *) = ^(AylaResponse *response, AylaDatapoint *datapointCreated) {
////            cancelFx();
//        };
////        }
////        if (fx1 == nil) {
//        void (^fx1)(AylaError *) = ^(AylaError *err) {
//        };
////        }
//        tuple = @[properties, dataPoint, point, fx, fx1];
//        @synchronized (self.waitingCommands) {
//            [self.waitingCommands addObject:tuple];
//        }
//
//
//        [self tryDispatch];
//
//    }
//}

- (void)sendCommandString:(NSString *)res {


    AylaDatapoint *dataPoint = [AylaDatapoint new];
    dataPoint.sValue = res;
    AylaProperty *properties = [gblCurrentDevice.properties valueForKeyPath:@"control_cloud_to_panel"];
    if (properties != nil) {
        [self sendCommandNow:properties dataPoint:dataPoint];
    } else {
        [gblCurrentDevice getProperties:nil success:^(AylaResponse *response, NSArray *properties2) {
            AylaProperty *prop;
            for (AylaProperty *prop2 in properties2) {
                if ([prop2.name isEqualToString:@"control_cloud_to_panel"]) {
                    prop = prop2;
                }

            }
            if (prop != nil)
                [self sendCommandNow:prop dataPoint:dataPoint];
            else {
                TTDPRINT(@"cannot find device property");

            }

        }                       failure:^(AylaError *err) {
            TTDPRINT(@"%@", err);
        }];
    }
}

- (void)sendCommandNow:(AylaProperty *)properties dataPoint:(AylaDatapoint *)dataPoint {

//    void (^cancelFx)() = [ut showLoading];
    if (!self.debugMode) {

        NSArray *tuple = nil;
//        void (^fx)(AylaResponse *, AylaDatapoint *);
//        if (fx == nil) {
        void (^fx)(AylaResponse *, AylaDatapoint *) = ^(AylaResponse *response, AylaDatapoint *datapointCreated) {
//            cancelFx();
        };
//        }
//        if (fx1 == nil) {
        void (^fx1)(AylaError *) = ^(AylaError *err) {
        };
//        }
        tuple = @[properties, dataPoint, @[], fx, fx1];
        @synchronized (self.waitingCommands) {
            [self.waitingCommands addObject:tuple];
        }


        [self tryDispatch];

    }
}

- (NSString *)syncClock:(NSTimeZone *)zone {
    NSString *header = @"E";
    NSString *res;

//    NSString *length = [input substringWithRange:NSMakeRange(2, 4)];
    NSString *type = @"0";

    DevicePoint *source = [DevicePoint getLastPanelPoint];

    NSString *data1_3 = [self upfillHex:source.sensorId toLength:6];

    NSString *data4 = @"03";
//    int data6Int = 0;
    NSCalendar *o = [NSCalendar currentCalendar];
    [o setTimeZone:zone];


    NSDate *date = [NSDate dateWithTimeIntervalSinceNow:0];
    NSDateComponents *components = [o                           components:
            NSCalendarUnitDay | NSCalendarUnitMonth | NSCalendarUnitYear | NSCalendarUnitHour
                    | NSCalendarUnitWeekday
                    | NSCalendarUnitMinute | NSCalendarUnitSecond fromDate:date];

    NSInteger i = [components year] - 2000;
    NSString *data5 = [self upfillHexInt:i toLength:2];
    NSInteger number = [components month];
    NSString *data6 = [self upfillHexInt:number toLength:2];
    NSInteger day = [components day];
    NSString *data7 = [self upfillHexInt:day toLength:2];
    NSInteger hour = [components hour];
    NSString *data8 = [self upfillHexInt:hour toLength:2];
    NSInteger minute = [components minute];
    NSString *data9 = [self upfillHexInt:minute toLength:2];
    NSInteger second = [components second];
    NSString *data10 = [self upfillHexInt:second toLength:2];
    NSInteger weekday = [components weekday];

    int weekday2 = weekday - 1;
    //input 1 sunday
    //input 2 Monday
    //input 7 saturday

    //output sunday 7
    //output monday 1
    //output tuesday 2
    //output saturday 6
    if (weekday2 == 0) {
        weekday2 = 7;
    }
    NSString *data11 = [self upfillHexInt:weekday2 toLength:2];


//        NSString *data12 = [self upfillHex:input.alarmTimeMinutes toLength:2];
//        NSString *data13 = [self upfillHex:input.alarmTimeSecond toLength:2];
    NSString *data12_16 = @"0000000000";
    TTDPRINT(@"year %i", i);
    TTDPRINT(@"month %i", number);
    TTDPRINT(@"day %i", day);
    TTDPRINT(@"hour %i", hour);
    TTDPRINT(@"minute %i", minute);
    TTDPRINT(@"second %i", second);
    TTDPRINT(@"weekday %i", weekday);

//
    NSString *logCount = [self upfillHexInt:(0) toLength:2];
//    NSString *length = [self upfillHexInt:(32) toLength:2];
    NSString *length = [self upfillHexInt:(20) toLength:2];

    NSString *panelIdToData = [ut append:logCount, length, data1_3,
                                         data4,
                                         data5,
                                         data6,
                                         data7,
                                         data8,
                                         data9,
                                         data10,
                                         data11,
                                         data12_16, nil
    ];
    NSString *panelIdToData_ = [ut append_:logCount, length, data1_3,
                                           data4,
                                           data5,
                                           data6,
                                           data7,
                                           data8,
                                           data9,
                                           data10,
                                           data11,
                                           data12_16, nil
    ];

//    NSString *lengthAndData = [NSString stringWithFormat:@"%@%@",  panelIdToData];
//    NSString *checkSumInput = panelIdToData;

    TTDPRINT(@"Header %@", header);
    TTDPRINT(@"package type %@", type);;
    TTDPRINT(@"sensor/log count %@", logCount);
    TTDPRINT(@"length %@", length);
    TTDPRINT(@"data1_3 %@", data1_3);
    TTDPRINT(@"data4 %@", data4);
    TTDPRINT(@"data5 %@", data5);
    TTDPRINT(@"data6 %@", data6);
    TTDPRINT(@"data7 %@", data7);
    TTDPRINT(@"data8 %@", data8);
    TTDPRINT(@"data9 %@", data9);
    TTDPRINT(@"data10 %@", data10);
    TTDPRINT(@"data11 %@", data11);
    TTDPRINT(@"data12_16 %@", data12_16);


    NSString *CHECKSUM = getCheckSum();




    TTDPRINT(@"checksum %@", CHECKSUM);
    TTDPRINT(@"All_datas_ %@", panelIdToData_);
    res = [[ut append:header, type, panelIdToData, CHECKSUM, nil] uppercaseString];

    TTDPRINT(@"final data %@", res);

    [self sendCommandString:res];
    return res;
}

- (NSString *)syncHistory {
    NSString *header = @"E";
    NSString *res;
    NSString *type = @"0";

    DevicePoint *source = [DevicePoint getLastPanelPoint];

    NSString *data1_3 = [self upfillHex:source.sensorId toLength:6];

    NSString *data4 = @"04";
    //12
    NSString *data5_16 = @"000000000000000000000000";

    NSString *length = [self upfillHexInt:(20) toLength:2];
    NSString *sensorCount = @"00";
    NSString *panelIdToData = [ut append:sensorCount, length, data1_3,
                                         data4,
                                         data5_16, nil
    ];
    NSString *panelIdToData_ = [ut append_:sensorCount, length, data1_3,
                                           data4,
                                           data5_16, nil
    ];

    NSString *CHECKSUM = getCheckSum();


    TTDPRINT(@"Header %@", header);
    TTDPRINT(@"length %@", length);
    TTDPRINT(@"command type %@", type);;
    TTDPRINT(@"data1_3 %@", data1_3);
    TTDPRINT(@"data4 %@", data4);
    TTDPRINT(@"data5_16 %@", data5_16);
    TTDPRINT(@"checksum %@", CHECKSUM);
    TTDPRINT(@"All_datas_ %@", panelIdToData_);
    res = [[ut append:header, type, panelIdToData, CHECKSUM, nil] uppercaseString];

    TTDPRINT(@"final data %@", res);

    [self sendCommandString:res];
    return res;
}

- (NSString *)syncInfo {
    NSString *header = @"E";
    NSString *res;
    NSString *type = @"0";
    NSString *sensorCount = @"00";

    DevicePoint *source = [DevicePoint getLastPanelPoint];

    NSString *data1_3 = [self upfillHex:source.sensorId toLength:6];

    NSString *data4 = @"05";
    //12
    NSString *data5_16 = @"000000000000000000000000";

    NSString *length = [self upfillHexInt:(20) toLength:2];

    NSString *panelIdToData = [ut append:sensorCount, length, data1_3,
                                         data4,
                                         data5_16, nil
    ];
    NSString *panelIdToData_ = [ut append_:sensorCount, length, data1_3,
                                           data4,
                                           data5_16, nil
    ];

    NSString *CHECKSUM = getCheckSum();


    TTDPRINT(@"Header %@", header);
    TTDPRINT(@"length %@", length);
    TTDPRINT(@"command type %@", type);;
    TTDPRINT(@"data1_3 %@", data1_3);
    TTDPRINT(@"data4 %@", data4);
    TTDPRINT(@"data5_16 %@", data5_16);
    TTDPRINT(@"checksum %@", CHECKSUM);
    TTDPRINT(@"All_datas_ %@", panelIdToData_);
    res = [[ut append:header, type, panelIdToData, CHECKSUM, nil] uppercaseString];

    TTDPRINT(@"final data %@", res);

    [self sendCommandString:res];
    return res;
}


- (NSString *)changePassword:(NSString *)oldPw newPw:(NSString *)newPw {
    NSString *header = @"E";
    NSString *res;

//    NSString *length = [input substringWithRange:NSMakeRange(2, 4)];
    NSString *type = @"0";


    DevicePoint *source = [DevicePoint getLastPanelPoint];
//    DevicePoint *point = [source clonePoint];

    NSString *data1_3 = [self upfillHex:source.sensorId toLength:6];
    NSString *data4 = @"02";
    NSString *subStr = [oldPw substringWithRange:NSMakeRange(0, 1)];
    NSString *subStr2 = [oldPw substringWithRange:NSMakeRange(1, 1)];
    int totalIntValue = (subStr.intValue << 4) + subStr2.intValue;
    NSString *data5 = [self upfillHexInt:totalIntValue toLength:2];

    subStr = [oldPw substringWithRange:NSMakeRange(2, 1)];
    subStr2 = [oldPw substringWithRange:NSMakeRange(3, 1)];
    totalIntValue = (subStr.intValue << 4) + subStr2.intValue;
    NSString *data6 = [self upfillHexInt:totalIntValue toLength:2];


    subStr = [newPw substringWithRange:NSMakeRange(0, 1)];
    subStr2 = [newPw substringWithRange:NSMakeRange(1, 1)];
    totalIntValue = (subStr.intValue << 4) + subStr2.intValue;
    NSString *data7 = [self upfillHexInt:totalIntValue toLength:2];


    subStr = [newPw substringWithRange:NSMakeRange(2, 1)];
    subStr2 = [newPw substringWithRange:NSMakeRange(3, 1)];
    totalIntValue = (subStr.intValue << 4) + subStr2.intValue;
    NSString *data8 = [self upfillHexInt:totalIntValue toLength:2];

    //2*8=16
    NSString *data9_16 = @"0000000000000000";
//

    NSString *sensorCount = [self upfillHexInt:(00) toLength:2];
    NSString *length = [self upfillHexInt:(20) toLength:2];

    NSString *panelIdToData = [ut append:sensorCount, length, data1_3,
                                         data4,
                                         data5,
                                         data6,
                                         data7,
                                         data8,
                                         data9_16, nil
    ];

    NSString *panelIdToData_ = [ut append_:sensorCount, length, data1_3,
                                           data4,
                                           data5,
                                           data6,
                                           data7,
                                           data8,
                                           data9_16, nil
    ];
//    NSString *lengthAndData = [NSString stringWithFormat:@"%@%@",  panelIdToData];
//    NSString *checkSumInput = panelIdToData;
    NSString *CHECKSUM = getCheckSum();


    TTDPRINT(@"Header %@", header);
    TTDPRINT(@"sensorCount %@", sensorCount);
    TTDPRINT(@"length %@", length);
    TTDPRINT(@"command type %@", type);

    TTDPRINT(@"data1_3 %@", data1_3);
    TTDPRINT(@"data4 %@", data4);
    TTDPRINT(@"data5 %@", data5);
    TTDPRINT(@"data6 %@", data6);
    TTDPRINT(@"data7 %@", data7);
    TTDPRINT(@"data8 %@", data8);
    TTDPRINT(@"data9_16 %@", data9_16);
    TTDPRINT(@"checksum %@", CHECKSUM);
    TTDPRINT(@"All_datas_ %@", panelIdToData_);
    res = [[ut append:header, type, panelIdToData, CHECKSUM, nil] uppercaseString];

    TTDPRINT(@"final data %@", res);
    [self sendCommandString:res];
    return res;
}

- (NSString *)deleteSensor:(DevicePoint *)source {
    NSString *header = @"E";
    NSString *res;

    NSString *type = @"0";

    NSString *data1_3 = [self upfillHex:source.sensorId toLength:6];
    NSString *data4 = @"01";
    NSString *data5 = [self upfillHex:source.sensorType toLength:2];
    NSString *data6_16 = @"0000000000000000000000";


    NSString *sensorCount = [self upfillHexInt:(00) toLength:2];
    NSString *length = [self upfillHexInt:(20) toLength:2];

    NSString *panelIdToData = [ut append:sensorCount, length, data1_3, data4, data5, data6_16,
                                         nil
    ];
    NSString *panelIdToData_ = [ut append_:sensorCount, length, data1_3, data4, data5, data6_16,
                                           nil
    ];

//    NSString *lengthAndData = [NSString stringWithFormat:@"%@%@",  panelIdToData];
//    NSString *checkSumInput = panelIdToData;
    NSString *CHECKSUM = getCheckSum();


    TTDPRINT(@"Header %@", header);
    TTDPRINT(@"sensorCount %@", sensorCount);
    TTDPRINT(@"length %@", length);
    TTDPRINT(@"command type %@", type);
    TTDPRINT(@"data1_3 %@", data1_3);
    TTDPRINT(@"data4 %@", data4);
    TTDPRINT(@"data5 %@", data5);
    TTDPRINT(@"data6_16 %@", data6_16);
    TTDPRINT(@"checksum %@", CHECKSUM);
    TTDPRINT(@"All_datas_ %@", panelIdToData_);
    res = [[ut append:header, type, panelIdToData, CHECKSUM, nil] uppercaseString];

    TTDPRINT(@"final data %@", res);
    [self sendCommandString:res];
    return res;
}

- (NSString *)sendSensorPoint:(DevicePoint *)point {
//    point.type = @2;
    NSString *res = [self getBackCloudPoint:point];
    [self sendCommandString:res];

//    AylaDatapoint *dataPoint = [AylaDatapoint new];
//    dataPoint.sValue = res;
//    AylaProperty *properties = [gblCurrentDevice.properties valueForKeyPath:@"control_cloud_to_panel"];
////    void (^cancelFx)() = [ut showLoading];
//    if (!self.debugMode) {
//
//        NSArray *tuple = nil;
////        void (^fx)(AylaResponse *, AylaDatapoint *);
////        if (fx == nil) {
//        void (^fx)(AylaResponse *, AylaDatapoint *) = ^(AylaResponse *response, AylaDatapoint *datapointCreated) {
////            cancelFx();
//        };
////        }
////        if (fx1 == nil) {
//        void (^fx1)(AylaError *) = ^(AylaError *err) {
//        };
////        }
//        tuple = @[properties, dataPoint, point, fx, fx1];
//        @synchronized (self.waitingCommands) {
//            [self.waitingCommands addObject:tuple];
//        }
//        [self tryDispatch];
//
//
//    }
    return res;
}


static NSDictionary *propDict2;

- (void)readUploadStatus:(void (^)(DevicePoint *))pFunction {

    if (propDict2 == nil) {
        NSArray *props = [[NSArray alloc] initWithObjects:
                @"LogFrame_0",
                @"pTocFrame_0",
                @"control_panel_to_cloud",
                @"control_cloud_to_panel",

                nil];
//        NSArray *props = [[NSArray alloc] initWithObjects:
//                @"LogFrame_0",
//                @"pTocFrame_0"
//                        @"control_panel_to_cloud",
//                @"control_cloud_to_panel",
//                nil];
        NSDictionary *params = [[NSDictionary alloc] initWithObjectsAndKeys:props, @"names", nil];
        propDict2 = params;
    }


//    NSArray *props = [[NSArray alloc] initWithObjects:
//            @"control_panel_to_cloud",
//            nil];
//    NSDictionary *params = [[NSDictionary alloc] initWithObjectsAndKeys:props, @"names", nil];
//    NSDictionary *propDict = params;
    __block void (^pFunction1)(DevicePoint *) = pFunction;
    [gblCurrentDevice getProperties:propDict2 success:^(AylaResponse *response, NSArray *properties) {
        AylaProperty *prop;
        for (AylaProperty *prop2 in properties) {
            if ([prop2.name isEqualToString:@"control_panel_to_cloud"]) {
                prop = prop2;
            }

        }
        DevicePoint *point = [self readUploadDataPoint:prop.datapoint];

        pFunction1(point);

    }                       failure:^(AylaError *err) {
        TTDPRINT(@"%@", err);
    }];

}

- (DevicePoint *)readUploadDataPoint:(AylaDatapoint *)point {

    DevicePoint *oldPoint = [DevicePoint getLastUploadPoint];
    NSString *input2 = point.sValue;
    int counter = 0;
    if (empty(input2) || input2.length < 18) {
        [oldPoint MR_deleteEntity];
        [[NSManagedObjectContext MR_contextForCurrentThread] MR_saveToPersistentStoreAndWait];

        return nil;
    }

    NSData *data = [NSData dataFromBase64String:input2];
    NSString *input = [data hexadecimalString];
    NSString *headers = readText(6)
    NSString *data1_3 = readText(6);
    NSString *data4 = readText(2);
    NSString *data5 = readText(2);
    NSNumber *data4Int = [self stringToInt:data4];
    if (data4Int.intValue != 7) {
        [oldPoint MR_deleteEntity];
        [[NSManagedObjectContext MR_contextForCurrentThread] MR_saveToPersistentStoreAndWait];


        return nil;
    }


    NSNumber *data5Int = [self stringToInt:data5];

    NSString *data6 = readText(2);
    NSString *data7 = readText(2);
    NSString *data8 = readText(2);
    NSString *data9_10 = readText(4);
    NSNumber *blockNo = [self stringToInt:data9_10];
    NSNumber *versionNo = [self stringToInt:data8];
    bool validCommand = [self checkPanelCommandCheckSum:input];
    if (!validCommand) {
        [oldPoint MR_deleteEntity];
        [[NSManagedObjectContext MR_contextForCurrentThread] MR_saveToPersistentStoreAndWait];

//        [self tryUploadFirmWare:versionNo blockNo:blockNo];
        return @"CHECKSUM";
    }
//    NSString *data11 = readText(2);
//    NSString *data12 = readText(2);
//    NSString *data13 = readText(2);
//    NSString *data14 = readText(2);
//    NSString *data15 = readText(2);
//    NSString *data16 = readText(2);
    int sensorId = [self stringToInt:data1_3].intValue;
    if (oldPoint == nil) {


        oldPoint = [DevicePoint MR_createEntity];
    }
    if (oldPoint != nil && [oldPoint.raw isEqualToString:input]) {
        oldPoint.createdAt = [ut parseAylaTime:point.createdAt];
        oldPoint.createdAtStr = point.createdAt;
        [[NSManagedObjectContext MR_contextForCurrentThread] MR_saveToPersistentStoreAndWait];

        return oldPoint;
    }

    TTDPRINT(@"importing info point %@", input);

//    NSNumber *serialPoint = [self stringToInt:data1];
//    DevicePoint *dataFrame = [DevicePoint MR_createEntity];
    DevicePoint *dataFrame;
    if (oldPoint != nil) {
        dataFrame = oldPoint;
    } else {
        dataFrame = [DevicePoint MR_createEntity];;
    }

    dataFrame.raw = input;
    dataFrame.dsn = gblCurrentPanel.dsn;
    dataFrame.sensorId = [self stringToInt:data1_3];
    dataFrame.createdAt = [ut parseAylaTime:point.createdAt];
    dataFrame.createdAtStr = point.createdAt;
    dataFrame.uploadPoint = @1;
    dataFrame.uploadRequestNo = [self stringToInt:data9_10];
    dataFrame.uploadRequestSuccess = @0;
    dataFrame.uploadRequestContinue = @0;
    dataFrame.uploadRequestCrcFailed = @0;
    dataFrame.uploadRequestFailedUnknow = @0;
    switch ([self stringToInt:data5].intValue) {
        case 0:
            dataFrame.uploadRequestFailedUnknow = @1;
            break;
        case 1:
            dataFrame.uploadRequestContinue = @1;
            break;
        case 2:
            dataFrame.uploadRequestSuccess = @1;
            break;
        case 3:
            dataFrame.uploadRequestCrcFailed = @1;
            break;
        default:
            dataFrame.uploadRequestFailedUnknow = @1;
            break;
    }

    bool i = [self stringToInt:data5].intValue == 2;
    dataFrame.uploadRequestSuccess = [NSNumber numberWithBool:i];
    dataFrame.uploadRequestSuccess = [NSNumber numberWithBool:i];

    dataFrame.type = @0;
    dataFrame.version = [self stringToInt:data8];
    [[NSManagedObjectContext MR_contextForCurrentThread] MR_saveToPersistentStoreAndWait];

    return dataFrame;
}

- (bool)checkPanelCommandCheckSum:(NSString *)input {
    NSString *expectSum = [self getHexCheckSum:[input substringWithRange:NSMakeRange(0, input.length - 2)]];
    NSString *getSum = [input substringWithRange:NSMakeRange(input.length - 2, 2)];
    BOOL b = [expectSum isEqualToString:getSum];
    TTDPRINT(@"expect sum %@ gettedSum %@", expectSum, getSum);
    self.expectSum = expectSum;
    self.getSum = getSum;
    return b;
}

- (void)syncPanelClock:(Panel *)panel {
    NSTimeZone *time = [NSTimeZone systemTimeZone];

    if (panel.timezone != nil) {
        time = [TimeZonePicker getTimeZoneFromString:panel.timezone];
    }
    if (time == nil) {
        time = [NSTimeZone systemTimeZone];
    }
    [self syncClock:time];
}

- (bool)isAfter:(NSString *)at toTIme:(NSString *)ime {
    NSDate *day1 = [ut parseAylaTime:at];
    NSDate *day2 = [ut parseAylaTime:ime];
    if ([day1 timeIntervalSinceDate:day2] > 0) {
        return true;
    }
    return false;
}

//static NSArray*infoCache;
//static NSArray*infoCache;
- (NSMutableArray *)importProperties:(NSArray *)properties {
    NSMutableDictionary *dict = [[NSMutableDictionary alloc] init];

    for (AylaProperty *aylaProperty in properties) {
        if (aylaProperty.displayName != nil)
            [dict setValue:aylaProperty forKey:aylaProperty.displayName];
    }
    NSString *infoProps = @"";
    NSString *historyProps = @"";
    NSString *infoTemplate = @"pTocFrame_%i";
    NSString *historyTemplate = @"LogFrame_%i";
//    int sensorCount = -1;
    NSMutableArray *res = [[NSMutableArray alloc] init];
//    NSMutableArray *historyLogs = [[NSMutableArray alloc] init];

    NSArray *latestInfoPoints = [DevicePoint getAllInfoPoints];
    NSMutableDictionary *dict2 = [[NSMutableDictionary alloc] init];
    for (DevicePoint *point  in latestInfoPoints) {
        [dict2 setObject:point forKey:[point gotComboId]];

    }
    NSArray *historyPoints = [DevicePoint get100HistoryPoints];
    NSMutableDictionary *dict3 = [[NSMutableDictionary alloc] init];
    for (DevicePoint *point  in historyPoints) {
        [dict3 setObject:point forKey:[point raw]];

    }
    NSNumber *sensorCount;
    bool validHistory = true;
    for (int i = 0; i < 10; i++) {
        NSString *infoProp = [NSString stringWithFormat:infoTemplate, i];
        NSString *historyProp = [NSString stringWithFormat:historyTemplate, i];

        AylaProperty *infoPropPoint = [dict objectForKey:infoProp];
        AylaProperty *historyPropPoint = [dict objectForKey:historyProp];
//        NSString*infoStr=infoPropPoint.datapoint.sValue;
//        NSString*historyStr=historyPropPoint.datapoint.sValue;
        NSArray *framesAndLogCount = [self parsePoint:infoPropPoint.datapoint withInfo:dict2 historyInfo:NULL ];
        NSArray *frames = [framesAndLogCount objectAtIndex:0];
        NSNumber *count = [framesAndLogCount objectAtIndex:1];


        if (i == 0) {
            Setting *setting = [Setting MR_findFirst];
            setting.lastSensorCount = count;
            sensorCount = count;
        }
//        NSArray *history = [self parsePoint:historyPropPoint.datapoint];
        if (validHistory && historyPropPoint != nil&& dict3 != nil) {
            if (![self validPoint:historyPropPoint.value])
                validHistory = false;
            else
                [self performSelectorInBackground:@selector(parseHistoryPoint:) withObject:@[historyPropPoint.datapoint, dict3]];
        } else {
            TTDPRINT(@"historyPropPoint %@ dict3 %@", historyPropPoint, dict3);
        }
        [res addObjectsFromArray:frames];
//        if (frames.count > 0)
//            sensorCount += frames.count;
//        if (history.count > 0)
//            [historyLogs addObjectsFromArray:history];


    }
    if (res.count > 0)
        res = [[res subarrayWithRange:NSMakeRange(0, MIN(sensorCount.intValue + 1, res.count))] mutableCopy];

//    [setting save];
    [[NSManagedObjectContext MR_contextForCurrentThread] MR_saveToPersistentStoreAndWait];
    return res;
}

- (NSArray *)getSensorHistory:(NSMutableDictionary *)properties prop:(DevicePoint *)point {
    [self importProperties:properties.allValues];
//    int sensorType = point.sensorType.intValue;


    return [DevicePoint getSensorHistorys:point.sensorId sensorType:point.sensorType];
}

- (void)uploadFirmwareBlock:(NSString *)str offset:(int)offset versionNo:(NSNumber *)versionNo totalSize:(int)size {
    NSString *header = @"E";
    NSString *res;

    NSString *type = @"0";
    NSString *sensorCount = @"00";
    DevicePoint *source = [DevicePoint getLastPanelPoint];
    NSString *data1_3 = [self upfillHex:source.sensorId toLength:6];
    NSString *data4 = @"07";
//    NSString *data5_7 = @"000001";
    NSString *data5_7 = [self upfillHexInt:(size) toLength:6];

    NSString *data8 = [self upfillHex:(versionNo) toLength:2];
    NSString *data9_10 = [self upfillHexInt:(offset) toLength:4];
    NSString *dataN = str;


    NSString *lengthStr = [ut append:header, type, sensorCount, data1_3, data4, data5_7, data8, data9_10, dataN,
                                     nil                                      ];
    int lengthInt = lengthStr.length / 2 + 1 + 1;
    NSString *length = [self upfillHexInt:(lengthInt) toLength:2];

    NSString *panelIdToData = [ut append:sensorCount, length, data1_3, data4, data5_7, data8, data9_10, dataN,
                                         nil
    ];
    NSString *panelIdToData_ = [ut append:sensorCount, length, data1_3, data4, data5_7, data8, data9_10, dataN,
                                          nil
    ];

//    NSString *lengthAndData = [NSString stringWithFormat:@"%@%@",  panelIdToData];
//    NSString *checkSumInput = panelIdToData;
    NSString *CHECKSUM = getCheckSum();


    TTDPRINT(@"Header %@", header);
    TTDPRINT(@"sensorCount %@", sensorCount);
    TTDPRINT(@"length %@", length);
    TTDPRINT(@"command type %@", type);
    TTDPRINT(@"data1_3 %@", data1_3);
    TTDPRINT(@"data4 %@", data4);
    TTDPRINT(@"data5_7 %@", data5_7);
    TTDPRINT(@"data8 %@", data8);
    TTDPRINT(@"data9 %@", data9_10);
    TTDPRINT(@"dataN %@", dataN);
    TTDPRINT(@"checksum %@", CHECKSUM);
    TTDPRINT(@"All_datas_ %@", panelIdToData_);
    res = [[ut append:header, type, panelIdToData, CHECKSUM, nil] uppercaseString];

    TTDPRINT(@"final data %@", res);
    [self sendCommandString:res];
}


- (void)initFirmwareUpload:(NSNumber *)versionNo block0:(NSString *)block0 blockCount:(int)count {
    NSString *header = @"E";
    NSString *res;

    NSString *type = @"0";
    NSString *sensorCount = @"00";
    DevicePoint *source = [DevicePoint getLastPanelPoint];
    NSString *data1_3 = [self upfillHex:source.sensorId toLength:6];
    NSString *data4 = @"07";
    NSString *data5_7 = [self upfillHexInt:(count) toLength:6];
    NSString *data8 = [self upfillHex:(versionNo) toLength:2];
    NSString *data9_10 = [self upfillHexInt:(0) toLength:4];
    NSString *dataN = block0;


    NSString *lengthStr = [ut append:header, type, sensorCount, data1_3, data4, data5_7, data8, data9_10, dataN,
                                     nil                                      ];
    int lengthInt = lengthStr.length / 2 + 1 + 1;
    NSString *length = [self upfillHexInt:(lengthInt) toLength:2];


    NSString *panelIdToData = [ut append:sensorCount, length, data1_3, data4, data5_7, data8, data9_10, dataN,
                                         nil
    ];
    NSString *panelIdToData_ = [ut append:sensorCount, length, data1_3, data4, data5_7, data8, data9_10, dataN,
                                          nil
    ];

//    NSString *lengthAndData = [NSString stringWithFormat:@"%@%@",  panelIdToData];
//    NSString *checkSumInput = panelIdToData;
    NSString *CHECKSUM = getCheckSum();


    TTDPRINT(@"Header %@", header);
    TTDPRINT(@"sensorCount %@", sensorCount);
    TTDPRINT(@"length %@", length);
    TTDPRINT(@"command type %@", type);
    TTDPRINT(@"data1_3 %@", data1_3);
    TTDPRINT(@"data4 %@", data4);
    TTDPRINT(@"data5_7 %@", data5_7);
    TTDPRINT(@"data8 %@", data8);
    TTDPRINT(@"data9 %@", data9_10);
    TTDPRINT(@"dataN %@", dataN);
    TTDPRINT(@"checksum %@", CHECKSUM);
    TTDPRINT(@"All_datas_ %@", panelIdToData_);
    res = [[ut append:header, type, panelIdToData, CHECKSUM, nil] uppercaseString];

    TTDPRINT(@"final data %@", res);
    [self sendCommandString:res];
}


- (NSArray *)getSumResult {
    if (self.getSum != nil&& self.expectSum != nil)
        return @[self.expectSum, self.getSum];
    return @[@"NoResult", @"NoResult"];
}
@end

NSNumber *isBit(int anInt, int i) {
    return [NSNumber numberWithInt:(anInt & (1 << i)) > 0];
}

//BOOL bitOnB(int i, int i1);
//BOOL bitOnB(int i, int i1) {
//    return (bool) (i | (int)pow(2, i1));
//}

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

