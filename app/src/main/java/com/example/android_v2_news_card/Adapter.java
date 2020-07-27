package com.example.android_v2_news_card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    private List<String> data;

    Adapter(Context context, List<String> data){
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data; //это типо класса мои данные text,image
    }
    @NonNull
    @Override  //onCreateViewHolder: возвращает объект ViewHolder, который будет хранить данные по одному объекту Phone.
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.card_view,viewGroup,false);
        return new ViewHolder(view);
    }
    @Override  //onBindViewHolder: выполняет привязку объекта ViewHolder к объекту Phone по определенной позиции.
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String title = data.get(i);
        viewHolder.textTitle.setText(title);
    }
    @Override  //getItemCount: возвращает количество объектов в списке
    public int getItemCount() {
        return data.size();
    }


    //Для хранения данных в классе адаптера определен статический класс ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textTitle, textDescription;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitre);
            textDescription = itemView.findViewById(R.id.textDescription);
        }
    }
}