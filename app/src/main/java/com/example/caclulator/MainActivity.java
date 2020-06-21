package com.example.caclulator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String str="";
    String ss="";
    String c="";
    String c1="";
    Double ans = 0d;
    Double as;
    Double[] s1 = new Double[1000];
    Double[] s2 = new Double[1000];
    int x=0,m=0,k=0;
    public void deleteall(View view){
        str="";
        TextView text = (TextView)findViewById(R.id.text);
        text.setText(str);
    }
    public void deleteone(View view){
        str= str.substring(0,str.length()-1);
        TextView text = (TextView)findViewById(R.id.text);
        text.setText(str);
    }
    public void opr(View view){
        Button button2 = (Button)view;
        String next = button2.getText().toString();
        TextView text = (TextView)findViewById(R.id.text) ;
        if(str.length()!=0 && Character.isDigit(str.charAt(str.length()-1)))
        {str = str + next;
        text.setText(str);}
    }
    public void opd(View view){
        Button button1 = (Button)view;
        String next = button1.getText().toString();
        TextView text = (TextView)findViewById(R.id.text);
        str = str + next;
        text.setText(str);
    }
    public void display(View view){
        k=0;m=0;x=0;c="";c1 ="";ans = 0d;

        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='/' || str.charAt(i)=='+' || str.charAt(i)=='-' || str.charAt(i)=='*') {
                c = c + str.charAt(i);
                s1[k] = Double.parseDouble(ss);
                k++;
                ss="";
            }
            else
            {
                ss = ss + str.charAt(i);
            }
            if(i==(str.length()-1))
            {
                s1[k] = Double.parseDouble(ss);
                ss="";
            }
        }
        for(int i=0;i<k;i++)
        {
            if(i>0 && (c.charAt(i)=='/' || c.charAt(i)=='*') && (c.charAt(i-1)=='/' || c.charAt(i-1)=='*'))
            {
                if(c.charAt(i)=='/'){s2[m-1] = (Double)(s2[m-1]/s1[i+1]);}
                if(c.charAt(i)=='*'){s2[m-1] = (Double)(s2[m-1]*s1[i+1]);}
                x=i+2;
            }
            else if(c.charAt(i)=='/' || c.charAt(i)=='*')
            {
                for(int j=x;j<i;j++)
                {
                    s2[m] = (Double)s1[j];
                    m++;
                }
                x = i+2;
                if(c.charAt(i)=='/'){s2[m] = (Double)(s1[i]/s1[i+1]);}
                if(c.charAt(i)=='*'){s2[m] = (Double)(s1[i]*s1[i+1]);}
                m++;
            }
            else
            {
                c1 = c1 + c.charAt(i);
            }
        }
        for(int i=x;i<=k;i++)
        {
            s2[m] = (Double)s1[i];
            m++;
        }
        m--;
        for(int i=0;i<=k;i++)
        {
            s1[i]=0d;
        }
        c="";
        x = 0;
        if(m>0){
            ans = s2[0];
            for (int i = 0; i < m; i++) {
                if (c1.charAt(i) == '+') {
                    ans = (Double) (ans + s2[i + 1]);
                } else if (c1.charAt(i) == '-') {
                    ans = (Double) (ans - s2[i + 1]);
                }
            }
            TextView text = (TextView)findViewById(R.id.text);
            str = Double.toString(Double.parseDouble(String.format("%.2f", ans)));
            text.setText(str);
        }
        else {
            TextView text = (TextView)findViewById(R.id.text);
            str = Double.toString(Double.parseDouble(String.format("%.2f", s2[0])));
            text.setText(str);
        }
        for(int i=0;i<=m;i++)
        {
            s2[i] = 0d;
        }
        ans = 0d;
        c1 = "";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
