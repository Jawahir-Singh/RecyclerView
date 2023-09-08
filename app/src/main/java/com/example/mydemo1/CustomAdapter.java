package com.example.mydemo1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class CustomAdapter extends RecyclerView.Adapter <CustomAdapter.MyViewHolder>{


     private ArrayList<Integer> mImages = new ArrayList<Integer>();
     private ArrayList <String> personNames = new ArrayList<String>();
     private Context context;
     private View.OnClickListener onClickListener;

    public CustomAdapter(Context context, ArrayList<Integer> mImages, ArrayList<String>personNames) {
        this.context = context;
        this.mImages = mImages;
        this.personNames = personNames;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        Integer imageUrl = mImages.get(position);
        String name1 = personNames.get(position);

        holder.name.setText(name1);

        Glide.with(context)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.img);

        holder.name.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                Toast.makeText(context, ""+personNames.get(position), Toast.LENGTH_SHORT).show();
                  Intent intent = new Intent(context,MainActivity3.class);
                if (position == 0) {
                    intent.putExtra("description", "C is a general-purpose computer programming language");
                } else if (position == 1) {
                    intent.putExtra("description", "Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.");
                }
                else if (position == 2) {
                    intent.putExtra("description", "PHP is a general-purpose scripting language geared towards web development.");
                }
                else if (position == 3) {
                    intent.putExtra("description", "Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation.");
                }
                else if (position == 4) {
                    intent.putExtra("description", "JavaScript, often abbreviated as JS, is a programming language that is one of the core technologies of the World Wide Web, alongside HTML and CSS.");
                }
                else if (position == 5) {
                    intent.putExtra("description", "Angular is a TypeScript-based, free and open-source single-page web application framework led by the Angular Team at Google and by a community of individuals and corporations.");
                }
                else if (position == 6) {
                    intent.putExtra("description", "React is a free and open-source front-end JavaScript library for building user interfaces based on components.");
                }
                else if (position == 7) {
                    intent.putExtra("description", "Node.js is a cross-platform, open-source server environment that can run on Windows, Linux, Unix, macOS, and more.");
                }

                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {

        TextView name;
        CircleImageView img;
        public MyViewHolder(View itemView) {
            super(itemView);

            name =  itemView.findViewById(R.id.name);
            img=(CircleImageView)itemView.findViewById(R.id.img1);

        }
    }
}
