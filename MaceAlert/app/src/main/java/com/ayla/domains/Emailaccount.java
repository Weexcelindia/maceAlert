package com.ayla.domains;

import android.content.Context;

import com.ayla.domains.base.MyBaseEntity;
import com.orm.SugarRecord;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


/**
 * Created by IntelliJ IDEA.
 * User: billy
 * Date: 2014/6/19
 * Time: 下午 12:48
 */
public class Emailaccount extends SugarRecord<Emailaccount> {
    public String email_id;
    public String lastdate;
    public String password;

    public Emailaccount(Context context, String email, String lastdate, String password) {
        super(context);
        this.email_id = email;
        this.lastdate = lastdate;
        this.password = password;
    }

    public Emailaccount(Context context, String email, Date lastdate, String password)
    {
        super(context);
        this.email_id = email;
        this.lastdate = getDateTime(lastdate);
        this.password = password;
    }

    public Emailaccount(Context context) {
        super(context);
    }

    public String getEmail() {
        return email_id;
    }

    public String getLastdate() {
        return lastdate;
    }

    public String getPassword() {
        return password;
    }

    private String getDateTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return dateFormat.format(date);
    }

}
