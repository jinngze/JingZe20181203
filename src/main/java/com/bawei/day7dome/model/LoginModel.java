package com.bawei.day7dome.model;

import com.bawei.day7dome.bean.NewsBean;
import com.bawei.day7dome.bean.UserBean;
import com.bawei.day7dome.utils.HttpUtil;

import java.util.List;

public class LoginModel{

    IModel iModel;

    public void login(String username, String pwd, final IModel iModel){
        HttpUtil.getRequest("http://www.xieast.com/api/user/login.php?username="+username+"&password="+pwd,
                UserBean.class, new HttpUtil.CallBack<UserBean>() {
                    @Override
                    public void getdata(UserBean userBean) {
                        int code = userBean.getCode();
                        if(code==100){
                            iModel.success(userBean.getMsg());
                        }else if(code==101){
                            iModel.success(userBean.getMsg());
                        }else if(code==102){
                            iModel.success(userBean.getMsg());
                        }else if(code==103){
                            iModel.success(userBean.getMsg());
                        }
                    }
                });
    }

    public void show(final IModel iModel){
        HttpUtil.getRequest("http://www.xieast.com/api/news/news.php",
                NewsBean.class, new HttpUtil.CallBack<NewsBean>() {
            @Override
            public void getdata(NewsBean newsBean) {
                iModel.success(newsBean);
            }

        });
    }
}
