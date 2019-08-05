package com.example.myuserapplication.UserInterface.Fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.myuserapplication.R;
import com.example.myuserapplication.UserInterface.Authorization;

public class LoginFragment extends Fragment implements View.OnClickListener {
    public static final String CLASSTAG= LoginFragment.class.getSimpleName();
    private boolean isPlay = false;
    private int micon;
    private EditText mPhone;
    private EditText mPassword;
    private Button btn_login;
    private TextView txtSignup;
    private ImageButton mVisibilty;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_screen,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View view) {

    mPhone=view.findViewById(R.id.et_phone);
    mPassword=view.findViewById(R.id.et_password);
    btn_login=view.findViewById(R.id.btn_login);
    txtSignup=view.findViewById(R.id.Signup);
    btn_login.setOnClickListener(this);
    mVisibilty=view.findViewById(R.id.Visibility);


    mVisibilty.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(isPlay){
                //view.setBackgroundResource(R.drawable.hide);
                micon=R.drawable.hide;
                mPassword.setTransformationMethod(new PasswordTransformationMethod());
            }else{
                //view.setBackgroundResource(R.drawable.eye);
                micon=R.drawable.eye;
                mPassword.setTransformationMethod(null);
            }
            isPlay = !isPlay;
            mVisibilty.setImageDrawable(
                    ContextCompat.getDrawable(getActivity().getApplicationContext(), micon));
        }
    });

    txtSignup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           /* ((Authorization) getActivity()).loadFragment(
                    R.id.container1,
                    new RegistrationFragment(),
                    RegistrationFragment.CLASSTAG,
                    true
            );*/
            NavController navController= Navigation.findNavController(getActivity(),R.id.my_nav_host);
            navController.navigate(R.id.action_loginFragment_to_registrationFragment);
        }
    });

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login :
                if(onLogin()) {
                    Toast.makeText(getActivity(), "LoginFragment Successful", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getActivity(),"LoginFragment UnSuccessful",Toast.LENGTH_SHORT).show();
                break;

        }

    }

    private boolean onLogin() {
        if(isValid()) {
            if (mPhone.getText().toString().equals(mPassword.getText().toString()))
                return true;
            else
                return false;
        }
        else
            return false;
    }

    private boolean isValid() {
        if (TextUtils.isEmpty(mPhone.getText().toString())) {
            Toast.makeText(getActivity(), "Please provide  valid user name", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(mPassword.getText().toString())) {
            Toast.makeText(getActivity(), "Please provide  valid Password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
