package com.mace.maceAlert;

import com.mace.util.CountryCOde;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: billy
 * Date: 2014/6/3
 * Time: 上午 12:51
 */
public class CountryCodeReference {

    //done Weexcel: please create a country picker like in ios for the registration screen
    //DOne Weexcel: please create a passcode picker, passcode is limit to 4 character , digital only input , please review ios version


    public ArrayList<CountryCOde> getList_cntrycode() {
        return list_cntrycode;
    }

    public void setList_cntrycode(ArrayList<CountryCOde> list_cntrycode) {
        this.list_cntrycode = list_cntrycode;
    }

    /**
     * I used follow country code in ios
     *    self.countries = [NSArray arrayWithObjects:
     M2(@"Argentina", @""),
     M2(
     @"Australia", @""),
     M2(
     @"Austria", @""),
     M2(
     @"Belgium", @""),
     M2(
     @"Brazil", @""),
     M2(
     @"Canada", @""),
     M2(
     @"Chile", @""),
     M2(
     @"China", @""),
     M2(
     @"Colombia", @""),
     M2(
     @"Costa Rica", @""),
     M2(
     @"Cuba", @""),
     M2(
     @"Czech Republic", @""),
     M2(
     @"Denmark", @""),
     M2(
     @"Dominica", @""),
     M2(
     @"Dominican Republic", @""),
     M2(
     @"Ecuador", @""),
     M2(
     @"Egypt", @""),
     M2(
     @"El Salvador", @""),
     M2(
     @"Finland", @""),
     M2(
     @"France", @""),
     M2(
     @"Germany", @""),
     M2(
     @"Greece", @""),
     M2(
     @"Greenland", @""),
     M2(
     @"Guam", @""),
     M2(
     @"Guatemala", @""),
     M2(
     @"Haiti", @""),
     M2(
     @"Holy See (Vatican City)", @""),
     M2(
     @"Honduras", @""),
     M2(
     @"Hong Kong SAR China", @""),
     M2(
     @"Hungary", @""),
     M2(
     @"Iceland", @""),
     M2(
     @"Indonesia", @""),
     M2(
     @"Ireland", @""),
     M2(
     @"Italy", @""),
     M2(
     @"Jamaica", @""),
     M2(
     @"Japan", @""),
     M2(
     @"Luxembourg", @""),
     M2(
     @"Malaysia", @""),
     M2(
     @"Marshall Islands", @""),
     M2(
     @"Mexico", @""),
     M2(
     @"Morocco", @""),
     M2(
     @"Netherlands", @""),
     M2(
     @"New Zealand", @""),
     M2(
     @"Norway", @""),
     M2(
     @"Panama", @""),
     M2(
     @"Paraguay", @""),
     M2(
     @"Peru", @""),
     M2(
     @"Philippines", @""),
     M2(
     @"Poland", @""),
     M2(@"Portugal", @""),
     M2(
     @"Puerto Rico", @""),
     M2(   @"Romania", @""),
     M2(
     @"Russia", @""),
     M2(
     @"Singapore", @""),
     M2(
     @"South Africa", @""),
     M2(
     @"Spain", @""),
     M2(
     @"Sweden", @""),
     M2(
     @"Switzerland", @""),
     M2(
     @"Thailand", @""),
     M2(
     @"Turkey", @""),
     M2(
     @"United Arab Emirates", @""),
     M2(
     @"United Kingdom", @""),
     M2(
     @"United States", @""),
     M2(
     @"Venezuela", @""), nil];
     *     self.countryCode = [NSArray arrayWithObjects:
     @"+54",
     @"+61",
     @"+43",
     @"+32",
     @"+55",
     @"+1",
     @"+56",
     @"+86",
     @"+57",
     @"+506",
     @"+53",
     @"+420",
     @"+45",
     @"+1767",
     @"+1809",
     @"+593",
     @"+20",
     @"+503",
     @"+358",
     @"+33",
     @"+49",
     @"+30",
     @"+299",
     @"+1671",
     @"+502",
     @"+509",
     @"+39",
     @"+504",
     @"+852",
     @"+36",
     @"+354",
     @"+62",
     @"+353",
     @"+39",
     @"+1876",
     @"+81",
     @"+352",
     @"+60",
     @"+692",
     @"+52",
     @"+212",
     @"+31",
     @"+64",
     @"+47",
     @"+507",
     @"+595",
     @"+51",
     @"+63",
     @"+48",
     @"+351",
     @"+1",
     @"+40",
     @"+7",
     @"+65",
     @"+27",
     @"+34",
     @"+46",
     @"+41",
     @"+66",
     @"+90",
     @"+971",
     @"+44",
     @"+1",
     @"+58", nil];
     */

    private ArrayList<CountryCOde> list_cntrycode;

    public CountryCodeReference() {
        list_cntrycode=new ArrayList<CountryCOde>();
        list_cntrycode.add(new CountryCOde("Argentina", "+54"));
        list_cntrycode.add(new CountryCOde("Australia", "+61"));
        list_cntrycode.add(new CountryCOde("Austria", "+43"));
        list_cntrycode.add(new CountryCOde("Belgium", "+32"));
        list_cntrycode.add(new CountryCOde("Canada", "+1"));
        list_cntrycode.add(new CountryCOde("Chile", "+56"));
        list_cntrycode.add(new CountryCOde("China", "+86"));
        list_cntrycode.add(new CountryCOde("Colombia", "+57"));
        list_cntrycode.add(new CountryCOde("Costa Rica", "+506"));
        list_cntrycode.add(new CountryCOde("Cuba", "+53"));
        list_cntrycode.add(new CountryCOde("Czech Republic", "+420"));
        list_cntrycode.add(new CountryCOde("Denmark", "+45"));
        list_cntrycode.add(new CountryCOde("Dominica", "+1"));
        list_cntrycode.add(new CountryCOde("Dominican Republic", "+1"));
        list_cntrycode.add(new CountryCOde("Ecuador", "+593"));
        list_cntrycode.add(new CountryCOde("Egypt", "+20"));
        list_cntrycode.add(new CountryCOde("El Salvador", "+503"));
        list_cntrycode.add(new CountryCOde("Finland", "+358"));
        list_cntrycode.add(new CountryCOde("France", "+33"));
        list_cntrycode.add(new CountryCOde("Germany", "+49"));
        list_cntrycode.add(new CountryCOde("Greece", "+30"));
        list_cntrycode.add(new CountryCOde("Greenland", "+299"));
        list_cntrycode.add(new CountryCOde("Guam", "+1"));
        list_cntrycode.add(new CountryCOde("Guatemala", "+502"));
        list_cntrycode.add(new CountryCOde("Haiti", "+509"));
        list_cntrycode.add(new CountryCOde("Holy See (Vatican City)", "+379"));
        list_cntrycode.add(new CountryCOde("Honduras", "+504"));
        list_cntrycode.add(new CountryCOde("Hong Kong SAR China", "+852"));
        list_cntrycode.add(new CountryCOde("Hungary", "+36"));
        list_cntrycode.add(new CountryCOde("Iceland", "+354"));
        list_cntrycode.add(new CountryCOde("Indonesia", "+62"));
        list_cntrycode.add(new CountryCOde("Ireland", "+353"));
        list_cntrycode.add(new CountryCOde("Italy", "+39"));
        list_cntrycode.add(new CountryCOde("Jamaica", "+1"));
        list_cntrycode.add(new CountryCOde("Japan", "+81"));
        list_cntrycode.add(new CountryCOde("Luxembourg", "+352"));
        list_cntrycode.add(new CountryCOde("Malaysia", "+60"));
        list_cntrycode.add(new CountryCOde("Marshall Islands", "+692"));
        list_cntrycode.add(new CountryCOde("Mexico", "+52"));
        list_cntrycode.add(new CountryCOde("Morocco", "+212"));
        list_cntrycode.add(new CountryCOde("Netherlands", "+31"));
        list_cntrycode.add(new CountryCOde("New Zealand", "+64"));
        list_cntrycode.add(new CountryCOde("Norway", "+47"));
        list_cntrycode.add(new CountryCOde("Panama", "+507"));
        list_cntrycode.add(new CountryCOde("Paraguay", "+595"));
        list_cntrycode.add(new CountryCOde("Peru", "+51"));
        list_cntrycode.add(new CountryCOde("Philippines", "+63"));
        list_cntrycode.add(new CountryCOde("Poland", "+48"));
        list_cntrycode.add(new CountryCOde("Portugal", "+351"));
        list_cntrycode.add(new CountryCOde("Puerto Rico", "+1"));
        list_cntrycode.add(new CountryCOde("Romania", "+40"));
        list_cntrycode.add(new CountryCOde("Russia", "+7"));
        list_cntrycode.add(new CountryCOde("Singapore", "+65"));
        list_cntrycode.add(new CountryCOde("South Africa", "+27"));
        list_cntrycode.add(new CountryCOde("Spain", "+34"));
        list_cntrycode.add(new CountryCOde("Sweden", "+46"));
        list_cntrycode.add(new CountryCOde("Switzerland", "+41"));
        list_cntrycode.add(new CountryCOde("Thailand", "+66"));
        list_cntrycode.add(new CountryCOde("Turkey", "+90"));
        list_cntrycode.add(new CountryCOde("United Arab Emirates", "+971"));
        list_cntrycode.add(new CountryCOde("United Kingdom", "+44"));
        list_cntrycode.add(new CountryCOde("United States", "+1"));
        list_cntrycode.add(new CountryCOde("Venezuela", "+58"));

    }


}
