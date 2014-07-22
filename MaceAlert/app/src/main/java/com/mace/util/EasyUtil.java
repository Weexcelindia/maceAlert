package com.mace.util;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.DisplayMetrics;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by A on 6/30/14.
 */
public class EasyUtil {

    public static int PICKnCAPTURE_REQUEST_CODE=1402;

    public static void pickNcapture(Activity activity,Uri outputFileUri)

    {
        Intent pickIntent = new Intent();
        pickIntent.setType("image/*");
        pickIntent.setAction(Intent.ACTION_GET_CONTENT);
        Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
        String pickTitle = "Select or take a new Picture";
        Intent chooserIntent = Intent.createChooser(pickIntent, pickTitle);
        chooserIntent.putExtra
                (
                        Intent.EXTRA_INITIAL_INTENTS,
                        new Intent[]{takePhotoIntent}
                );

        activity.startActivityForResult(chooserIntent, PICKnCAPTURE_REQUEST_CODE);
    }

    public static Uri getUrifromIntent(Intent data,Uri outputFileUri) {
        Uri selectedImageUri;
        final boolean isCamera;
        if (data == null) {
            isCamera = true;
        } else {
            final String action = data.getAction();
            if (action == null) {
                isCamera = false;
            } else {
                isCamera = action.equals(MediaStore.ACTION_IMAGE_CAPTURE);
            }
        }
        if (isCamera) {
            selectedImageUri = outputFileUri;
        } else {
            selectedImageUri = data == null ? null : data.getData();
        }

        return selectedImageUri;
    }

    public static Uri createUri(String foldername)
    {
        String storageState = Environment.getExternalStorageState();
        if(storageState.equals(Environment.MEDIA_MOUNTED))
        {
        final File root = new File(Environment.getExternalStorageDirectory() + File.separator + foldername + File.separator);
        root.mkdirs();
        final String fname = getUniqueImageFilename(foldername);
        final File sdImageMainDirectory = new File(root,fname);
        return Uri.fromFile(sdImageMainDirectory);
        }
        return null;
    }

    public static String getUniqueImageFilename(String prefix) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = prefix+timeStamp+".jpg";
        return imageFileName;
}


    public static int convertDpToPixel(float dp,Resources resources) {
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return (int) px;
    }

}
