package com.chenjimou.homepagersecondlinkdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContentFragment extends Fragment {

    private final List<String> contents = new ArrayList<>();
    private static final String CONTENT = "内容item";
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        init();
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    private void init() {
        for (int i = 0; i < 20; i++) {
            contents.add(CONTENT + i);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (null == getContext()){
            return;
        }
        recyclerView = view.findViewById(R.id.rv_below);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new RecyclerViewAdapter());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

        @NonNull
        @Override
        public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(getContext())
                    .inflate(R.layout.rv_below_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
            holder.tv.setText(contents.get(position));
        }

        @Override
        public int getItemCount() {
            return contents.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView tv;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tv = itemView.findViewById(R.id.tv_below_item);
            }
        }
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
