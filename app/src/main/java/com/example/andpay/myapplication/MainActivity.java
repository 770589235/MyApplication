package com.example.andpay.myapplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;

import me.andpay.ti.util.JSONArray;
import me.andpay.ti.util.JSONException;
import me.andpay.ti.util.JSONObject;
import me.andpay.timobileframework.flow.activity.TiFlowActivity;
import me.andpay.timobileframework.mvc.anno.EventDelegate;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;


@ContentView(R.layout.activity_main)
public class MainActivity extends TiFlowActivity{

    private static final String TAG=MainActivity.class.getName();

    @InjectView(R.id.login)
    @EventDelegate(isPassFastClick = true, delegateClass = View.OnClickListener.class, toEventController = MainEventController.class)
    private Button login;

    @InjectView(R.id.register)
    @EventDelegate(isPassFastClick = true, delegateClass = View.OnClickListener.class, toEventController = MainEventController.class)
    private Button register;

    @InjectView(R.id.get_package)
    @EventDelegate(isPassFastClick = true, delegateClass = View.OnClickListener.class, toEventController = MainEventController.class)
    private Button getInfo;

    @InjectView(R.id.get_json_data)
    @EventDelegate(isPassFastClick = true, delegateClass = View.OnClickListener.class, toEventController = MainEventController.class)
    private Button json;

    @InjectView(R.id.number)
    @EventDelegate(isPassFastClick = true, delegateClass = View.OnClickListener.class, toEventController = MainEventController.class)
    private Button number;

    @InjectView(R.id.info)
    private TextView info;

    @InjectView(R.id.amount)
    private EditText et_amount;

    @Override
    protected void doCreate(Bundle savedInstanceState) {
        super.doCreate(savedInstanceState);
    }

    private String jsonSource="[{ \"stu_no\":12345,\"stu_name\":\"John\",\"stu_sex\":\"male\"\n" +
            "},{ \"stu_no\":12346,\"stu_name\":\"Tom\",\"stu_sex\":\"male\"\n" +
            "},{\"stu_no\":12347,\"stu_name\":\"Lily\",\"stu_sex\":\"female\"}]";

    /**
     * 注册页面
     */
    public void goRegister(){


    }

    /**
     * 登陆页面
     */
    public void goLogin(){

    }

    public void numberFormat(){
        String amount=et_amount.getText().toString().trim();
        if(TextUtils.isEmpty(amount)){
            info.setText("et_amount is empty");
            return;
        }

        try {
            BigDecimal bd=new BigDecimal(amount);
        } catch (NumberFormatException e) {
            info.setText("数值的格式错误");
            et_amount.setText("");
            e.printStackTrace();
            return;
        }

        info.setText("et_amount是合法的数值");
    }

    /**
     * 解析json数据
     */
    public void getJsonData(){
        try {
            JSONArray jsonArray=new JSONArray(jsonSource);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(0);
                int stu_no=jsonObject.getInt("stu_no");
                String stu_name=jsonObject.getString("stu_name");
                String stu_sex=jsonObject.getString("stu_sex");
                Log.e(TAG, "getJsonData: stu_no="+stu_no+"; stu_name="+stu_name+"; stu_sex="+stu_sex);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param resolveInfos
     */

    public void plintPkgAndCls(List<ResolveInfo> resolveInfos){
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < resolveInfos.size(); i++) {
            String pkg = resolveInfos.get(i).activityInfo.packageName;
            String cls = resolveInfos.get(i).activityInfo.name;
            sb.append(pkg+"..."+cls+"\n");
        }
        info.setText(sb.toString());
    }

    public List<ResolveInfo> getResolveInfos(){
        List<ResolveInfo> appList = null;

        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        PackageManager pm = getPackageManager();
        appList = pm.queryIntentActivities(intent, 0);
        Collections.sort(appList, new ResolveInfo.DisplayNameComparator(pm));

        return appList;
    }


}
