package br.com.myapplication

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform