package com.example.harsh.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.id.edit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button add,sub,div,mul,ce,c,back,ex,byx;
    Button num[] = new Button[9];
    TextView box;
    int operand[]=new int[10];
    int operator[]=new int [9];
    int i,flag;
    String prev;

    MainActivity(){
        for(i=0;i<=9;i++){
            operand[i]=0;
            operator[i]=0;
        }
        i=0;
        flag=0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num[0]=(Button)findViewById(R.id.num0);
        num[1]=(Button)findViewById(R.id.num1);
        num[2]=(Button)findViewById(R.id.num2);
        num[3]=(Button)findViewById(R.id.num3);
        num[4]=(Button)findViewById(R.id.num4);
        num[5]=(Button)findViewById(R.id.num5);
        num[6]=(Button)findViewById(R.id.num6);
        num[7]=(Button)findViewById(R.id.num7);
        num[8]=(Button)findViewById(R.id.num8);
        num[9]=(Button)findViewById(R.id.num9);
        add=(Button)findViewById(R.id.add);
        sub=(Button)findViewById(R.id.sub);
        mul=(Button)findViewById(R.id.mul);
        div=(Button)findViewById(R.id.div);
        ce=(Button)findViewById(R.id.ce);
        c=(Button)findViewById(R.id.c);
        back=(Button)findViewById(R.id.b);
        ex=(Button)findViewById(R.id.ex);
        byx=(Button)findViewById(R.id.byx);
        box=(TextView)findViewById(R.id.box);
        num[0].setOnClickListener(this);
        num[1].setOnClickListener(this);
        num[2].setOnClickListener(this);
        num[3].setOnClickListener(this);
        num[4].setOnClickListener(this);
        num[5].setOnClickListener(this);
        num[6].setOnClickListener(this);
        num[7].setOnClickListener(this);
        num[8].setOnClickListener(this);
        num[9].setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        ce.setOnClickListener(this);
        c.setOnClickListener(this);
        back.setOnClickListener(this);
        ex.setOnClickListener(this);
        byx.setOnClickListener(this);
    }
    public void display(int x){
        if(x<=9) {
            operand[i] = (operand[i] * 10) + x;
            prev=box.getText().toString()+"x";
            box.setText(prev);
        }
        else{
            switch(x){
                case 10: box.setText(box.getText().toString()+"+");
                            operator[i]=10;
                        break;
                case 11: box.setText(box.getText().toString()+"-");
                    operator[i]=11;
                    break;
                case 12: box.setText(box.getText().toString()+"*");
                    operator[i]=12;
                    break;
                case 13: box.setText(box.getText().toString()+"/");
                    operator[i]=13;
                    break;
                case 14: box.setText(box.getText().toString()+"^");
                    operator[i]=14;
                    break;
                case 15: box.setText(box.getText().toString()+"");
                    operator[i]=10;
                    break;
            }
        }
    }
    public void onClick(View v){

        switch(v.getId()){
            case R.id.num0: display(0);
                            break;
            case R.id.num1: display(1);
                            break;
            case R.id.num2: display(2);
                            break;
            case R.id.num3: display(3);
                            break;
            case R.id.num4: display(4);
                            break;
            case R.id.num5: display(5);
                            break;
            case R.id.num6: display(6);
                            break;
            case R.id.num7: display(7);
                            break;
            case R.id.num8: display(8);
                            break;
            case R.id.num9: display(9);
                            break;
            case R.id.add: display(10);
                            i++;
                            break;
        }

    }
}
