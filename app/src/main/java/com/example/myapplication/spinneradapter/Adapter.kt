package com.example.myapplication.spinneradapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.CategorySingleitemBinding
import java.util.Locale.Category

class Adapter(var categoryData:List<CategoryData>):BaseAdapter() {
    override fun getCount(): Int {
        return categoryData.size
    }

    override fun getItem(position: Int): Any {
        return categoryData.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var myView:View?=convertView
        val categoryItem:viewHolder

        if (myView ==null){
            val viewBinding:CategorySingleitemBinding=DataBindingUtil.inflate(LayoutInflater.from(parent?.context),
                R.layout.category_singleitem,parent,false)
            myView=viewBinding.root
            categoryItem=viewHolder(viewBinding)
            myView.tag=categoryItem
        }else{
            categoryItem=myView.tag as viewHolder
        }
        categoryItem.bind(categoryData[position])
        return myView
    }

    class viewHolder(val viewBinding:CategorySingleitemBinding ){
        fun bind(categoryy:CategoryData){
            viewBinding.categoryImg.setImageResource(categoryy.imgResource)
            viewBinding.categoryName.text=categoryy.name

        }

    }
}