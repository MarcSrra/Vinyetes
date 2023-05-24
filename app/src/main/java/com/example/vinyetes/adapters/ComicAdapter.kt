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

class ComicAdapter (private val context: Context, private val Comics: MutableList<Comic>):
    RecyclerView.Adapter<ComicAdapter.ComicViewHolder>(),
    View.OnClickListener,
    View.OnLongClickListener
{
    private val layout = R.layout.comic_item
    private var clickListener : View.OnClickListener? = null
    private var longclicklistener: View.OnLongClickListener? = null
    class ComicViewHolder(val view: View): RecyclerView.ViewHolder(view)
    {
        var lblComicTitle: TextView
        var lblComicPrice: TextView
        var imgComicImage: ImageView

        init
        {
            imgComicImage = view.findViewById(R.id.ImgGridComic)
            lblComicPrice = view.findViewById(R.id.preugrid)
            lblComicTitle = view.findViewById(R.id.titolgrid)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        view.setOnClickListener(this)
        return ComicViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int)
    {
        val planet = Comics[position]
        bindPlanet(holder, planet)
    }

    fun bindPlanet(holder: ComicViewHolder, comic: Comic)
    {
        val planetPath = context.getFilesDir().toString() + "/img/" + comic.imatge
        val bitmap = BitmapFactory.decodeFile(planetPath)
        holder.imgComicImage?.setImageBitmap(bitmap)
        if(comic.titol.length > 21)
        {
            holder.lblComicTitle?.text = comic.titol.substring(0, 18) + "..."
        }
        else
        {
            holder.lblComicTitle?.text = comic.titol
        }
        holder.lblComicPrice?.text = comic.preu
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

    fun setOnLongClickListener(listener: View.OnLongClickListener)
    {
        longclicklistener = listener
    }

    override fun onLongClick(view: View?): Boolean {
        longclicklistener?.onLongClick(view)
        return true
    }

}