package com.mace.util;

/**
 * Created by A on 6/7/14.
 */
public class CountryCOde {

   private String countryname;
   private String code;

    public CountryCOde(String countryname, String code) {
        this.countryname = countryname;
        this.code = code;
    }


    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
