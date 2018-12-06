package com.bawei.day7dome.presenter;


import com.bawei.day7dome.model.IModel;
import com.bawei.day7dome.model.LoginModel;
import com.bawei.day7dome.view.IView;

import java.util.List;

public class Loginpresenter implements Ipresenter{

        private IView Miview;
        private LoginModel model;

    public Loginpresenter(IView miview) {
        Miview = miview;
        model = new LoginModel();
    }

    public void login(String username,String pwd){
       model.login(username, pwd, new IModel() {
           @Override
           public void success(Object data) {
               Miview.showData(data);
           }
       });
    }

    public void show(){
        model.show(new IModel() {
            @Override
            public void success(Object data) {
                Miview.showData(data);
            }

        });
    }


    public void onDetach(){
        if (model!=null){
            model = null;
        }
        if (Miview!=null){
            Miview = null;
        }
    }
}
