package com.mace.maceAlert;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: billy
 * Date: 2014/6/3
 * Time: 下午 01:59
 */
public class TimeZoneReference {


    //Done Weexcel: please create a timeZone picker like in ios for the edit location screen

    /**
     * self.namesDict=@{  @"(UTC -12:00) Eniwetok, Kwajalein":@-12,
     @"(UTC -11:00) Midway Island, Samoa":@-11,
     @"(UTC -10:00) Hawaii":@-10,
     @"(UTC -9:00) Alaska":@-9,
     @"(UTC -8:00) Pacific Time (US &amp; Canada)":@-8,
     @"(UTC -7:00) Mountain Time (US &amp; Canada)":@-7,
     @"(UTC -6:00) Central Time (US &amp; Canada), Mexico City":@-6,
     @"(UTC -5:00) Eastern Time (US &amp; Canada), Bogota, Lima":@-5,
     @"(UTC -4:00) Atlantic Time (Canada), Caracas, La Paz":@-4,
     @"(UTC -3:30) Newfoundland":@-3.5,
     @"(UTC -3:00) Brazil, Buenos Aires, Georgetown":@-3,
     @"(UTC -2:00) Mid-Atlantic":@-2,
     @"(UTC -1:00 hour) Azores, Cape Verde Islands":@-1,
     @"(UTC) Western Europe Time, London, Lisbon, Casablanca":@0,
     @"(UTC +1:00 hour) Brussels, Copenhagen, Madrid, Paris":@1,
     @"(UTC +2:00) Kaliningrad, South Africa":@2,
     @"(UTC +3:00) Baghdad, Riyadh, Moscow, St. Petersburg":@3,
     @"(UTC +3:30) Tehran":@3.5,
     @"(UTC +4:00) Abu Dhabi, Muscat, Baku, Tbilisi":@4,
     @"(UTC +4:30) Kabul":@4.5,
     @"(UTC +5:00) Ekaterinburg, Islamabad, Karachi, Tashkent":@5,
     @"(UTC +5:30) Bombay, Calcutta, Madras, New Delhi":@5.5,
     @"(UTC +5:45) Kathmandu":@5.75,
     @"(UTC +6:00) Almaty, Dhaka, Colombo":@6,
     @"(UTC +7:00) Bangkok, Hanoi, Jakarta":@7,
     @"(UTC +8:00) Beijing, Perth, Singapore, Hong Kong":@8,
     @"(UTC +9:00) Tokyo, Seoul, Osaka, Sapporo, Yakutsk":@9,
     @"(UTC +9:30) Adelaide, Darwin":@9.5,
     @"(UTC +10:00) Eastern Australia, Guam, Vladivostok":@10,
     @"(UTC +11:00) Magadan, Solomon Islands, New Caledonia":@11,
     @"(UTC +12:00) Auckland, Wellington, Fiji, Kamchatka":@12
     };

     self.names=@[  @"(UTC -12:00) Eniwetok, Kwajalein",
     @"(UTC -11:00) Midway Island, Samoa",
     @"(UTC -10:00) Hawaii",
     @"(UTC -9:00) Alaska",
     @"(UTC -8:00) Pacific Time (US &amp; Canada)",
     @"(UTC -7:00) Mountain Time (US &amp; Canada)",
     @"(UTC -6:00) Central Time (US &amp; Canada), Mexico City",
     @"(UTC -5:00) Eastern Time (US &amp; Canada), Bogota, Lima",
     @"(UTC -4:00) Atlantic Time (Canada), Caracas, La Paz",
     @"(UTC -3:30) Newfoundland",
     @"(UTC -3:00) Brazil, Buenos Aires, Georgetown",
     @"(UTC -2:00) Mid-Atlantic",
     @"(UTC -1:00 hour) Azores, Cape Verde Islands",
     @"(UTC) Western Europe Time, London, Lisbon, Casablanca",
     @"(UTC +1:00 hour) Brussels, Copenhagen, Madrid, Paris",
     @"(UTC +2:00) Kaliningrad, South Africa",
     @"(UTC +3:00) Baghdad, Riyadh, Moscow, St. Petersburg",
     @"(UTC +3:30) Tehran",
     @"(UTC +4:00) Abu Dhabi, Muscat, Baku, Tbilisi",
     @"(UTC +4:30) Kabul",
     @"(UTC +5:00) Ekaterinburg, Islamabad, Karachi, Tashkent",
     @"(UTC +5:30) Bombay, Calcutta, Madras, New Delhi",
     @"(UTC +5:45) Kathmandu",
     @"(UTC +6:00) Almaty, Dhaka, Colombo",
     @"(UTC +7:00) Bangkok, Hanoi, Jakarta",
     @"(UTC +8:00) Beijing, Perth, Singapore, Hong Kong",
     @"(UTC +9:00) Tokyo, Seoul, Osaka, Sapporo, Yakutsk",
     @"(UTC +9:30) Adelaide, Darwin",
     @"(UTC +10:00) Eastern Australia, Guam, Vladivostok",
     @"(UTC +11:00) Magadan, Solomon Islands, New Caledonia",
     @"(UTC +12:00) Auckland, Wellington, Fiji, Kamchatka"
     ];
     }


     */
    /**
     *
//     NSDictionary *namesDict = @{@"(UTC -12:00) Eniwetok, Kwajalein",-12,
//            @"(UTC -11:00) Midway Island, Samoa",-11,
//            @"(UTC -10:00) Hawaii",-10,
//            @"(UTC -9:00) Alaska",-9,
//            @"(UTC -8:00) Pacific Time (US &amp; Canada)",-8,
//            @"(UTC -7:00) Mountain Time (US &amp; Canada)",-7,
//            @"(UTC -6:00) Central Time (US &amp; Canada), Mexico City",-6,
//            @"(UTC -5:00) Eastern Time (US &amp; Canada), Bogota, Lima",-5,
//            @"(UTC -4:00) Atlantic Time (Canada), Caracas, La Paz",-4,
//            @"(UTC -3:30) Newfoundland",-3.5,
//            @"(UTC -3:00) Brazil, Buenos Aires, Georgetown",-3,
//            @"(UTC -2:00) Mid-Atlantic",-2,
//            @"(UTC -1:00 hour) Azores, Cape Verde Islands",-1,

//            @"(UTC) Western Europe Time, London, Lisbon, Casablanca",0,

//            @"(UTC +1:00 hour) Brussels, Copenhagen, Madrid, Paris",1,
//            @"(UTC +2:00) Kaliningrad, South Africa",2,
//            @"(UTC +3:00) Baghdad, Riyadh, Moscow, St. Petersburg",3,
//            @"(UTC +3:30) Tehran",3.5,

//            @"(UTC +4:00) Abu Dhabi, Muscat, Baku, Tbilisi",4,
//            @"(UTC +4:30) Kabul",4.5,
//            @"(UTC +5:00) Ekaterinburg, Islamabad, Karachi, Tashkent",5,
//            @"(UTC +5:30) Bombay, Calcutta, Madras, New Delhi",5.5,
//            @"(UTC +5:45) Kathmandu",5.75,
//            @"(UTC +6:00) Almaty, Dhaka, Colombo",6,

//            @"(UTC +7:00) Bangkok, Hanoi, Jakarta",7,
//            @"(UTC +8:00) Beijing, Perth, Singapore, Hong Kong",8,
//            @"(UTC +9:00) Tokyo, Seoul, Osaka, Sapporo, Yakutsk",9,
//            @"(UTC +9:30) Adelaide, Darwin",9.5,
//            @"(UTC +10:00) Eastern Australia, Guam, Vladivostok",10,
//            @"(UTC +11:00) Magadan, Solomon Islands, New Caledonia",11,
//            @"(UTC +12:00) Auckland, Wellington, Fiji, Kamchatka",12
    };
     */
       public class Zones
    {
        private Zones(String countryname, double code) {
            this.countryname = countryname;
            this.code = code;
        }

        public double getCode() {
            return code;
        }

        public void setCode(double code) {
            this.code = code;
        }

        public String getCountryname() {
            return countryname;
        }

        public void setCountryname(String countryname) {
            this.countryname = countryname;
        }

        private  String countryname;
        private  double code;

    }

    public ArrayList<Zones> getList_zones() {
        return list_zones;
    }

    public void setList_zones(ArrayList<Zones> list_zones) {
        this.list_zones = list_zones;
    }

    private ArrayList<Zones> list_zones;

    TimeZoneReference()
    {
        list_zones =new ArrayList<Zones>();
        list_zones.add(new Zones("(UTC -12:00) Eniwetok, Kwajalein" ,-12));
        list_zones.add(new Zones("(UTC -11:00) Midway Island, Samoa",-11));
        list_zones.add(new Zones("(UTC -10:00) Hawaii",-10));
        list_zones.add(new Zones("(UTC -9:00) Alaska",-9));
        list_zones.add(new Zones("(UTC -8:00) Pacific Time (US &amp; Canada)",-8));
        list_zones.add(new Zones("(UTC -7:00) Mountain Time (US &amp; Canada)",-7));
        list_zones.add(new Zones("(UTC -6:00) Central Time (US &amp; Canada), Mexico City",-6));
        list_zones.add(new Zones("(UTC -5:00) Eastern Time (US &amp; Canada), Bogota, Lima",-5));
        list_zones.add(new Zones("(UTC -4:00) Atlantic Time (Canada), Caracas, La Paz",-4));
        list_zones.add(new Zones("(UTC -3:30) Newfoundland",-3.5));
        list_zones.add(new Zones("(UTC -3:00) Brazil, Buenos Aires, Georgetown",-3));
        list_zones.add(new Zones("(UTC -2:00) Mid-Atlantic",-2));
        list_zones.add(new Zones("(UTC -1:00 hour) Azores, Cape Verde Islands",-1));
        list_zones.add(new Zones("(UTC) Western Europe Time, London, Lisbon, Casablanca",0));
        list_zones.add(new Zones("(UTC +1:00 hour) Brussels, Copenhagen, Madrid, Paris",1));
        list_zones.add(new Zones("(UTC +2:00) Kaliningrad, South Africa",2));
        list_zones.add(new Zones("(UTC +3:00) Baghdad, Riyadh, Moscow, St. Petersburg",3));
        list_zones.add(new Zones("(UTC +3:30) Tehran",3.5));
        list_zones.add(new Zones("(UTC +4:00) Abu Dhabi, Muscat, Baku, Tbilisi",4));
        list_zones.add(new Zones("(UTC +4:30) Kabul",4.5));
        list_zones.add(new Zones("(UTC +5:00) Ekaterinburg, Islamabad, Karachi, Tashkent",5));
        list_zones.add(new Zones("(UTC +5:30) Bombay, Calcutta, Madras, New Delhi",5.5));
        list_zones.add(new Zones("(UTC +5:45) Kathmandu",5.75));
        list_zones.add(new Zones("(UTC +6:00) Almaty, Dhaka, Colombo",6));
        list_zones.add(new Zones("(UTC +7:00) Bangkok, Hanoi, Jakarta",7));
        list_zones.add(new Zones("(UTC +8:00) Beijing, Perth, Singapore, Hong Kong",8));
        list_zones.add(new Zones("(UTC +9:00) Tokyo, Seoul, Osaka, Sapporo, Yakutsk",9));
        list_zones.add(new Zones("(UTC +10:00) Eastern Australia, Guam, Vladivostok",10));
        list_zones.add(new Zones("(UTC +11:00) Magadan, Solomon Islands, New Caledonia",11));
        list_zones.add(new Zones("(UTC +12:00) Auckland, Wellington, Fiji, Kamchatka",12));

    }



}
