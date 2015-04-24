package com.example.lxxself.calculator;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private Button bt0,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,btPoint,btClean,btDel,btMultiply,btMinus,btPlus,btDivide,btEqule;
    private EditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt0 = (Button) findViewById(R.id.bt0);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        bt7 = (Button) findViewById(R.id.bt7);
        bt8 = (Button) findViewById(R.id.bt8);
        bt9 = (Button) findViewById(R.id.bt9);
        btPoint = (Button) findViewById(R.id.btPoint);
        btClean = (Button) findViewById(R.id.btClean);
        btDel = (Button) findViewById(R.id.btDel);
        btPlus = (Button) findViewById(R.id.btPlus);
        btMinus = (Button) findViewById(R.id.btMinus);
        btMultiply = (Button) findViewById(R.id.btMultiply);
        btDivide = (Button) findViewById(R.id.btDivide);
        btEqule = (Button) findViewById(R.id.btEqule);
        etInput = (EditText) findViewById(R.id.etInput);

        bt0.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        btPoint.setOnClickListener(this);
        btPlus.setOnClickListener(this);
        btMinus.setOnClickListener(this);
        btMultiply.setOnClickListener(this);
        btDivide.setOnClickListener(this);
        btClean.setOnClickListener(this);
        btDel.setOnClickListener(this);
        btEqule.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        String input = etInput.getText().toString();
        System.out.println("bb"+etInput.getText().toString()+"bb");
        System.out.println("aa"+input+"aa");

        switch (v.getId()){
            case R.id.bt0:
            case R.id.bt1:
            case R.id.bt2:
            case R.id.bt3:
            case R.id.bt4:
            case R.id.bt5:
            case R.id.bt6:
            case R.id.bt7:
            case R.id.bt8:
            case R.id.bt9:
                //结果再次点击时候直接是数字
                if(isFinal == true){
                    etInput.setText(((Button) v).getText());
                    isFinal = false;
                }else {
                    etInput.setText(input + ((Button) v).getText());
                }
                break;
            case R.id.btPoint:
                    if (input.equals("")||input==null||isFinal==true){
                        etInput.setText("0"+((Button)v).getText());
                        isFinal = false;
                    }else if(input.substring(input.length() - 1).equals(" ")||input.substring(input.length() - 1).equals(".")||input.substring(input.length() - 1).equals("-")||input.substring(input.length() - 1).equals("+")){
                        etInput.setText(input);
                    }else {
                        etInput.setText(input + ((Button) v).getText());
                    }

                break;
            case R.id.btPlus:
            case R.id.btMinus:
            case R.id.btMultiply:
            case R.id.btDivide:
                isFinal = false;
                if (input.equals("")||input==null){
                    etInput.setText("0 "+((Button)v).getText()+" ");
                }else {

                    if (!input.substring(input.length() - 1).equals(" ")) {
                        if(input.substring(input.length()-1).equals("-")||input.substring(input.length()-1).equals("+")){
                            etInput.setText(input);
                        }else {
                            etInput.setText(input + " " + ((Button) v).getText() + " ");
                        }
                    } else {
                        System.out.println("ccc"+input.substring(input.length()-2,input.length()-1));
                        System.out.println("ddd"+input.length());
                        if ((input.substring(input.length() - 2, input.length()-1).equals("×") || input.substring(input.length() - 2, input.length()-1).equals("÷")) && (((Button) v).getText().equals("-")) ) {
                            etInput.setText(input + ((Button) v).getText());
                        }else {
                            etInput.setText(input);
                        }
                    }
                }
                break;
            case R.id.btClean:
                etInput.setText("");
                isFinal = false;
                break;
            case R.id.btDel:
                isFinal =false;
                if(!input.equals("")) {
                    if (input.substring(input.length() - 1).equals(" ")) {
                        etInput.setText(input.substring(0, input.length() - 3));
                    } else {
                        etInput.setText(input.substring(0, input.length() - 1));
                    }
                }
                break;
            case R.id.btEqule:
                getResult(input);
                isFinal = true;
                break;
        }
    }
    boolean isFinal = false;
    private void getResult(String input) {
        if(input.equals("")||input == null){
            return;
        }else if(!input.contains(" ")){
            return;
        }else{
            if(input.substring(input.length()-1).equals("-")){
                input = input.replace("-","1");
            }
            if(input.substring(input.length()-1).equals(" ")){
                input = input.substring(0,input.length()-3);
            }
            Calculate(input);
            etInput.setText(publicInput);

            return;
        }


    }

    public String publicInput = "nothing";
    private void Calculate(String input) {
        publicInput = input;
        if(publicInput.contains("÷ 0")){
            publicInput = "∞";
        }
        if(publicInput.contains("∞")){
            publicInput = "∞";
        }
        if(publicInput.contains(" × ")){
            Multiply(publicInput);
        }
        if (publicInput.contains(" ÷ ")){
            Divide(publicInput);
        }
        if (publicInput.contains(" - ")){
            Minus(publicInput);
        }
        if (publicInput.contains(" + ")){
            Plus(publicInput);
        }

    }

    private String dealStr(int way,String str,int a1) {
        System.out.println("-----str----:"+str+"aaa");
        String s1 = str.substring(0, a1 - 1);//乘号前半部分
        String s2 = str.substring(a1 + 2);//乘号后半部分
        System.out.println("s1:"+s1+"--s2:"+s2);

        String s3 = s1.substring(s1.lastIndexOf(" "));//乘号前一个数字字符
        String s4 = s2.substring(0,s2.indexOf(" "));//乘号后一个数字字符
        System.out.println("s3:"+s3+"--s4:"+s4);

        String s5 = s1.substring(0, s1.lastIndexOf(" ")+1);
        String s6 = s2.substring(s2.indexOf(" "));
        System.out.println("s5:"+s5+"--s6:"+s6);

        Double d1 = Double.parseDouble(s3);
        Double d2 = Double.parseDouble(s4);
        Double c = 0.0;
        switch (way){
            case 1:
                 c = Arith.mul(d1,d2);
                break;
            case 2:
                c = Arith.div(d1,d2);
                break;
            case 3:
                c = Arith.add(d1,d2);
                break;
            case 4:
                c = Arith.sub(d1,d2);
                break;
        }
        if(c % 1 == 0){
            int c1;
            c1 = c.intValue();
            str = s5 +c1 + s6;
        }else {
            str = s5 + c + s6;
        }
        System.out.println("new str:"+str);
        System.out.println("new pub:"+publicInput);
        return str;
    }

    private void Multiply(String r) {//乘法
        String str = " "+r+" "; //所有返回字符串收尾加上空格
        int a1 = str.indexOf("×");
        if(a1!=-1) {
            str = dealStr(1,str,a1);
            Multiply(str);
        }else {
            publicInput = str.trim();
            System.out.println("new pub:"+publicInput);
            return ;
        }
    }

    private void Divide(String r) {//除法
        String str = " "+r+" ";
        int a1 = str.indexOf("÷");
        if(a1!=-1) {
            str = dealStr(2,str,a1);
            Divide(str);
        }else {
            publicInput = str.trim();
            return ;
        }
    }
    private void Plus(String r) {//加法
        String str = " "+r+" ";
        int a1 = str.indexOf("+");
        if(a1!=-1) {
            str = dealStr(3,str,a1);
            Plus(str);
        }else {
            publicInput = str.trim();
            return ;
        }
    }

    private void Minus(String r) {//减法
        String str = " "+r+" ";
        System.out.println("减号str:"+str+"bb");
        int a1 = str.indexOf(" - ");
        if(a1!=-1) {
            str = dealStr(4,str,a1+1);
            Minus(str);
        }else {
            publicInput = str.trim();
            return ;
        }
    }

}
