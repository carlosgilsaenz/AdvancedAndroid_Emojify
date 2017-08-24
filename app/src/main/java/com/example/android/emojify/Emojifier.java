package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by csaenz on 8/24/2017.
 */

public class Emojifier {

    public static final String EMOJIFIER_TAG = "EMOJIFIER_TAG";

    public static SparseArray<Face> detectFaces(Bitmap bitmap, Context context){
        //Use Bitmap to build Frame for detector
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        //Build detector
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                .build();

        SparseArray<Face> faces = detector.detect(frame);

        Log.d(EMOJIFIER_TAG,"Number of faces: " + faces.size());

        if(faces.size() == 0){
            Toast.makeText(context,"No Faces detected.", Toast.LENGTH_SHORT).show();
        }

        return faces;
    }
}
