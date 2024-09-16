package br.com.myapplication.android.banco

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

class DatabaseHelper(private val context: Context) {

    private val dbUrl = "jdbc:mysql://your-db-url"
    private val dbUser = "your-db-user"
    private val dbPassword = "your-db-password"

    private fun getConnection(): Connection {
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword)
    }

    fun getBooks(): List<String> {
        val books = mutableListOf<String>()
        val connection = getConnection()
        connection.use { conn ->
            conn.createStatement().use { statement ->
                val resultSet = statement.executeQuery("SELECT name FROM books")
                while (resultSet.next()) {
                    books.add(resultSet.getString("name"))
                }
            }
        }
        return books
    }

    fun getChapters(book: String): List<String> {
        val chapters = mutableListOf<String>()
        val connection = getConnection()
        connection.use { conn ->
            conn.createStatement().use { statement ->
                val resultSet = statement.executeQuery("""
                    SELECT chapter_number 
                    FROM chapters 
                    WHERE book_name = '$book'
                """)
                while (resultSet.next()) {
                    chapters.add("Capítulo ${resultSet.getInt("chapter_number")}")
                }
            }
        }
        return chapters
    }
}
