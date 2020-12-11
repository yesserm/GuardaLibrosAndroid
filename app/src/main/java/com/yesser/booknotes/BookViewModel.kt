package com.yesser.booknotes

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class BookViewModel(application: Application) : AndroidViewModel(application) {

    val allBooks: LiveData<List<Book>>
    private val bookDao: BookDao

    init{
        val bookDb = BookRoomDatabase.getDatabase(application)
        bookDao = bookDb!!.bookDao()
        allBooks = bookDao.allBooks
    }
    fun insert(book: Book){
        InsertAsyncTask(bookDao).execute(book)
    }

    companion object {
        private class InsertAsyncTask(private val bookDao: BookDao): AsyncTask<Book, Void, Void>(){
            override fun doInBackground(vararg p0: Book): Void? {
                bookDao.Insert(p0[0])
                return null
            }
        }
    }
}