package com.example.vinyetes.adapters

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vinyetes.datamodels.Comic
import com.example.vinyetes.R

class ComicRelacionatAdapter (private val context: Context, private val Comics: MutableList<Comic>):
    RecyclerView.Adapter<ComicRelacionatAdapter.ComicRelacionatViewHolder>(),
    View.OnClickListener,
    View.OnLongClickListener
{
    private val layout = R.layout.comic_item_petit
    private var clickListener : View.OnClickListener? = null
    private var longclicklistener: View.OnLongClickListener? = null
    class ComicRelacionatViewHolder(val view: View): RecyclerView.ViewHolder(view)
    {
        var lblComicTitle: TextView
        var imgComicImage: ImageView

        init
        {
            imgComicImage = view.findViewById(R.id.ImgListPetita)
            lblComicTitle = view.findViewById(R.id.titolListPetita)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicRelacionatViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        view.setOnClickListener(this)
        return ComicRelacionatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComicRelacionatViewHolder, position: Int)
    {
        val planet = Comics[position]
        bindPlanet(holder, planet)
    }

    fun bindPlanet(holder: ComicRelacionatViewHolder, comic: Comic)
    {
        val planetPath = context.getFilesDir().toString() + "/img/" + comic.imatge
        val bitmap = BitmapFactory.decodeFile(planetPath)
        holder.imgComicImage?.setImageBitmap(bitmap)
        if(comic.titol.length > 13)
        {
            holder.lblComicTitle?.text = comic.titol.substring(0, 10) + "..."
        }
        else
        {
            holder.lblComicTitle?.text = comic.titol
        }

    }

    override fun getItemCount() = Comics.size

    fun setOnClickListener(listener: View.OnClickListener)
    {
        clickListener = listener
    }

    override fun onClick(view: View?)
    {
        clickListener?.onClick(view)
    }

    fun setOnClickListener(listener: View.OnLongClickListener)
    {
        longclicklistener = listener
    }

    override fun onLongClick(view: View?): Boolean {
        longclicklistener?.onLongClick(view)
        return true
    }

}