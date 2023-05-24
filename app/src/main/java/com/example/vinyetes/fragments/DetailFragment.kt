package com.example.vinyetes.fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vinyetes.R
import com.example.vinyetes.adapters.ComicRelacionatAdapter
import com.example.vinyetes.datamodels.Comic

class DetailFragment: Fragment()
{
    lateinit var myView: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myView = inflater.inflate(R.layout.fragment_detail, container, false)

        val back = myView.findViewById<ImageView>(R.id.toolbarback)


        return myView
    }

    fun omplirDades(comic: Comic, comiclist: MutableList<Comic>)
    {
        val scroll = myView.findViewById<LinearLayout>(R.id.fragmentscrolldetail)


        val titolcomic = myView.findViewById<TextView>(R.id.nomcomicdetail)
        val autorcomic = myView.findViewById<TextView>(R.id.autordetail)
        val imgcomic = myView.findViewById<ImageView>(R.id.imagecomicdetail)
        val demografiacomic = myView.findViewById<TextView>(R.id.demografiacomicdetail)
        val generescomic = myView.findViewById<TextView>(R.id.generescomicdetail)
        val sinopsiscomic = myView.findViewById<TextView>(R.id.sinopsiscomicdetail)
        val preucomic = myView.findViewById<TextView>(R.id.preucomicdetail)
        val editorialcomic = myView.findViewById<TextView>(R.id.editorialdetail)
        val eancomic = myView.findViewById<TextView>(R.id.eandetail)
        val publicaciocomic = myView.findViewById<TextView>(R.id.publicaciodetail)

        val lstcomics = myView.findViewById<RecyclerView>(R.id.listRelacionat)
        val adapter = ComicRelacionatAdapter(myView.context, comiclist)
        lstcomics.hasFixedSize()
        lstcomics.layoutManager = LinearLayoutManager(myView.context, LinearLayoutManager.HORIZONTAL, false)
        lstcomics.adapter = adapter

        if(comic.titol.length > 25){
            titolcomic.text = comic.titol.substring(0, 22) + "..."
        }
        else{
            titolcomic.text = comic.titol
        }

        scroll.isVisible = true


        //titolcomic.text = comic.titol
        autorcomic.text = comic.autor
        val planetPath = myView.context.getFilesDir().toString() + "/img/" + comic.imatge
        val bitmap = BitmapFactory.decodeFile(planetPath)
        imgcomic.setImageBitmap(bitmap)
        demografiacomic.text = comic.demografia

        var generes: String = ""
        val numgeneres: Int = comic.subgeneres.size - 1
        var counter: Int = 0;
        for(genere in comic.subgeneres)
        {
            if (counter < numgeneres){
                generes += genere + ", "
            }
            else
            {
                generes += genere
            }
            counter++
        }

        generescomic.text = generes

        if(comic.sinopsis.length > 163){
            sinopsiscomic.text = comic.sinopsis.substring(0, 160) + "..."
        }
        else{
            sinopsiscomic.text = comic.sinopsis
        }

        preucomic.text = comic.preu
        editorialcomic.text = comic.editorial
        eancomic.text = comic.ean
        publicaciocomic.text = comic.publicacio
    }
}