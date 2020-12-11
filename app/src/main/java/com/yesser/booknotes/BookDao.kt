package com.yesser.booknotes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BookDao {
    @Insert
    fun Insert(book:Book)

    @get:Query("SELECT * FROM books")
    val allBooks: LiveData<List<Book>>

    @Update
    fun update(book: Book)

    @Delete
    fun delete(book: Book)
}