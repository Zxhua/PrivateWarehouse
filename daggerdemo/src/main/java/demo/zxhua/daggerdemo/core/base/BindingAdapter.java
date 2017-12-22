package demo.zxhua.daggerdemo.core.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import demo.zxhua.daggerdemo.BR;
import demo.zxhua.daggerdemo.databinding.ItemEditSelectComplexBinding;
import demo.zxhua.daggerdemo.ui.complex.ComplexListener;
import demo.zxhua.daggerdemo.utils.DialogUtils;
import demo.zxhua.daggerdemo.vo.ComplexVO;

/**
 * Created by Zxhua on 2017/11/30 0030.
 */

public class BindingAdapter extends RecyclerView.Adapter<BindingAdapter.BindingViewHolder> implements ComplexListener {
    private List<BindingAdapterItem> items = new ArrayList<BindingAdapterItem>();

    private SparseArrayCompat<BindingAdapterItem> mHeaderViews = new SparseArrayCompat<BindingAdapterItem>();

    private SparseArrayCompat<BindingAdapterItem> mFooterViews = new SparseArrayCompat<BindingAdapterItem>();

    public void addHeaderView(BindingAdapterItem headerView) {
        mHeaderViews.put(mHeaderViews.size(), headerView);
    }

    public void addFooterView(BindingAdapterItem footView) {
        mFooterViews.put(mHeaderViews.size() + items.size() + mFooterViews.size(), footView);
    }

    public int getHeaderViewCount() {
        return mHeaderViews.size();
    }

    public int getFooterViewCount() {
        return mFooterViews.size();
    }

    public boolean isHeaderViewPos(int position) {
        return position < getHeaderViewCount() && getHeaderViewCount() > 0;
    }

    public boolean isFooterViewPos(int position) {
        return position >= getHeaderViewCount() + items.size() && getFooterViewCount() > 0;
    }

    public void setItems(List<BindingAdapterItem> items) {
        this.items = items;
        notifyDataSetChanged();
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

        if (holder.dataBinding instanceof ItemEditSelectComplexBinding) {
            ((ItemEditSelectComplexBinding) holder.dataBinding).setListener(this);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeaderViewPos(position))
            return mHeaderViews.get(position).getViewType();
        if (isFooterViewPos(position))
            return mFooterViews.get(position).getViewType();
        return items.get(position).getViewType();
    }

    @Override
    public void onSelect(TextView view, ComplexVO item) {
        new DialogUtils()
                .showFilterDialog(view, view.getContext().getResources().getStringArray(item.resource.get()));

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
