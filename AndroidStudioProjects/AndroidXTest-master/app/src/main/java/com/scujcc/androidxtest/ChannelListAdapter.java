package com.scujcc.androidxtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListAdapter.ChannelViewHolder> {
    private List<Channel> channel;
    private ChannelClickListener listen;
    private Context context;

    public ChannelListAdapter(List<Channel> channel, ChannelClickListener listen) {
        this.listen = listen;
        this.channel = channel;
    }

    @NonNull
    @Override
    public ChannelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.channel, parent,false);
        ChannelViewHolder holder = new ChannelViewHolder(row);
        row.setOnClickListener(v -> listen.onClick(v, holder.getLayoutPosition()));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChannelViewHolder holder, int position) {
        holder.bind(context, channel.get(position));
    }

    @Override
    public int getItemCount() {
        return channel.size();
    }

    public class ChannelViewHolder extends RecyclerView.ViewHolder {
        private TextView biaoti;
        private TextView quality;
        private ImageView tubiao;

        public ChannelViewHolder(@NonNull View itemView) {
            super(itemView);
            biaoti = itemView.findViewById(R.id.title);
            quality = itemView.findViewById(R.id.quality);
            tubiao = itemView.findViewById(R.id.imageView);
        }

        public void bind(Context context, Channel c) {
            biaoti.setText(c.getTitle());
            quality.setText(c.getQuality());
            Glide.with(context)
                    .load("http://img2.imgtn.bdimg.com/it/u=1068336505,1629043357&fm=26&gp=0.jpg")
                    .override(300,300)
                    .into(tubiao);
        }
    }
}
