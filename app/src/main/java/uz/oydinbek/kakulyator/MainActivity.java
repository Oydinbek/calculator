package uz.oydinbek.kakulyator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import uz.oydinbek.kakulyator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private double value1, value2, finilResalt;

    private char amallar;


    private StringBuilder editBuildr = new StringBuilder();

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
// Raqamlarni ekranga yozilishi joyi ustida ishlangan joy
    @SuppressLint("NonConstantResourceId")
    public void onButtonCilk(View view) {
        StringBuilder valueBuilder = new StringBuilder(binding.amalBajarish.getText().toString());
        switch (view.getId()) {
            case R.id.nol:
                if (valueBuilder.length() <= 15) {
                    valueBuilder.append("0");
                    editBuildr.append("0");
                }
                break;
            case R.id.bir:
                if (valueBuilder.length() <= 15) {
                    valueBuilder.append("1");
                    editBuildr.append("1");
                }
                break;
            case R.id.ikki:
                if (valueBuilder.length() <= 15) {
                    valueBuilder.append("2");
                    editBuildr.append("2");
                }
                break;
            case R.id.uch:
                if (valueBuilder.length() <= 15) {
                    valueBuilder.append("3");
                    editBuildr.append("3");
                }
                break;
            case R.id.tort:
                if (valueBuilder.length() <= 15) {
                    valueBuilder.append("4");
                    editBuildr.append("4");
                }
                break;
            case R.id.besh:
                if (valueBuilder.length() <= 15) {
                    valueBuilder.append("5");
                    editBuildr.append("5");
                }
                break;
            case R.id.olti:
                if (valueBuilder.length() <= 15) {
                    valueBuilder.append("6");
                    editBuildr.append("6");
                }

                break;
            case R.id.yetti:
                if (valueBuilder.length() <= 15) {
                    valueBuilder.append("7");
                    editBuildr.append("7");
                }
                break;
            case R.id.sakkiz:
                if (valueBuilder.length() <= 15) {
                    valueBuilder.append("8");
                    editBuildr.append("8");
                }
                break;
            case R.id.toqqz:
                if (valueBuilder.length() <= 15) {
                    valueBuilder.append("9");
                    editBuildr.append("9");
                }
                break;
            case R.id.nuqta:
                if (valueBuilder.length() <= 15) {
                    if (valueBuilder.indexOf(".") == -1) {
                        if (valueBuilder.length() > 0) {
                            valueBuilder.append('.');
                            editBuildr.append('.');
                        }
                    }
                }
                break;
            case R.id.musManfiy:
                valueBuilder.append("-");
                editBuildr.append("-");
                break;
            case R.id.C:
                valueBuilder.setLength(0);
                editBuildr.setLength(0);
                break;
            case R.id.del:
                if (valueBuilder.length() > 0) {
                    valueBuilder.deleteCharAt(valueBuilder.length() - 1);
                }
                if (editBuildr.length() > 0) {
                    editBuildr.deleteCharAt(editBuildr.length() - 1);
                }
                if (editBuildr.indexOf("=") != -1) {
                    valueBuilder.setLength(0);
                    editBuildr.setLength(0);
                }
                break;
        }
        binding.amalBajarish.setText(valueBuilder.toString(), TextView.BufferType.EDITABLE);
        binding.getResult.setText(editBuildr.toString(), TextView.BufferType.EDITABLE);
    }
    //Matematik ammalar bajarish ishoralari

    public void mathMathematic(View view) {
        int count = 0;
        switch (view.getId()) {
            case R.id.ayiruv:
                amallar = '-';
                break;
            case R.id.qoshish:
                amallar = '+';
                break;
            case R.id.kop:
                amallar = 'x';
                break;
            case R.id.bolish:
                amallar = '/';
                break;
            case R.id.qovuc:
                count++;
                if (count == 1) {
                    amallar = '(';
                } else
                    count++;
                if (count == 2) {
                    amallar = ')';
                }
                break;
        }
        if (binding.amalBajarish.getText().length()>0){
            String value=binding.amalBajarish.getText().toString();
            value1=Double.parseDouble(value);
            editBuildr.append(" "+amallar+" ");
            binding.amalBajarish.setText(editBuildr.toString());
            binding.amalBajarish.setText("");
        }
    }
// Natijani ekrakga chiqarish uchun ishlangan joyi

    public void onEqualClicked(View view) {
        if (binding.amalBajarish.getText().length()>0) {
            String value = binding.amalBajarish.getText().toString();
            value2 = Double.parseDouble(value);
        }
    switch (amallar){
        case '+':
            finilResalt=value1+value2;
            break;
        case '-':
            finilResalt=value1-value2;
        break;
        case 'x':
            finilResalt=value1*value2;
            break;
        case  '/':
            try {
                finilResalt=value1/value2;

            }catch (ArithmeticException ae){
                finilResalt=0.0;
            }
            break;


    }
        editBuildr.append("="+finilResalt);
        binding.amalBajarish.setText(String.valueOf(finilResalt));
        binding.getResult.setText(editBuildr.toString());

    }
    }


