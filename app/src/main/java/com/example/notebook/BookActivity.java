package com.example.notebook;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

//需要一个额外的活动来作为笔记本的详情展示页面
public class BookActivity extends AppCompatActivity {
    public static final String BOOK_NAME ="book_name";
    public static final String BOOK_IMAGE_ID="book_image_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Intent intent=getIntent();//通过intent获取笔记本的名和资源id
        String bookName=intent.getStringExtra(BOOK_NAME);
        int bookImageId=intent.getIntExtra(BOOK_IMAGE_ID,0);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);//通过findViewByID拿到布局文件中控件的实例
        CollapsingToolbarLayout collapsingToolbarLayout =(CollapsingToolbarLayout)
                findViewById(R.id.collapsing_toolbar);
        ImageView bookImageView=(ImageView) findViewById(R.id.book_image_view);
        TextView bookContentText =(TextView) findViewById(R.id.book_content_text);

        setSupportActionBar(toolbar);//使用toolbar的标准用法，将它作为ActionBar显示
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!= null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //启用HOmeAsUp，而他的默认按钮是返回箭头，导航按钮homeasup
        }
        //开始填充界面的内容
        collapsingToolbarLayout.setTitle(bookName);//将笔记名设置为当前界面的标题
        Glide.with(this).load(bookImageId).into(bookImageView);
        //用Glide加载笔记图片，并设置到标题栏的ImageView上面
        String bookContent=generateBookContent(bookName);
        bookContentText.setText(bookContent);
    }//这里是例子，加到了textview上。如果有真实数据 要用来替换
    private String generateBookContent(String bookName)
    {
        StringBuilder bookContent=new StringBuilder();//可以对字符串进行修改
            bookContent.append(bookName);//将指定的字符串加到此字符序列
        return bookContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)//处理HomeAsUp的按钮点击事件
    {
        switch(item.getItemId()){
            case android.R.id.home://点击按钮
                finish();//finish关闭当前活动。从而返回上个活动
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
