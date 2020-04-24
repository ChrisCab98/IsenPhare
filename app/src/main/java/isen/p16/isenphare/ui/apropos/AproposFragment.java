package isen.p16.isenphare.ui.apropos;

import androidx.lifecycle.ViewModelProviders;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import isen.p16.isenphare.R;

public class AproposFragment extends Fragment {

    private AproposViewModel mViewModel;

    public static AproposFragment newInstance() {
        return new AproposFragment();
    }

/*    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.apropos_fragment, container, false);
    }*/

    public View onCreateView(@NonNull LayoutInflater inflater,@NonNull ViewGroup container, @NonNull Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.apropos_fragment,container,false);

        VideoView videoView = view.findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("android.resource://"+getContext().getPackageName()+"/"+R.raw.ipadpro);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AproposViewModel.class);
        // TODO: Use the ViewModel
    }

}


//https://www.youtube.com/watch?v=nnZeDt2c8Yo