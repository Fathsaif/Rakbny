package com.saif.rakbny;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.saif.rakbny.utils.CircleImageView;

import java.io.ByteArrayOutputStream;

import butterknife.BindView;

public class SignUpActivity extends AppCompatActivity {
    private static final int PICK_PROFILE_IMAGE = 12;
    @BindView(R.id.iv_profile)CircleImageView profileImg;
    String image = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void setPickProfileImage(View view){
        pickImage();
    }
    public void nextBtn (View view){
        startActivity(new Intent(this,HomeMapsActivity.class));
    }
    public void pickImage (){
        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("image/*");
        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");
        Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});
        startActivityForResult(chooserIntent, PICK_PROFILE_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {

            if (requestCode == PICK_PROFILE_IMAGE && resultCode == RESULT_OK
                    && data != null) {
                Uri selectedImage = data.getData();
                Bitmap bitmap =
                        MediaStore.Images.Media.getBitmap(getContentResolver(),selectedImage);
                profileImg.setImageBitmap(bitmap);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 70, baos); //bm is the bitmap object
                byte[] b = baos.toByteArray();
                image = Base64.encodeToString(b,Base64.DEFAULT);
            } else {
                Toast.makeText(this, "No image chosen!", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG)
                    .show();
        }
    }
}
