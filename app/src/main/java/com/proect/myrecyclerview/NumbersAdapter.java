package com.proect.myrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumbersAdapter  extends RecyclerView.Adapter<NumbersAdapter.NumbersViewHolder>{

    private static int viewHoldernumber;
    private int numberItem;
    private Context parent;

    public NumbersAdapter( int numberOfItems, Context parent){
        numberItem =  numberOfItems;
        viewHoldernumber = 0;


        this.parent = parent;
    }


    @NonNull
    @Override
    public NumbersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        int layoutIdForListItem = R.layout.number_list_item;
        LayoutInflater layoutInflater =LayoutInflater.from(context);
        View view = layoutInflater.inflate(layoutIdForListItem, parent, false);

        NumbersViewHolder numbersViewHolder =new NumbersViewHolder(view);
        numbersViewHolder.viewHolderIndex.setText("view holder index " + viewHoldernumber);
        viewHoldernumber++;
        return  numbersViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumbersViewHolder holder, int position) {
              holder.bind(position  );
    }

    @Override
    public int getItemCount() {
        return numberItem;
    }

    class NumbersViewHolder extends RecyclerView.ViewHolder{

        TextView listItemNumberview;
        TextView viewHolderIndex;

        public NumbersViewHolder(@NonNull View itemView) {
            super(itemView);

            listItemNumberview = itemView.findViewById(R.id.tv_number_item);

            viewHolderIndex = itemView.findViewById(R.id.tv_view_holder_number);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Toast toast = Toast.makeText(parent,"Element :"+ position+" was clicned ", Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
        }

        void bind(int index){

            listItemNumberview.setText(String.valueOf(index));
        }




    }
}
