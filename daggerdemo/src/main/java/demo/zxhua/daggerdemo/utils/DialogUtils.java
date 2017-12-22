package demo.zxhua.daggerdemo.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import demo.zxhua.daggerdemo.ui.listener.AddClassClickListener;

/**
 * Created by Zxhua on 2017/12/6 0006.
 */

public class DialogUtils {
    private AlertDialog mFilterDialog;
    private String[] strings;


    public void showDetail(Context context, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        message = message.replace("FFFFFF", "000000");
        builder.setMessage(Html.fromHtml(message));
        builder.setPositiveButton("确定", null);
        builder.show();
    }

    public void showFilterDialog(TextView textView, String[] strings) {
        this.strings = strings;
        AlertDialog.Builder builder = new AlertDialog.Builder(textView.getContext());
        builder.setView(initDialogView(textView.getContext(), textView));
        builder.setCancelable(false);
        mFilterDialog = builder.show();
    }

    @NonNull
    public View initDialogView(Context context, TextView textView) {
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

    @NonNull
    private View initDialogView(Context context, AddClassClickListener listener) {
        //容器
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        EditText editText = new EditText(context);

        //按钮
        Button button = new Button(context);
        button.setText("确定");
        button.setOnClickListener(view -> {
            String claName = editText.getText().toString();
            if (TextUtils.isEmpty(claName.trim())) {
                Toast.makeText(context, "输入班级名称", Toast.LENGTH_SHORT).show();
                return;
            }
            if (listener != null) listener.onClickListener(editText.getText().toString());

            mFilterDialog.dismiss();
        });
        //添加到容器
        linearLayout.addView(editText);
        linearLayout.addView(button);
        return linearLayout;
    }

    public void showAddClassDialog(Context context,AddClassClickListener listener){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(initDialogView(context,listener));
        builder.setCancelable(false);
        mFilterDialog = builder.show();
    }

}
