package org.evilbinary.tv;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import org.evilbinary.tv.widget.BorderView;

/**
 * 作者:evilbinary on 2/20/16.
 * 邮箱:rootdebug@163.com
 */
public class DemoTwoRecyclerViewActivity extends Activity {

    private BorderView border;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_two_recycler_view);

        border = new BorderView(this);
        border.setBackgroundResource(R.drawable.border_white_light_10);
        border.getEffect().setMargin(12);
        border.attachTo((ViewGroup) getWindow().getDecorView());


        testRecyclerViewLinerLayout();
        testRecyclerViewGridLayout();


    }


    private void testRecyclerViewLinerLayout() {
        //test linearlayout
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.firstRecyclerView);
        // 创建一个线性布局管理器
        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        createData(recyclerView,R.layout.item3);

    }

    private void testRecyclerViewGridLayout() {
        //test grid
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.secondRecyclerView);
        GridLayoutManager gridlayoutManager = new GridLayoutManager(this, 4);
        gridlayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridlayoutManager);
        createData(recyclerView,R.layout.item);

    }


    private void createData(RecyclerView recyclerView,int id) {
        //创建数据集
        String[] dataset = new String[100];
        for (int i = 0; i < dataset.length; i++) {
            dataset[i] = "item" + i;
        }
        // 创建Adapter，并指定数据集
        MyAdapter adapter = new MyAdapter(this, dataset,id);
        // 设置Adapter
        recyclerView.setAdapter(adapter);
        recyclerView.scrollToPosition(0);
    }


}
