package th.ac.su.ict.foodlovers.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.list_item_food.view.*
import th.ac.su.ict.foodlovers.R
import java.util.zip.Inflater
import javax.sql.CommonDataSource

class FoodAdapter(private val context: Context,private val dataSource: ArrayList<Food>) : BaseAdapter(){

    private val inflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.list_item_food,null)

        rowView.tvTitle.text = dataSource[position].Foodname
        rowView.tvSubtitle.text = dataSource[position].Shopname
//        rowView.rtbStar.rating = dataSource[position].Popular.toFloat()
        rowView.tvPrice.text = dataSource[position].Price.toString()


        val res = context.resources
        val drawableId : Int = res.getIdentifier(dataSource[position].Imagesfile,"drawable",context.packageName)
        val drawablePp : Int = res.getIdentifier(dataSource[position].Popular,"drawable",context.packageName)

        rowView.imgThumbnail.setImageResource(drawableId)
        rowView.rtbStar.setImageResource(drawablePp)

        return rowView

    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {

        return dataSource.size
    }

}