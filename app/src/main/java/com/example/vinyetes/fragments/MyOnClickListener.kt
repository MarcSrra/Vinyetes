package com.example.vinyetes.fragments

import com.example.vinyetes.datamodels.Comic

interface MyOnClickListener {
    fun onClick(comic: Comic, comics: MutableList<Comic>)
}