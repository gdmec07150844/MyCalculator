package cn.edu.gdmec.chaos07150844.work3;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText weightEditView;
    private RadioButton manRadioButton,womanRadioButton;
    private Button calculateButton;
    private TextView heightTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heightcalculator);

        weightEditView = (EditText) findViewById(R.id.weight);
        manRadioButton = (RadioButton) findViewById(R.id.man);
        womanRadioButton = (RadioButton) findViewById(R.id.woman);
        calculateButton = (Button) findViewById(R.id.button);
        heightTextView = (TextView) findViewById(R.id.tv1);

        calculateButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(!weightEditView.getText().toString().trim().equals("")){
            if(manRadioButton.isChecked()|womanRadioButton.isChecked()){
                Double weight = Double.parseDouble(weightEditView.getText().toString());
                StringBuffer sb = new StringBuffer();
                if (manRadioButton.isChecked()){
                    double height = calculateHeight(weight,"男");
                    sb.append("------------评估结果------------\n");
                    sb.append("男性标准身高："+(int)height+"cm");
                }else{
                    double height = calculateHeight(weight,"女");
                    sb.append("------------评估结果------------\n");
                    sb.append("女性标准身高："+(int)height+"cm");

                }
                heightTextView.setText(sb);
            }else{
                showMessage("没有选择性别");
            }
        }else {
            showMessage("没有输入体重");
        }


    }

    public void showMessage(String message){
        AlertDialog alert = new AlertDialog.Builder(this).create();
        alert.setTitle("系统提示");
        alert.setMessage(message);
        alert.setButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();
    }

    public double calculateHeight(double weight,String sex){
        double height;
        if(sex=="男"){
            //height = 170-(62-weight)/0.6;
            height = weight*10/7+80;
        }else{
            height = weight*10/6+70;
            //height = 158-(52-weight)/0.5;
        }
        return height;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"退出");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
