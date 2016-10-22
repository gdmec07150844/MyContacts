package cn.edu.gdmec.chaos07150844.mycontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nameEdit;
    private EditText phoneEdit;
    private EditText qqEdit;
    private EditText danweiEdit;
    private EditText addressEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        nameEdit = (EditText) findViewById(R.id.editName);
        phoneEdit = (EditText) findViewById(R.id.editPhone);
        qqEdit = (EditText) findViewById(R.id.editQQ);
        danweiEdit = (EditText) findViewById(R.id.editDanwei);
        addressEdit = (EditText) findViewById(R.id.editAddress);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,Menu.NONE,"保存");
        menu.add(Menu.NONE,2,Menu.NONE,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case 1 :
                if(!nameEdit.getText().toString().equals("")){
                    User user = new User();
                    user.setName(nameEdit.getText().toString());
                    user.setPhone(phoneEdit.getText().toString());
                    user.setDanwei(danweiEdit.getText().toString());
                    user.setQq(qqEdit.getText().toString());
                    user.setAddress(addressEdit.getText().toString());
                    ContactsTable ct = new ContactsTable(MainActivity.this);
                    if (ct.addData(user)){
                        Toast.makeText(MainActivity.this,"添加成功！",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this,"添加失败！",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this,"请先输入数据！！！",Toast.LENGTH_SHORT).show();
                }
                break;
            case 2 :
                finish();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
