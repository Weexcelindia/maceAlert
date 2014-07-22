package com.ayla.domains;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.ayla.domains.Util.BitmapUtil;
import com.ayla.domains.base.MyBaseEntity;
import com.ayla.service.lang.f1;
import com.orm.SugarRecord;

import java.io.ByteArrayOutputStream;
import java.util.Date;


/**
 * Created by IntelliJ IDEA.
 * User: billy
 * Date: 2014/6/19
 * Time: 下午 12:48
 */


public class Panel extends SugarRecord<Panel> {

    public String dsn;

    public String getPanelid() {
        return panelid;
    }

    public String panelid;
    public String name;
    public String uuid;
    public String timezone;
    public String email;
    public String emailSignature;
    public String emergyPhoneNumber;
    public String panelPassCode;
    public String createdate;

    //Done Weexcel can we store binary directly in this orm?-- yes,converting byte into string using base64encoding
    public String image;

    public Panel(Context context) {
        super(context);
    }


//    //if cannot please implement this method
//    public void gotImageFile(f1<Byte[]> imageFetchSuccessCallback) {
//    //perform orm specific fetching binary here
//        //cannot be
//        Byte[] binaryImage=null;
//        imageFetchSuccessCallback.run(binaryImage);
//    }

    public void saveUserCaptureImage(byte[] userCatpuredImage) {
        //done Weexcel should down-size it to 100x100
        //should delete previous saved image
        //save it using orm specific;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(userCatpuredImage,0, userCatpuredImage.length,options);

        options.inSampleSize=BitmapUtil.calculateInSampleSize(options,100,100);
        options.inJustDecodeBounds = false;
        Bitmap bmp=BitmapFactory.decodeByteArray(userCatpuredImage,0,userCatpuredImage.length,options);
        image=Base64.encodeToString(getBytesFromBitmap(bmp),Base64.DEFAULT);
        bmp.recycle();
    }



    public String getDsn() {
        return dsn;
    }


    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getEmail() {
        return email;
    }

    public String getEmailSignature() {
        return emailSignature;
    }

    public String getEmergyPhoneNumber() {
        return emergyPhoneNumber;
    }

    public String getPanelPassCode() {
        return panelPassCode;
    }

    public String getImage() {
        return image;
    }

    public byte[] getImageByte() {
        return Base64.decode(image,Base64.DEFAULT);
    }


    public String getCreatedate() {
        return createdate;
    }

    private  byte[] getBytesFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        return stream.toByteArray();
    }


}
