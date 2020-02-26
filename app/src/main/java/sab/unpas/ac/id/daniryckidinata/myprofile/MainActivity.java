package sab.unpas.ac.id.daniryckidinata.myprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //deklarasi variabel
    Button buttonProfile, buttonGallery, buttonContact, buttonSetting, buttonLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //memanggil fragment profile saat aplikasi pertama di create
        changeContent(ProfileFragment.newInstance(this));

        //instansiasi variable berdasarkan id yang terdapat pada activity_main.xml
        buttonProfile = (Button) findViewById(R.id.btn_profile);
        buttonGallery = (Button) findViewById(R.id.btn_gallery);
        buttonContact = (Button) findViewById(R.id.btn_contact);
        buttonSetting = (Button) findViewById(R.id.btn_setting);
        buttonLogout = (Button) findViewById(R.id.btn_logout);

        //action
        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeContent(ProfileFragment.newInstance(MainActivity.this));
            }
        });
        buttonGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeContent(GalleryFragment.newInstance(MainActivity.this));
            }
        });
        buttonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeContent(ContactFragment.newInstance(MainActivity.this));
            }
        });
        buttonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeContent(SettingFragment.newInstance(MainActivity.this));
            }
        });
    }


    //memanggil fragment
    public void changeContent(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commitAllowingStateLoss();
    }
}
