package nextinnovation.com.databasefromassest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by PT on 10/6/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context context  ;
    private ArrayList<Student> studentArrayList;

    public RecyclerAdapter(Context context , ArrayList<Student> studentArrayList){
            this.context = context ;
            this.studentArrayList = studentArrayList  ;
    }

    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_student, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyViewHolder holder, int position) {

        holder.txtName.setText(studentArrayList.get(position).getName());
        holder.txtId.setText(String.valueOf(studentArrayList.get(position).getStudentId()));
        holder.txtAddress.setText(studentArrayList.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName , txtId , txtAddress ;
        public MyViewHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_name);
            txtId = itemView.findViewById(R.id.txt_id);
            txtAddress = itemView.findViewById(R.id.txt_address);

        }
    }


}
