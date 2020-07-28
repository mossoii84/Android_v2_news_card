package com.example.android_v2_news_card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

// это Вариант 1 где мы не создаем доп класс NewsItems а получаем наши переменные из data(встроенные класс)
// при таком варианте сложно добавлять и удалять переменные и выводить их на экран
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    private List<String> data; //наши переменные(textTitle,image,textDescription) без создания доп класса

    // данный код позволил нам не создовать доп класс с нашими переменными, а получаем все через data
    Adapter(Context context, List<String> data){
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data; //это типо класса мои данные text,image
    }
    @NonNull
    @Override  //onCreateViewHolder: возвращает объект ViewHolder, который будет хранить данные по одному объекту Items.
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.card_view,viewGroup,false);
        return new ViewHolder(view);
    }
    @Override  //onBindViewHolder: выполняет привязку объекта ViewHolder к объекту Items по определенной позиции.
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
        ImageView imageView;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitre);
            textDescription = itemView.findViewById(R.id.textDescription);
            imageView = imageView.findViewById(R.id.imageView);

        }
    }
}