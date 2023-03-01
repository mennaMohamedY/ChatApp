package com.example.myapplication.spinneradapter

import com.example.myapplication.R

data class CategoryData(
    var id:String,
    var imgResource:Int,
    var name:String
){
    companion object{
        const val music="Music"
        const val sports="Sports"
        const val movies="Movies"

        fun createObjects(categId:String):CategoryData{
            when(categId){
                music->return CategoryData(music, R.drawable.music,"Music")
                sports->return CategoryData(sports, R.drawable.sports,"Sports")
                movies->return CategoryData(movies, R.drawable.movies,"Movies")
                else->return CategoryData(music, R.drawable.movies,"Music")
            }
        }

        fun getCategories():List<CategoryData>{
            return listOf(
                createObjects(music)
                ,createObjects(sports),
                createObjects(movies)
            )
        }
    }
}
