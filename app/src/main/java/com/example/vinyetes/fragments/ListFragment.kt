package com.example.vinyetes.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vinyetes.R
import com.example.vinyetes.acttivities.ComicDetail
import com.example.vinyetes.adapters.ComicAdapter
import com.example.vinyetes.datamodels.Comic
import java.io.Serializable

class ListFragment: Fragment()
{
    private lateinit var listener: MyOnClickListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_list, container, false)
        val comics = getComics()

        val lstcomics = view.findViewById<RecyclerView>(R.id.gridnovedades)

        val adapter = ComicAdapter(view.context, comics)
        lstcomics.hasFixedSize()
        lstcomics.layoutManager = GridLayoutManager(view.context, 2)
        lstcomics.adapter = adapter

        adapter.setOnClickListener()
        {
            val comic = comics[lstcomics.getChildAdapterPosition(it)]
            listener.onClick(comic, comics)

        }


        return view
    }

    fun getComics(): MutableList<Comic>
    {
        return mutableListOf(
            Comic("LOOK BACK", "14,00", "lookback.jpg","Tatsuki Fujimoto",
                resources.getString(R.string.lookbacksinopsi), "Shonen", listOf("Drama", "Psicològic"),
                "Norma Editorial", "9788467959710", "3/2/2023"),
            Comic("CHAINSAW MAN 5", "9,00", "chainsawman5.jpg","Tatsuki Fujimoto",
                resources.getString(R.string.chainsawman5sinopsi), "Shonen", listOf("Gore", "Batalles", "Psicològic"),
                "Norma Editorial", "9788467957488", "17/2/2023"),
            Comic("JUJUTSU KAISEN 4", "8,00", "jujutsukaisen4.jpg","Gege Akutami",
                resources.getString(R.string.jujutsukaisen4sinopsi), "Shonen", listOf("Gore", "Batalles"),
                "Norma Editorial", "9788467957587", "17/2/2023"),
            Comic("ONE PIECE 1", "9,00", "onepiece1.jpg","Eichiro Oda",
                resources.getString(R.string.onepiece1sinopsi), "Shonen", listOf("Aventura", "Batalles"),
                "Planeta Cómic", "9788411406758", "05/04/2023"),
            Comic("HAIKYÛ!! 1", "9,00", "haikyuu1.jpg","Haruichi Furudate",
                resources.getString(R.string.haikyu1sinopsi), "Shonen", listOf("Esport", "Instituts"),
                "Planeta Cómic", "9788411407465", "05/04/2023"),
            Comic("GUARDIANS DE LA NIT 3", "8,00", "guardians3.jpg","Koyoharu Gotouge",
                resources.getString(R.string.guardians3sinopsi), "Shonen", listOf("Aventura", "Batalles", "Dimonis", "Fantasia"),
                "Norma Editorial", "9788467958492", "13/01/2023"),
            Comic("NEON GENESIS EVANGELION 1", "14,95", "evangelion1.jpg","Yoshiyuki Sadamoto / Khara",
                resources.getString(R.string.evangelion1sinopsi), "Shonen", listOf("Drama", "Mecha", "Ciència Ficció"),
                "Norma Editorial", "9788467959932", "31/03/2023"),
            Comic("RANMA 1/2 1", "14,95", "ranma1.jpg","Rumiko Takahashi",
                resources.getString(R.string.ranma1sinopsi), "Shonen", listOf("Aventura", "Humor"),
                "Planeta Cómic", "9788416636761", "31/03/2023"))
    }

    fun setListener(listen: MyOnClickListener?)
    {
        if (listen != null)
        {
            listener = listen
        }
    }
}

