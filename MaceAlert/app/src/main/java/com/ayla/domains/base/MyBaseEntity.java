package com.ayla.domains.base;

import android.content.Context;

import com.orm.StringUtil;
import com.orm.SugarDb;
import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: billy
 * Date: 2014/6/19
 * Time: 下午 12:45
 */
public class MyBaseEntity extends SugarRecord{

    public MyBaseEntity(Context context) {
        super(context);
    }

    /**
     */

//    public void  save(){
//    }

    /**
     *
     * @param tableclass your tableclass name
     * @param attribute the exact field name in your table class
     * @param value     where attribute is value_
     * @return
     */
    public static ArrayList findByAttribute(Class tableclass,String attribute, String value)
    {
        ArrayList list= (ArrayList)SugarRecord.find(tableclass, StringUtil.toSQLName(attribute)+" = ?",value);
        return list;
    }



//    public void setValueByKey(String key, Object value) ;

}
