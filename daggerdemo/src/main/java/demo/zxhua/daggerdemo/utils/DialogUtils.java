package demo.zxhua.daggerdemo.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Zxhua on 2017/12/6 0006.
 */

public class DialogUtils {
    private  AlertDialog mFilterDialog;
    private  String[] strings;

    public  void showFilterDialog(TextView textView,String[] strings) {
        this.strings = strings;
        AlertDialog.Builder builder = new AlertDialog.Builder(textView.getContext());
        builder.setView(initDialogView(textView.getContext(), textView));
        builder.setCancelable(false);
        mFilterDialog = builder.show();
    }

    @NonNull
    public  View initDialogView(Context context, TextView textView) {
        //容器
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        //下拉框
        Spinner spinner = new Spinner(context, Spinner.MODE_DROPDOWN);
        spinner.setAdapter(new ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_dropdown_item,
                strings));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(strings[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //按钮
        Button button = new Button(context);
        button.setText("确定");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFilterDialog.dismiss();
            }
        });
        //添加到容器
        linearLayout.addView(spinner);
        linearLayout.addView(button);
        return linearLayout;
    }
}
