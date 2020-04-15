package com.example.notebook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private Context mContext;
    private List<Book> mBookList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView bookImage;
        TextView bookName;

        public ViewHolder(View view)
        {
            super(view);
            cardView=(CardView) view;
            bookImage=(ImageView) view.findViewById(R.id.book_image);
            bookName =(TextView) view.findViewById(R.id.book_name);
        }
    }
    public BookAdapter (List<Book> bookList)
    {
        mBookList=bookList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        if (mContext==null)
        {
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.book_item,parent,false);

        final ViewHolder holder=new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener(){//给cardView注册点击事件的监听器
            @Override
            public void onClick(View v){//在点击事件中，获得点击项的名字和id，传入到intent
                int position =holder.getAdapterPosition();
                Book book=mBookList.get(position);
                Intent intent=new Intent(mContext,BookActivity.class);
                intent.putExtra(BookActivity.BOOK_NAME,book.getName());
                intent.putExtra(BookActivity.BOOK_IMAGE_ID,book.getImageId());
                mContext.startActivity(intent);//调用startActivity启动BookActivity
            }
        });
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position)
    {
        Book book=mBookList.get(position);
        holder.bookName.setText(book.getName());
        Glide.with(mContext).load(book.getImageId()).into(holder.bookImage);
    }
    @Override
    public int getItemCount(){
        return mBookList.size();
    }
}



