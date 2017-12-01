package demo.zxhua.daggerdemo.core.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import demo.zxhua.daggerdemo.BR;

/**
 * Created by Zxhua on 2017/11/30 0030.
 */

public class BindingAdapter extends RecyclerView.Adapter<BindingAdapter.BindingViewHolder> {
    private List<BindingAdapterItem> items = new ArrayList<BindingAdapterItem>();

    public void setItems(List<BindingAdapterItem> items) {
        this.items = items;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                viewType,
                parent,
                false);
        return new BindingViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        holder.bindData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getViewType();
    }

    class BindingViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding dataBinding;

        BindingViewHolder(ViewDataBinding dataBinding) {
            super(dataBinding.getRoot());
            this.dataBinding = dataBinding;
        }


        void bindData(BindingAdapterItem item) {
            dataBinding.setVariable(BR.item, item);
        }
    }
}
