package com.example.mightguy.criminalintentdemo;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class ZoomedPhotoFragment extends DialogFragment {
    private static final String ARG_ZOOMED_PHOTO = "zoomed_photo";

    private ImageView mZoomedPhotoView;

    public static ZoomedPhotoFragment newInstance(String photoPath) {
        Bundle args = new Bundle();
        args.putString(ARG_ZOOMED_PHOTO, photoPath);

        ZoomedPhotoFragment fragment = new ZoomedPhotoFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String photoPath = getArguments().getString(ARG_ZOOMED_PHOTO);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_image, null);

        mZoomedPhotoView = v.findViewById(R.id.zoomed_image);
        Bitmap bitmap = PictureUtils.getScaledBitmap(photoPath, getActivity());
        mZoomedPhotoView.setImageBitmap(bitmap);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .create();
    }
}
