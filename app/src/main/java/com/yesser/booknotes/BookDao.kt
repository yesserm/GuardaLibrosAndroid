package com.yesser.booknotes

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDao {
    @Insert
    fun Insert(book:Book)

    @get:Query("SELECT * FROM books")
    val allBooks: LiveData<List<Book>>
}