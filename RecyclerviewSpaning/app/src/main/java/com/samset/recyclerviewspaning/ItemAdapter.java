package com.samset.recyclerviewspaning;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MtViewHolder> {
  private List<String> list;

  public ItemAdapter(int count) {
    list = new ArrayList<String>(count);
    for (int i = 0; i < count; ++i) {
      list.add("Item "+String.valueOf(i));
    }
  }

  @Override
  public MtViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
    return new MtViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final MtViewHolder holder, final int position) {
    final String label = list.get(position);
    holder.textView.setText(label);
    holder.textView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(holder.textView.getContext(), label, Toast.LENGTH_SHORT).show();
      }
    });
  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  public class MtViewHolder extends RecyclerView.ViewHolder {
    public TextView textView;
    public MtViewHolder(View itemView) {
      super(itemView);
      textView = (TextView) itemView.findViewById(R.id.text);
    }
  }
}