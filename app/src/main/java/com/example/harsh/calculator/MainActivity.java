package com.example.harsh.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button add,sub,div,mul,ce,c,back,ex,byx,equal;
    Button num[] = new Button[10];
    TextView box;
    double operand[]=new double[10];
    int operator[]=new int[10];
    int i,j,h,k;
    double res;
    String prev;
    String history[]=new String[5];

    MainActivity(){
        for(i=0;i<=9;i++){
            operand[i]=0;
            operator[i]=0;
        }
        i=0;
        j=0;
        k=0;
        res=0;
        h=0;
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
        c=(Button)findViewById(R.id.cl);
        back=(Button)findViewById(R.id.ba);
        ex=(Button)findViewById(R.id.ex);
        byx=(Button)findViewById(R.id.byx);
        equal=(Button)findViewById(R.id.equal);
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
        equal.setOnClickListener(this);
    }

    public void clear_all(){
        for(i=0;i<=9;i++){
            operand[i]=0;
            operator[i]=0;
        }
        i=0;
        j=0;
        k=0;
        res=0;
        box.setText("");
    }

    public void display(int x){
        if(x<=9) {
            operand[i] = (operand[i] * 10) + x;
            prev=box.getText().toString()+x;
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
                case 15: box.setText(box.getText().toString()+"1/x");
                         operator[i]=15;
                         break;
                case 16: for(j=1;j<=i;j++){
                           switch(operator[j]){
                                case 10: res=operand[j-1]+operand[j];
                                    operand[j]=res;
                                    break;
                                case 11: res=operand[j-1]-operand[j];
                                    operand[j]=res;
                                    break;
                                case 12: res=operand[j-1]*operand[j];
                                    operand[j]=res;
                                    break;
                                case 13: res=operand[j-1]/operand[j];
                                    operand[j]=res;
                                    break;
                                case 14: for(k=0;k<operand[j];k++)
                                    res=operand[j-1]*operand[j-1];
                                    operand[j]=res;
                                    break;
                            }
                         }
                        operand[0]=res;
                        for(j=1;j<10;j++) {
                            operand[j] = 0;
                            operator[j] = 0;
                        }
                        box.setText(""+res);
                        history[h]+= "="+res;
                        h++;
                        i=0;
                        break;
                case 17:if(box.getText().toString().length()==0)
                            break;
                        if(operand[i]==0 || (operand[i]/10)==0) {
                             operator[i] = 0;
                             i--;
                        }
                        else
                            operand[i]=(operand[i]/10);
                        prev=box.getText().toString();
                        prev=prev.substring(0,prev.length()-1);
                        box.setText(prev);
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
            case R.id.add:  i++;
                            display(10);
                            break;
            case R.id.sub:  i++;
                            display(11);
                            break;
            case R.id.mul:  i++;
                            display(12);
                            break;
            case R.id.div:  i++;
                            display(13);
                            break;
            case R.id.equal:display(16);
                            history[h]=box.getText().toString();
                            break;
           case R.id.ce: clear_all();
                            break;
           case R.id.ba: display(17);
                         if(box.getText().toString().length()==0)
                             clear_all();
                            break;
        }

    }
}
