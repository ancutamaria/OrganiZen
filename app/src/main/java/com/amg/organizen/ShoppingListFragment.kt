package com.amg.organizen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amg.organizen.model.ShoppingItem

private const val TAG = "ShoppingListFragment"

class ShoppingListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var adapter: ShoppingListFragment.ShoppingListAdapter? = null

    companion object {
        @JvmStatic
        fun newInstance(): ShoppingListFragment {
            return ShoppingListFragment()
        }
    }

    private val shoppingListViewModel: ShoppingListViewModel by lazy {
        ViewModelProviders.of(this).get(ShoppingListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.shopping_list_frament, container, false)
        recyclerView = view.findViewById(R.id.shopping_list_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        updateUI()
        return view
    }

    private fun updateUI(){
        val books = shoppingListViewModel.shoppingItems
        adapter = ShoppingListAdapter(books)
        recyclerView.adapter = adapter
    }

    private inner class ShoppingItemHolder(view: View): RecyclerView.ViewHolder(view){
        val shoppingItemTitle = view.findViewById<TextView>(R.id.shopping_item_title)
    }

    private inner class ShoppingListAdapter(var shoppingItems: List<ShoppingItem>)
        : RecyclerView.Adapter<ShoppingItemHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemHolder {
            val view = layoutInflater.inflate(R.layout.shopping_list_item, parent, false)
            return ShoppingItemHolder(view)
        }

        override fun onBindViewHolder(holder: ShoppingItemHolder, position: Int) {
            val shoppingItem = shoppingItems[position]
            holder.apply {
                shoppingItemTitle.text = shoppingItem.title
            }
        }

        override fun getItemCount() = shoppingItems.size

    }
}