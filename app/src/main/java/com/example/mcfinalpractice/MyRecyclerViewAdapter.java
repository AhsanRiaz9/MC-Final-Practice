package com.example.mcfinalpractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>
{

    List<EmployeeModel> empList;

    public MyRecyclerViewAdapter(List<EmployeeModel> empList)
    {
        this.empList = empList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.employeeitem,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.emp =empList.get(position);
        holder.id.setText("Employee Id: " + holder.emp.getId());
        holder.name.setText(holder.emp.getName());
        holder.job.setText(holder.emp.getJob());
        holder.salary.setText("Salary: " + holder.emp.getSalary());
        holder.employeeImg.setImageResource(R.drawable.img);
    }

    @Override
    public int getItemCount() {
        return empList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView employeeImg;
        TextView id, name, job, salary;
        EmployeeModel emp;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            employeeImg = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.employeeNameText);
            job = itemView.findViewById(R.id.employeeJobText);
            salary = itemView.findViewById(R.id.employeeSalaryText);
            id = itemView.findViewById(R.id.employeeIdText);
        }
    }

}
