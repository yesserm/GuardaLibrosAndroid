package com.yesser.booknotes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_new_book.*

class EditBookActivity: AppCompatActivity() {

    var id: String ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_book)

        val bundle: Bundle? = intent.extras

        bundle?.let {
            id = bundle.getString("id")
            val book: String? = bundle.getString("book")
            val author: String? = bundle.getString("author")

            etAuthorName.setText(author)
            etBookName.setText(book)

        }

        btSave.setOnClickListener {
            val updatedAuthor: String = etAuthorName.text.toString()
            val updatedBook: String = etBookName.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra(ID,id)
            resultIntent.putExtra(UPDATED_AUTHOR, updatedAuthor)
            resultIntent.putExtra(UPDATED_BOOK, updatedBook)
            setResult(Activity.RESULT_OK, resultIntent)

            finish()
        }
        btCancel.setOnClickListener {
            finish()
        }
    }

    companion object {
        const val ID = "book_id"
        const val UPDATED_AUTHOR = "author_name"
        const val UPDATED_BOOK = "book_name"
    }
}