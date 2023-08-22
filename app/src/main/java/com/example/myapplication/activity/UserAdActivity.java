package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dao.UsersDAO;
import com.example.myapplication.database.SqlHandle;
import com.example.myapplication.model.User;

import java.util.ArrayList;

public class UserAdActivity extends AppCompatActivity {

    EditText edtUserNameAd, edtFirstNameAd, edtLastNameAd, edtPasswordAd, edtAddressAd, edtPhoneNumberAd, edtRoleAd;
    Button btnInsert, btnUpdate, btnDelete, btnView;
    UsersDAO usersDAO;
    SqlHandle sqlHandle;
    ListView lstData;
    ArrayList<User> listUser;
    ArrayList<String> print;
    ArrayAdapter<String> adapter;
    User infoUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_ad);

        init();
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select();
                show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!infoUser.getUserId().equals(-1)) {
                    usersDAO.userDelete(infoUser.getUserId());
                    show();
                    infoUser = new User(-1, null, null, null, null, null, null, null, null);
                    clearEditTextFields();
                }
                else
                    Toast.makeText(UserAdActivity.this, "No user selected.", Toast.LENGTH_SHORT).show();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!infoUser.getUserId().equals(-1)) {
                    String updateUserName = edtUserNameAd.getText().toString();
                    String updateFirstName = edtFirstNameAd.getText().toString();
                    String updateLastName = edtLastNameAd.getText().toString();
                    String updatePhoneNumber = edtPhoneNumberAd.getText().toString();
                    String updateAddress = edtAddressAd.getText().toString();
                    String updatePassword = edtPasswordAd.getText().toString();
                    String updateRole = edtRoleAd.getText().toString();
                    String updateEmail = "";

                    String updateMessage = usersDAO.userUpdate(infoUser.getUserId(), updateUserName, updatePassword, updateFirstName, updateLastName, updatePhoneNumber, updateAddress, updateEmail, updateRole);
                    show();
                }
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edtUserNameAd.getText().toString();
                String password = edtPasswordAd.getText().toString();
                String firstName = edtFirstNameAd.getText().toString();
                String lastName = edtLastNameAd.getText().toString();
                String phoneNumber = edtPhoneNumberAd.getText().toString();
                String address = edtAddressAd.getText().toString();
                String email = "";
                String role = edtRoleAd.getText().toString();
                infoUser = new User(userName, password, firstName, lastName, phoneNumber, address, email);
                String checkInsert = usersDAO.userInsert(userName, password, firstName, lastName, phoneNumber, address, email, role);
                Toast.makeText(UserAdActivity.this, checkInsert, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        edtUserNameAd = (EditText) findViewById(R.id.edtUserNameAd);
        edtFirstNameAd = (EditText) findViewById(R.id.edtFirstNameAd);
        edtLastNameAd = (EditText) findViewById(R.id.edtLastNameAd);
        edtPasswordAd = (EditText) findViewById(R.id.edtPasswordAd);
        edtAddressAd = (EditText) findViewById(R.id.edtAddressAd);
        edtPhoneNumberAd = (EditText) findViewById(R.id.edtPhoneNumberAd);

        sqlHandle = new SqlHandle(this);
        usersDAO = new UsersDAO(this);
        infoUser = new User(-1, null, null, null, null, null, null, null);

        btnView = (Button) findViewById(R.id.btnView);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        lstData = (ListView) findViewById(R.id.lstData);
        print = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, print);
        lstData.setAdapter(adapter);
        listUser = new ArrayList<>();
        select();
    }

    private void show() {
        listUser.clear();
        listUser = usersDAO.userRead();
        print.clear();
        if (listUser.size() > 0) {
            for (int i = 0; i < listUser.size(); i++) {
                print.add(listUser.get(i).getUserName() + " - " + listUser.get(i).getRole() + " - " + listUser.get(i).getAddress());
            }
            adapter.notifyDataSetChanged();
            }
        else
            Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
        }


    private void select() {
        lstData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                infoUser = new User(listUser.get(position).getUserId(), listUser.get(position).getUserName(), listUser.get(position).getFirstName(),
                        listUser.get(position).getLastName(), listUser.get(position).getPhoneNumber(), listUser.get(position).getAddress(),
                        listUser.get(position).getEmail(), listUser.get(position).getRole());
                edtUserNameAd.setText(infoUser.getUserName());
                edtFirstNameAd.setText(infoUser.getFirstName());
                edtLastNameAd.setText(infoUser.getLastName());
                edtPhoneNumberAd.setText(infoUser.getPhoneNumber());
                edtAddressAd.setText(infoUser.getAddress());
                edtPasswordAd.setText(infoUser.getPassword());
                edtRoleAd.setText(infoUser.getRole());
            }
        });
    }

    private void clearEditTextFields() {
        edtUserNameAd.setText("");
        edtPhoneNumberAd.setText("");
        edtFirstNameAd.setText("");
        edtLastNameAd.setText("");
        edtAddressAd.setText("");
        edtPasswordAd.setText("");
        edtRoleAd.setText("");
    }
}