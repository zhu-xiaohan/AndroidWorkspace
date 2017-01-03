package com.feicuiedu.android.bingoapp.activity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ViewUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.feicuiedu.android.bingoapp.R;
import com.feicuiedu.android.bingoapp.activity.base.BaseActivity;
import com.feicuiedu.android.bingoapp.pojo.User_;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SQLQueryListener;
import cn.bmob.v3.listener.SaveListener;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";


    private List<String> names = new ArrayList<>();


    private List<String> listData = new ArrayList<>();

    @ViewInject(R.id.tv_random)
    private TextView tvRandom;

    @ViewInject(R.id.btn_begin)
    private Button btnBegin;

    @ViewInject(R.id.lv_resut)
    private ListView lvResult;

   /* @ViewInject(R.id.pb_1)
    private ProgressBar pb1;

    @ViewInject(R.id.tv_progress)
    private TextView tvProgress;
*/
    private boolean isStop = true;

    private LayoutInflater lif;

    private int initDataSize = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        /*User_ user = new User_();

        user.setName("王金飞");
        user.setSex(1);
        user.setBirthday(new Date());

        user.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e==null){
                    System.out.println("添加数据成功，返回objectId为："+s);
                }else{

                    System.out.println("创建数据失败：" + e.getMessage());
                }
            }
        });

        user = new User_();

        user.setName("于坤巧");
        user.setSex(2);
        user.setBirthday(new Date());

        user.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e==null){
                    System.out.println("添加数据成功，返回objectId为："+s);
                }else{

                    System.out.println("创建数据失败：" + e.getMessage());
                }
            }
        });


        user = new User_();

        user.setName("李岩");
        user.setSex(1);
        user.setBirthday(new Date());

        user.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e==null){
                    System.out.println("添加数据成功，返回objectId为："+s);
                }else{

                    System.out.println("创建数据失败：" + e.getMessage());
                }
            }
        });

        user = new User_();

        user.setName("隋海波");
        user.setSex(1);
        user.setBirthday(new Date());

        user.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e==null){
                    System.out.println("添加数据成功，返回objectId为："+s);
                }else{

                    System.out.println("创建数据失败：" + e.getMessage());
                }
            }
        });*/

        // {"王金飞","于坤巧","立言","随海波","宅起炒"}
       /* names.add("王金飞");
        names.add("于坤巧");
        names.add("立言");
        names.add("随海波");
        names.add("宅起炒");
*/

        BmobQuery<User_> query = new BmobQuery<>();
        query.findObjects(new FindListener<User_>() {
            @Override
            public void done(List<User_> list, BmobException e) {
                for (User_ user:list) {
                    names.add(user.getName());
                }

                initDataSize = names.size();
                Log.d(TAG, "onCreate:"+names.toString());
            }
        });
        /*query.doSQLQuery(new SQLQueryListener<User_>() {
            @Override
            public void done(BmobQueryResult<User_> bmobQueryResult, BmobException e) {
                List<User_> lstUser = bmobQueryResult.getResults();

                for (User_ user:lstUser) {
                    names.add(user.getName());
                }
            }
        });*/


        lif = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        lvResult.setAdapter(ba);
    }

    @Event(value = R.id.btn_begin,type = View.OnClickListener.class)
    private void btnBeginOnClick(View view) {

        // Toast.makeText(this,"hhe",Toast.LENGTH_SHORT).show();
        MainAsyncTask asyncTask = new MainAsyncTask();

        if (isStop) {
            asyncTask.execute();
        }
        isStop = !isStop;
    }

    private BaseAdapter ba = new BaseAdapter() {
        @Override
        public int getCount() {
            return listData.size();
        }

        @Override
        public String getItem(int position) {
            return listData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;
            if(convertView==null){
                convertView=lif.inflate(R.layout.item, null);
                holder=new ViewHolder();
                x.view().inject(holder,convertView);
                convertView.setTag(holder);
            }
            else{
                holder=(ViewHolder) convertView.getTag();
            }

            holder.tvOrder.setText((position + 1) + "");
            holder.tvName.setText(getItem(position));


            return convertView;
        }
    };

    private class ViewHolder{

        @ViewInject(R.id.item_tv_order)
        private TextView tvOrder;

        @ViewInject(R.id.item_tv_name)
        private TextView tvName;
    }

    private class MainAsyncTask extends AsyncTask<Void,String,String[]>{

        @Override
        protected String[] doInBackground(Void... params) {
            String strReturn = null;

            String tmpName= null;
            Random random = new Random();
            while(true) {

                if (isStop) {

                    if (!listData.contains(tmpName)) {
                        if (listData.size() <= initDataSize) {
                            listData.add(tmpName);
                        }
                    }

                    names.remove(tmpName);
                    break;
                }

                if (names.size() == 0) {
                    return null;
                }
                int tmpIndex = random.nextInt(names.size());
                tmpName = names.get(tmpIndex);
                publishProgress(tmpName);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }



            }

            Log.d(TAG, "doInBackground: "+listData.toString());
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            tvRandom.setText(values[0]);
        }


        @Override
        protected void onPostExecute(String[] str) {
            //super.onPostExecute(str);

            ba.notifyDataSetChanged();
        }
    };
}
