package com.example.myuserapplication.UserInterface.Fragments;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.myuserapplication.Application.User;
import com.example.myuserapplication.R;
import com.example.myuserapplication.Utility.DialogUtil;

import static androidx.core.content.ContextCompat.checkSelfPermission;
import static com.example.myuserapplication.UserInterface.UI.Authorization.TAG;

public class RegistrationFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private static final int PERMISSION_READ_STATE = 1;
    private RadioGroup mradioGroup;
    private EditText mName;
    private EditText mAge;
    private EditText mContact;
    private EditText mPassword;
    private EditText mPasswordConfirm;
    private Spinner mCountry;
    private Spinner mState;
    private EditText mAadhaar;
    private EditText mIMEI1;
    private Button mSignup;
    private Toolbar myToolbar;
    private ImageButton mVisibile;
    private Spinner countries_spinner;
    private Spinner state_spinner;
    private String Gender;
    private boolean isPlay;
    private int micon;

    User unknown = new User();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try {
            return inflater.inflate(R.layout.registration_screen, container, false);
        } catch (Exception e) {
            Log.e(TAG, "Registration Fragment OnCreateView Method Called");
            return null;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        try {
            super.onViewCreated(view, savedInstanceState);
            initView(view);
        } catch (Exception e) {
            Log.e(TAG, "Registration Fragment OnViewCreated Method Called");
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)

    private void initView(View view) {
        mName = view.findViewById(R.id.Name);
        mradioGroup = view.findViewById(R.id.Gender);
        mAge = view.findViewById(R.id.Age);
        mContact = view.findViewById(R.id.Contact);
        mPassword = view.findViewById(R.id.Pass);
        mCountry = view.findViewById(R.id.countries_spinner);
        mState = view.findViewById(R.id.states_spinner);
        mSignup = view.findViewById(R.id.signup);
        mPasswordConfirm = view.findViewById(R.id.PassCon);
        mAadhaar = view.findViewById(R.id.aadhaar);
        mIMEI1 = view.findViewById(R.id.IMEI);
        myToolbar = view.findViewById(R.id.toolbar);
        mVisibile = view.findViewById(R.id.Visibility);

        mIMEI1.setKeyListener(null);  //Setting the Edittext of IMEI to not Editable.

        myToolbar.setTitle(R.string.title_registration);

        /**
         * Setting anClick Listener to Button of Password that toggles between show or not show the text of the password.
         */
        mVisibile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlay) {
                    //view.setBackgroundResource(R.drawable.hide);
                    micon = R.drawable.hide;
                    mPassword.setTransformationMethod(new PasswordTransformationMethod());  //Sets the Password to Seen
                } else {
                    //view.setBackgroundResource(R.drawable.eye);
                    micon = R.drawable.eye;
                    mPassword.setTransformationMethod(null);        //Then to Not Seen
                }
                isPlay = !isPlay;
                mVisibile.setImageDrawable(
                        ContextCompat.getDrawable(getActivity().getApplicationContext(), micon));    //Changes the icon of the Button.
            }
        });


//Intializing Spinner
        countries_spinner = (Spinner) view.findViewById(R.id.countries_spinner);
        state_spinner = (Spinner) view.findViewById(R.id.states_spinner);

        countries_spinner.setOnItemSelectedListener(this);  //Finds the Country that is Selected.

        //For the Time show the Countries.
        ArrayAdapter<CharSequence> adapter_country = ArrayAdapter.createFromResource(getActivity(), R.array.countries, android.R.layout.simple_spinner_item);
        adapter_country.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countries_spinner.setAdapter(adapter_country);

        setIMEI();

        mSignup.setOnClickListener(this);


    }

    public void setIMEI() {
        //CheckPermission for Reading the Phone State.
        //Dangerous Permission are restricted by Android and USer can revoke the Permission so generating run time Permission .
        TelephonyManager telephonyManager = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
        if (checkSelfPermission(this.getActivity(), Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            // We do not have this permission. Let's ask the user
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_PHONE_STATE}, PERMISSION_READ_STATE);
            return;
        }
        String imei = telephonyManager.getDeviceId();  //Storing the IMEI Number.

        mIMEI1.setText(imei);

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        try {
            switch (requestCode) {
                case PERMISSION_READ_STATE: {
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        // permission granted!
                        // you may now do the action that requires this permission

                        Log.i(TAG, "Permission has been granted by user");
                    } else {
                        // permission denied.
                        Log.i(TAG, "Permission has been denied by user");

                    }
                    return;
                }

            }
        } catch (Exception e) {
            Log.e(TAG, "Registration Fragment RequestPermission Method Called");
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
        } catch (Exception e) {
            Log.e(TAG, "Registration Fragment onCreate Method Called");
        }
    }

    /**
     * Checking that All the Fields of Registration are properly filled if not then return false or else return true.
     *
     * @return
     */
    public boolean isValid() {

        if (TextUtils.isEmpty(mName.getText().toString())) {
            new DialogUtil().Dialog(getActivity(), "Please provide  valid First name");
            return false;
        }

        if (mradioGroup.getCheckedRadioButtonId() == -1) {
            new DialogUtil().Dialog(getActivity(), "Please provide  valid Gender response");
            return false;
        }

        if (countries_spinner.getSelectedItem().equals("---Select---")) {
            new DialogUtil().Dialog(getActivity(), "Please provide  valid Country name");
            return false;
        }

        if (state_spinner.getSelectedItem().equals("---Select---")) {
            new DialogUtil().Dialog(getActivity(), "Please provide  valid State name");
            return false;
        }

        // TextUtils.isEmpty(mContact.getText().toString()) &&
        if (TextUtils.isEmpty(mContact.getText().toString())) {
            new DialogUtil().Dialog(getActivity(), "Please provide  valid Phone number");
            return false;
        } else if (mContact.getText().toString().length() != 10) {
            new DialogUtil().Dialog(getActivity(), "Please provide  valid Phone number");
            return false;
        }

        if (TextUtils.isEmpty(mPassword.getText().toString())) {
            new DialogUtil().Dialog(getActivity(), "Please provide  valid Choose Password");
            return false;
        }

        if (TextUtils.isEmpty(mPasswordConfirm.getText().toString())) {
            new DialogUtil().Dialog(getActivity(), "Please provide  valid Confirm Password");
            return false;
        }
        if (!mPassword.getText().toString().equals(mPasswordConfirm.getText().toString())) {
            new DialogUtil().Dialog(getActivity(), "Both Password and ConfirmPassword are not matching");
            return false;
        }
        if (TextUtils.isEmpty(mAadhaar.getText().toString())) {
            new DialogUtil().Dialog(getActivity(), "Please provide  valid Aadhaar Number");
            return false;
        }

        return true;

    }


    /**
     * If the all is valid then Create a User Object and then Store that User object with the Value of the Fields and then Display it in a Dialog Box.
     */
    private void onSignUpButtonClick() {
        if (isValid()) {

            unknown.setmName(mName.getText().toString().trim());

            mradioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                    RadioButton rb = (RadioButton) getActivity().findViewById(checkedId);
                    Gender = rb.getText().toString();
                }
            });
            unknown.setmGender(Gender);
            unknown.setmAge(Integer.parseInt(mAge.getText().toString().trim()));
            unknown.setmContact(Long.parseLong(mContact.getText().toString().trim()));
            unknown.setmCountry(mCountry.getSelectedItem().toString());
            unknown.setmState(mState.getSelectedItem().toString());
            unknown.setmAadhaar(mAadhaar.getText().toString().trim());
            unknown.setmIMEI(mIMEI1.getText().toString());


            new DialogUtil().Dialog(getActivity(), "SignUp Successful");
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        try {
            String country = adapterView.getItemAtPosition(pos).toString();
            if (country.contentEquals("India")) {
                ArrayAdapter<CharSequence> adapter_state1 = ArrayAdapter.createFromResource(getActivity(), R.array.india_states, android.R.layout.simple_spinner_item);
                adapter_state1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                state_spinner.setAdapter(adapter_state1);
            } else if (country.contentEquals("Srilanka")) {
                ArrayAdapter<CharSequence> adapter_state2 = ArrayAdapter.createFromResource(getActivity(), R.array.srilankan_states, android.R.layout.simple_spinner_item);
                adapter_state2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                state_spinner.setAdapter(adapter_state2);
            }
        } catch (Exception e) {
            Log.e(TAG, "Registration Fragment onItemSelected from Adapter Method Called");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        try {
            onSignUpButtonClick();
        } catch (Exception e) {
            Log.e(TAG, "Registration Fragment onClick for Button Signup Method Called");
        }
    }
}

