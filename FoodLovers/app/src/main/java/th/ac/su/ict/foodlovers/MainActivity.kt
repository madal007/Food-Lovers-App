package th.ac.su.ict.foodlovers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import th.ac.su.ict.foodlovers.Utils.getJsonDataFromAsset
import th.ac.su.ict.foodlovers.data.Food
import th.ac.su.ict.foodlovers.data.FoodAdapter

class MainActivity : AppCompatActivity() {

    var itemList:ArrayList<Food> = ArrayList<Food>()
    lateinit var arrayAdapter: ArrayAdapter<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var jsonFileString = getJsonDataFromAsset(applicationContext,"food_data.json")

        val gson = Gson()
        val listItemType = object :TypeToken<ArrayList<Food>>(){}.type

        var foodList : ArrayList<Food> = gson.fromJson(jsonFileString,listItemType)

//        Log.i("data",foodList[0].Foodname)

        itemList = foodList
        val adapter = FoodAdapter(this@MainActivity,itemList)

        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->

            var intent = Intent(this@MainActivity,DetailActivity::class.java)

            intent.putExtra("title",itemList[position].Foodname)
            intent.putExtra("caption",itemList[position].Descript)
            intent.putExtra("imageFiLe",itemList[position].Imagesfile)
            intent.putExtra("shopName",itemList[position].Shopname)
            intent.putExtra("rate",itemList[position].Popular)

            startActivity(intent)

        }

    }
}