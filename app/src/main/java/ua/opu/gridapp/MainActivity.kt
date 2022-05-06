package ua.opu.gridapp

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import ua.opu.gridapp.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ItemAdapter(layoutInflater) {
            val dialog = ItemDialog.newInstance(it.number)
            dialog.show(supportFragmentManager, "dlg")
        }
        binding.list.adapter = adapter
        binding.list.layoutManager = GridLayoutManager(this, 4)
        adapter.submitList(initList())
    }

    private fun initList(): MutableList<Item> {
        var resultList = mutableListOf<Item>()
        for (i in 1..40) {
            val number = (1..99).random()
            val rnd = Random()
            val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            resultList.add(Item(number, color))
        }

        return resultList
    }


    data class Item(var number: Int, var color: Int)


}