package com.example.vinyetes.acttivities

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vinyetes.datamodels.Comic
import com.example.vinyetes.adapters.ComicRelacionatAdapter
import com.example.vinyetes.R
import com.example.vinyetes.fragments.DetailFragment


class ComicDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.comic_detail)

        val intent = getIntent()
        val comic = intent.extras?.getSerializable("comic") as Comic
        val comiclist = intent.extras?.getSerializable("comics") as MutableList<Comic>

        var manager = supportFragmentManager
        var fragment = manager.findFragmentById(R.id.FrgDetail) as DetailFragment


        fragment.omplirDades(comic, comiclist)
    }

}