package com.ifkirne.calculatrice;

import androidx.appcompat.app.AppCompatActivity;




import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

      private Button btnC;
      private Button btnplus;
      private Button btndiv;
      private Button btnmoins;
      private Button btnmulti;
      private Button btnpar1;
      private Button btnpar2;
      private Button btneq;
      private Button btn0;
      private Button btn1;
      private Button btn2;
      private Button btn3;
      private Button btn4;
      private Button btn5;
      private Button btn6;
      private Button btn7;
      private Button btn8;
      private Button btn9;
      private Button btnvir;
      private TextView resultat;
      private double res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultat=findViewById(R.id.textView);
        btnvir=findViewById(R.id.vir);
        btneq=findViewById(R.id.eq);
        btndiv=findViewById(R.id.div);
        btnmulti=findViewById(R.id.multi);
        btnmoins=findViewById(R.id.moins);
        btnplus=findViewById(R.id.plus);
        btnpar1=findViewById(R.id.par1);
        btnC=findViewById(R.id.c);
        btnpar2=findViewById(R.id.par2);
        btn1=findViewById(R.id.n1);
        btn0=findViewById(R.id.n0);
        btn2=findViewById(R.id.n2);
        btn3=findViewById(R.id.n3);
        btn4=findViewById(R.id.n4);
        btn5=findViewById(R.id.n5);
        btn6=findViewById(R.id.n6);
        btn7=findViewById(R.id.n7);
        btn8=findViewById(R.id.n8);
        btn9=findViewById(R.id.n9);

        btn0.setOnClickListener((evt)->{
            resultat.setText(resultat.getText().toString()+"0");
        });
        btn1.setOnClickListener((evt)->{
            resultat.setText(resultat.getText().toString()+"1");
        });
        btn2.setOnClickListener((evt)->{
            resultat.setText(resultat.getText().toString()+"2");
        });
        btn3.setOnClickListener((evt)->{
            resultat.setText(resultat.getText().toString()+"3");
        });
        btn4.setOnClickListener((evt)->{
            resultat.setText(resultat.getText().toString()+"4");
        });
        btn5.setOnClickListener((evt)->{
            resultat.setText(resultat.getText().toString()+"5");
        });
        btn6.setOnClickListener((evt)->{
            resultat.setText(resultat.getText().toString()+"6");
        });
        btn7.setOnClickListener((evt)->{
            resultat.setText(resultat.getText().toString()+"7");
        });
        btn8.setOnClickListener((evt)->{
            resultat.setText(resultat.getText().toString()+"8");
        });
        btn9.setOnClickListener((evt)->{
            resultat.setText(resultat.getText().toString()+"9");
        });
        btnplus.setOnClickListener((evt)->{
            resultat.setText(resultat.getText().toString()+"+");
        });
        btnmoins.setOnClickListener((evt)->{
            resultat.setText(resultat.getText().toString()+"-");
        });
        btndiv.setOnClickListener((evt)->{
            resultat.setText(resultat.getText().toString()+"/");
        });
        btnmulti.setOnClickListener((evt)->{
            resultat.setText(resultat.getText().toString()+"*");
        });
        btnpar1.setOnClickListener((evt)->{
            resultat.setText(resultat.getText().toString()+"(");
        });
        btnvir.setOnClickListener((evt)->{
            resultat.setText(resultat.getText().toString()+".");
        });
        btnpar2.setOnClickListener((evt)->{
            resultat.setText(resultat.getText().toString()+")");
        });

        btnC.setOnClickListener((evt)->{
            resultat.setText("");
        });
        btneq.setOnClickListener((evt)->{
            String exp=resultat.getText().toString();
            res=eval(exp);
            resultat.setText(String.valueOf(res));
        });


    }
    public double eval(String expression){
        ExpressionBuilder expressionBuilder= new ExpressionBuilder(expression);
        Expression ex=expressionBuilder.build();
        double resa= ex.evaluate();
        return resa;
    }

}