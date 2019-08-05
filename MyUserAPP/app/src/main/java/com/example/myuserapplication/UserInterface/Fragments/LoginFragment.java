package com.example.myuserapplication.UserInterface.Fragments;
import android.util.Log;
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
import com.example.myuserapplication.Utility.DialogUtil;

import static androidx.constraintlayout.widget.Constraints.TAG;

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
        try {
            return inflater.inflate(R.layout.login_screen, container, false);
        }
        catch(Exception e) {
            Log.e(TAG, "Login Fragment OnCreate Method Called");
            return null;
        }

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        try {
            super.onViewCreated(view, savedInstanceState);
            initView(view);
        }
        catch (Exception e) {
            Log.e(TAG,"Login Fragment OnViewCreated Method Called");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
        }
        catch (Exception e) {
            Log.e(TAG,"Login Fragment onCreate Method Called");
        }
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
           try {
               NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host);
               navController.navigate(R.id.action_loginFragment_to_registrationFragment);
           }
           catch (Exception e) {
               Log.e(TAG, "Login Fragment onClick for TextView for Signup Method Called");
           }
        }
    });

    }



    @Override
    public void onClick(View view) {
        try {
            switch (view.getId()) {
                case R.id.btn_login:
                    if (onLogin()) {
                        NavController navController=Navigation.findNavController(getActivity(),R.id.my_nav_host);
                        navController.navigate(R.id.action_loginFragment_to_homeFragment);
                        Toast.makeText(getActivity(),"Login Successful",Toast.LENGTH_SHORT).show();
                    }
                    break;

            }
        }catch (Exception e)
        {
            Log.e(TAG,"Login Fragment onClick for Button Method Called");
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
            new DialogUtil().Dialog(getActivity(),"Please provide  valid Contact Number");
            return false;
        }

        if (TextUtils.isEmpty(mPassword.getText().toString())) {
            new DialogUtil().Dialog(getActivity(),"Please provide  valid Password");
            return false;
        }
        return true;
    }
}
