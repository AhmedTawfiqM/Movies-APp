package com.moviesapp.atdev.pojo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.moviesapp.atdev.R;
import com.moviesapp.atdev.databinding.CastDataBinding;
import com.moviesapp.atdev.pojo.models.Cast;

import java.util.List;


public class CastAdapter extends RecyclerView.Adapter<CastAdapter.viewHolder> {

    private Context context;
    private List<Cast> castList;

    public CastAdapter(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        CastDataBinding castDataBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.cast_item, viewGroup, false);
        return new viewHolder(castDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        Cast cast = castList.get(i);
        if(cast != null){
            viewHolder.bindCast(cast);
        }
    }

    @Override
    public int getItemCount() {
        return castList!=null? castList.size():0;
    }

    public void setCast(List<Cast> castList){
        this.castList = castList;
    }

    class viewHolder extends RecyclerView.ViewHolder{

        CastDataBinding castDataBinding;
        viewHolder(CastDataBinding castDataBinding) {
            super(castDataBinding.getRoot());
            this.castDataBinding = castDataBinding;
        }

        void bindCast(Cast cast) {
            castDataBinding.setCast(cast);
        }
    }
}
