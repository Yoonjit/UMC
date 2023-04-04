package com.example.week8_1

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week8_1.databinding.ActivityMainBinding
import com.example.week8_1.db.AppDatabase
import com.example.week8_1.db.MemoDao
import com.example.week8_1.db.MemoEntity

class MainActivity : AppCompatActivity(), OnItemLongClickListener {
    private lateinit var binding: ActivityMainBinding

    private lateinit var db: AppDatabase
    private lateinit var memoDao: MemoDao
    private lateinit var memoList: ArrayList<MemoEntity>
    private lateinit var adapter: MemoRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        binding.btnMovestar.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        db = AppDatabase.getInstance(this)!!
        memoDao = db.getMemoDao()

        getAllMemoList()
    }

    private fun getAllMemoList(){
        Thread{
            memoList = ArrayList(memoDao.getAll())
            setRecyclerView()
        }.start()
    }

    private fun setRecyclerView(){
        runOnUiThread{
            adapter = MemoRVAdapter(memoList, this)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
        }
    }

    override fun onRestart() {
        super.onRestart()
        getAllMemoList()
    }

    override fun onLongClick(position: Int) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)

        builder.setTitle("메모 삭제")
        builder.setMessage("진짜로?")
        builder.setNegativeButton("ㄴㄴ", null)
        builder.setPositiveButton("ㅇㅇ",
            object: DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    deleteMemo(position)
                }
            })
        builder.show()
    }

    private fun deleteMemo(position: Int){
        Thread{
            memoDao.deleteMemo(memoList[position])
            memoList.removeAt(position)
            runOnUiThread{
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "삭제 완료", Toast.LENGTH_SHORT).show()
           }
        }.start()
    }
}