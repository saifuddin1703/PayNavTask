package com.example.paynavtask.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.Toast;

import com.example.paynavtask.R;
import com.example.paynavtask.adpaters.FriendListAdapter;
import com.example.paynavtask.adpaters.NestedFriendlistAdapter;
import com.example.paynavtask.adpaters.ViewPagerAdapter;
import com.example.paynavtask.databinding.ActivityMainBinding;
import com.example.paynavtask.databinding.FragmentDashboardBinding;
import com.example.paynavtask.databinding.FragmentFriendProfileBinding;
import com.example.paynavtask.utils.DataFile;
import com.google.android.material.tabs.TabLayoutMediator;


public class DashboardFragment extends Fragment {


    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDashboardBinding binding = FragmentDashboardBinding.inflate(inflater);


        float density = getResources().getDisplayMetrics().density;
        binding.friendlist.setAdapter(new FriendListAdapter(DataFile.getFriends(),DataFile.getFriends().size()));
        binding.friendlist.setLayoutManager(new GridLayoutManager(requireContext(),5));
        binding.mostrecentlist.setAdapter(new FriendListAdapter(DataFile.getFriends(), 4));
        binding.mostrecentlist.setLayoutManager(new GridLayoutManager(requireContext(),4));
//

        binding.toolbar.back.setOnClickListener(view -> {
            Navigation.findNavController(view).popBackStack();
        });
        binding.expandedfriendlist.setAdapter(new NestedFriendlistAdapter(DataFile.getFriends(),DataFile.getFriends().size()));
        binding.expandedfriendlist.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView friendlist = binding.friendlist;
//        friendlist.setAdapter(new FriendListAdapter(4));
//        friendlist.setLayoutManager(new GridLayoutManager(requireContext() ,4));

        GradientDrawable background = (GradientDrawable) binding.scrollView2.getBackground();


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        binding.viewpager.setAdapter(viewPagerAdapter);

//        binding
        TabLayoutMediator mediator = new TabLayoutMediator(binding.tab, binding.viewpager,
                (tab, position) -> {
                    binding.viewpager.setCurrentItem(position);
                    tab.setText((position==0)?"return":"receive");
                    binding.tab.selectTab(tab);
                    Toast.makeText(requireContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                }
        );
        mediator.attach();
//        binding.tab.me




        binding.expand.setOnClickListener(view -> {
          binding.expand.setVisibility(View.GONE);
          binding.friendicon1.setVisibility(View.GONE);
          binding.friendicon4.setVisibility(View.GONE);
          binding.friendicon2.setVisibility(View.GONE);
          binding.friendicon3.setVisibility(View.GONE);

          binding.collapes.setVisibility(View.VISIBLE);
          binding.expandedfriendlist.setVisibility(View.VISIBLE);
        });

        binding.collapes.setOnClickListener(view -> {
            binding.collapes.setVisibility(View.GONE);
            binding.friendicon1.setVisibility(View.VISIBLE);
            binding.friendicon4.setVisibility(View.VISIBLE);
            binding.friendicon2.setVisibility(View.VISIBLE);
            binding.friendicon3.setVisibility(View.VISIBLE);

            binding.expand.setVisibility(View.VISIBLE);
            binding.expandedfriendlist.setVisibility(View.GONE);
        });
        binding.getRoot().addTransitionListener(new MotionLayout.TransitionListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int startId, int endId) {
                GradientDrawable background = (GradientDrawable) binding.scrollView2.getBackground();

                Log.d("tag",String.valueOf(startId==R.id.start)+" "+String.valueOf(endId==R.id.end));
//              for (float i: background.getCornerRadii()){
//                  Log.d("tag",String.valueOf(i));
//              }

//              Log.d("tag",String.valueOf(R.id.start==startId));
                if (binding.open.getVisibility()==View.GONE){
                    ValueAnimator valueAnimator = ValueAnimator.ofFloat(25*density,0f);
                    valueAnimator.setDuration(1000)
                            .addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                @Override
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    float toprightradii = (float) valueAnimator.getAnimatedValue();
                                    float topleftradii = 25*density - toprightradii;
                                    background.setCornerRadii(new float[]{topleftradii,topleftradii,toprightradii,toprightradii,0f,0f,0f,0f});
                                    binding.scrollView2.setBackground(background);
                                }
                            });
                    valueAnimator.start();

                }else{
                    ValueAnimator valueAnimator = ValueAnimator.ofFloat(25*density,0f);
                    valueAnimator.setDuration(1000)
                            .addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                @Override
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    float topleftradii = (float) valueAnimator.getAnimatedValue();
                                    float toprightradii = 25*density - topleftradii;
                                    background.setCornerRadii(new float[]{topleftradii,topleftradii,toprightradii,toprightradii,0f,0f,0f,0f});
                                    binding.scrollView2.setBackground(background);
                                }
                            });
                    valueAnimator.start();
                }
            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int startId, int endId, float progress) {


            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int currentId) {

                int visibility = binding.open.getVisibility();
                binding.open.setVisibility((visibility==View.GONE)?View.VISIBLE:View.GONE);

                if (currentId==R.id.end){
//                    binding.tagline.setVisibility(View.GONE);
                    binding.expenditures.setVisibility(View.GONE);
                    binding.constraintlayout4.setVisibility(View.GONE);
                    binding.mostrecentlist.setAdapter(new FriendListAdapter(DataFile.getFriends(), 8));
                    binding.mostrecentlist.setLayoutManager(new GridLayoutManager(requireContext(),5));
//                    binding.friendlist.setAdapter(new FriendListAdapter(20));
//                    binding.friendlist.setLayoutManager(new GridLayoutManager(requireContext(),5));
                }else{
                    binding.tagline.setVisibility(View.VISIBLE);
                    binding.expenditures.setVisibility(View.VISIBLE);
                    binding.constraintlayout4.setVisibility(View.VISIBLE);
                    binding.mostrecentlist.setAdapter(new FriendListAdapter(DataFile.getFriends(), 4));
                    binding.mostrecentlist.setLayoutManager(new GridLayoutManager(requireContext(),4));
//
//                    binding.friendlist.setAdapter(new FriendListAdapter(20));
//                    binding.friendlist.setLayoutManager(new GridLayoutManager(requireContext(),5));
                }

            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int triggerId, boolean positive, float progress) {

            }
        });

        binding.open.setOnClickListener((View view) ->{
            if (binding.open.getVisibility()==View.VISIBLE){
                binding.motionlayout.transitionToStart();
//              binding.open.setVisibility(View.INVISIBLE);
            }
        });

        binding.constraintLayout3.setOnClickListener((View view) ->{
            if (binding.open.getVisibility()==View.VISIBLE){
                binding.motionlayout.transitionToStart();
//              binding.open.setVisibility(View.INVISIBLE);
            }
        });
        return binding.getRoot();
    }

}