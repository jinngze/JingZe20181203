package com.bawei.day7dome.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.bawei.day7dome.R;
import com.bawei.day7dome.bean.NewsBean;
import com.bawei.day7dome.dapter.MyAdapter;
import com.bawei.day7dome.presenter.Ipresenter;
import com.bawei.day7dome.presenter.Loginpresenter;

import java.util.List;

public class Main2Activity extends AppCompatActivity implements IView {

    private ListView listView;
    private MyAdapter md;
    private Loginpresenter loginpresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.lv);
        md = new MyAdapter(this);
        listView.setAdapter(md);


        loginpresenter = new Loginpresenter(this);

        loginpresenter.show();

    }


//    @Override
//    public void setdata(Object data) {
//        md.setData(data);
//    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginpresenter.onDetach();
    }

    @Override
    public void showData(Object data){
        NewsBean newsBean= (NewsBean)data;
        List<NewsBean.DataBean> data1 = newsBean.getData();
        md.setData(data1);
    }
}
