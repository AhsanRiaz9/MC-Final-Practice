package com.example.mcfinalpractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper
{
    public static final String EMPLOYEE_TABLE = "Employee";
    public static final String EMPLOYEE_ID = "EmployeeId";
    public static final String EMPLOYEE_NAME = "EmployeeName";
    public static final String EMPLOYEE_JOB = "EmployeeJob";
    public static final String EMPLOYEE_SALARY = "EmployeeSalary";

    public DBHelper(@Nullable Context context)
    {
        super(context,"employeeDB.db",null,4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "Create Table " + EMPLOYEE_TABLE + "(" + EMPLOYEE_ID + " Integer Primary Key AUTOINCREMENT, " +
                EMPLOYEE_NAME + " Text, " + EMPLOYEE_JOB + " Text, " + EMPLOYEE_SALARY + " real )";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + EMPLOYEE_TABLE);
        onCreate(db);
    }

    public void addStudent(EmployeeModel emp)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(EMPLOYEE_NAME,emp.getName());
        cv.put(EMPLOYEE_JOB,emp.getJob());
        cv.put(EMPLOYEE_SALARY,emp.getSalary());
        db.insert(EMPLOYEE_TABLE, null, cv);
        db.close();
    }

    public ArrayList<EmployeeModel> getEmployeeList()
    {
        ArrayList<EmployeeModel> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + EMPLOYEE_TABLE,null);
        if(cursor.moveToFirst())
        {
            do{
                EmployeeModel emp  = new EmployeeModel(Integer.parseInt(cursor.getString(0)),cursor.getString(1), cursor.getString(2), Float.parseFloat(cursor.getString(3)));
                list.add(emp);
            }
            while(cursor.moveToNext());
        }
        db.close();
        cursor.close();
        return list;
    }

    public void deleteEmployee(EmployeeModel emp)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(EMPLOYEE_TABLE,EMPLOYEE_ID + " = ?", new String[]{Integer.toString(emp.getId())});
        //        db.execSQL("Delete From " + EMPLOYEE_TABLE + " where " + EMPLOYEE_ID +  " = " + emp.getId());
        db.close();
    }

    public void Update(EmployeeModel emp)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(EMPLOYEE_NAME, emp.getName());
        cv.put(EMPLOYEE_JOB,emp.getJob());
        cv.put(EMPLOYEE_SALARY,emp.getSalary());
        db.update(EMPLOYEE_TABLE,cv,EMPLOYEE_ID+"? ", new String[]{Integer.toString(emp.getId())});
        db.close();
    }
}
