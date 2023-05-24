package com.example.vinyetes.acttivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vinyetes.datamodels.Comic
import com.example.vinyetes.adapters.ComicAdapter
import com.example.vinyetes.R
import com.example.vinyetes.fragments.DetailFragment
import com.example.vinyetes.fragments.ListFragment
import com.example.vinyetes.fragments.MyOnClickListener
import java.io.Serializable

class MainActivity : AppCompatActivity(), MyOnClickListener
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainFragment = supportFragmentManager.findFragmentById(R.id.FrgList) as ListFragment
        mainFragment.setListener(this)
    }

    override fun onClick(comic: Comic, comics: MutableList<Comic>)
    {
        val secondFragment = supportFragmentManager.findFragmentById(R.id.FrgDetail) as DetailFragment?

        if(secondFragment == null)//Móbil
        {
            val intent = Intent(this, ComicDetail::class.java)
            intent.putExtra("comic", comic as Serializable)
            intent.putExtra("comics", comics as Serializable)
            startActivity(intent)
        }
        else //tablet
        {
            secondFragment.omplirDades(comic, comics)
        }
    }
}